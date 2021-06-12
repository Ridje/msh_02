package com.yrar.hackaton_02_yrar.ui.favourite_events

import com.yrar.hackaton_02_yrar.model.app.Event

sealed class FavouriteEventsState {
    data class Success(val events: List<Event>): FavouriteEventsState()
    data class Error(val error: Throwable): FavouriteEventsState()
    object Loading : FavouriteEventsState()
}