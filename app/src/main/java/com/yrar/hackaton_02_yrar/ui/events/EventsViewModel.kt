package com.yrar.hackaton_02_yrar.ui.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yrar.hackaton_02_yrar.model.app.Event
import com.yrar.hackaton_02_yrar.model.database.EventEntity
import com.yrar.hackaton_02_yrar.model.database.UserEventEntity
import com.yrar.hackaton_02_yrar.repository.RepositoryLocal
import com.yrar.hackaton_02_yrar.repository.RepositoryNetwork
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(val repositoryNetwork: RepositoryNetwork, val repositoryLocal: RepositoryLocal) : ViewModel() {

    private val liveDataToObserve = MutableLiveData<EventsState>()

    fun getLiveData(): LiveData<EventsState> = liveDataToObserve

    fun getActualEvents() {
        liveDataToObserve.value = EventsState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val resultConverted = mutableListOf<Event>()
            val cacheValues = mutableListOf<EventEntity>()

            try {
                val actualEventsResponse = repositoryNetwork.getActualEvents()
                for (eventResponse in actualEventsResponse) {
                    resultConverted.add(Event(eventResponse))
                }
                val favouriteCached = repositoryLocal.getMyAllEvents(1)
                for (event in resultConverted) {
                    for (cached in favouriteCached){
                        if (cached.eventId == event.id) {
                            event.isFavourite = true
                        }
                    }
                    cacheValues.add(EventEntity(event))
                }

            } catch (exception: Throwable) {
                liveDataToObserve.postValue(EventsState.Error(exception))
                exception.printStackTrace()
                return@launch
            }

            liveDataToObserve.postValue(EventsState.Success(resultConverted))
            repositoryLocal.saveEventsToCache(cacheValues)
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