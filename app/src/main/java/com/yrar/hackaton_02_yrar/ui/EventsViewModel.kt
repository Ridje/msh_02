package com.yrar.hackaton_02_yrar.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yrar.hackaton_02_yrar.model.app.Event
import com.yrar.hackaton_02_yrar.model.network.EventResponse
import com.yrar.hackaton_02_yrar.repository.RepositoryLocal
import com.yrar.hackaton_02_yrar.repository.RepositoryNetwork
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import java.util.stream.Collectors
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(val repositoryNetwork: RepositoryNetwork, val repositoryLocal: RepositoryLocal) : ViewModel() {

    private val liveDataToObserve = MutableLiveData<EventsState>()

    fun getLiveData(): LiveData<EventsState> = liveDataToObserve

    fun getActualEvents() {
        liveDataToObserve.value = EventsState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val resultConverted = mutableListOf<Event>()
            try {
                for (eventResponse in repositoryNetwork.getActualEvents()) {
                    resultConverted.add(Event(eventResponse))
                }
            } catch (exception: Throwable) {
                liveDataToObserve.postValue(EventsState.Error(exception))
                return@launch
            }

            liveDataToObserve.postValue(EventsState.Success(resultConverted))
        }
    }



}