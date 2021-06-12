package com.yrar.hackaton_02_yrar.ui.events

import com.yrar.hackaton_02_yrar.model.app.Event

sealed class EventsState {
    data class Success(val events: List<Event>): EventsState()
    data class Error(val error: Throwable): EventsState()
    object Loading: EventsState()
}
