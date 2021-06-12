package com.yrar.hackaton_02_yrar.ui.event

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yrar.hackaton_02_yrar.model.app.Event
import com.yrar.hackaton_02_yrar.model.database.UserEventEntity
import com.yrar.hackaton_02_yrar.repository.RepositoryLocal
import com.yrar.hackaton_02_yrar.repository.RepositoryNetwork
import com.yrar.hackaton_02_yrar.ui.events.EventsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(val repositoryNetwork: RepositoryNetwork, val repositoryLocal: RepositoryLocal): ViewModel() {

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