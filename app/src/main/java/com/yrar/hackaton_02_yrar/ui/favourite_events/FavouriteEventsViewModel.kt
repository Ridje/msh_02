package com.yrar.hackaton_02_yrar.ui.favourite_events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yrar.hackaton_02_yrar.model.app.Event
import com.yrar.hackaton_02_yrar.model.database.EventEntity
import com.yrar.hackaton_02_yrar.model.database.UserEventEntity
import com.yrar.hackaton_02_yrar.repository.RepositoryLocal
import com.yrar.hackaton_02_yrar.repository.RepositoryNetwork
import com.yrar.hackaton_02_yrar.ui.events.EventsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteEventsViewModel @Inject constructor(val repositoryNetwork: RepositoryNetwork, val repositoryLocal: RepositoryLocal): ViewModel() {

    private val liveDataToObserve = MutableLiveData<FavouriteEventsState>()

    fun getLiveData(): LiveData<FavouriteEventsState> = liveDataToObserve

    fun getActualFavouriteEvents() {
        liveDataToObserve.value = FavouriteEventsState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            val resultConverted = mutableListOf<Event>()
            try {
                val myActualEventsEntity = repositoryLocal.getMyActualEvents(1)
                for (eventEntity in myActualEventsEntity) {
                    val eventApp = Event(eventEntity)
                    eventApp.isFavourite = true
                    resultConverted.add(eventApp)
                }
            } catch (exception: Throwable) {
                liveDataToObserve.postValue(FavouriteEventsState.Error(exception))
                return@launch
            }

            liveDataToObserve.postValue(FavouriteEventsState.Success(resultConverted))
        }
    }

    fun updateFavourite(event: Event) {
        viewModelScope.launch (Dispatchers.IO) {
            if (event.isFavourite) {
                repositoryLocal.saveToMyEvents(UserEventEntity(event))
            } else {
                repositoryLocal.removeFromMyEvents(UserEventEntity(event))
            }
        }
    }

}