package com.yrar.hackaton_02_yrar.repository

import com.yrar.hackaton_02_yrar.model.database.EventEntity
import com.yrar.hackaton_02_yrar.model.database.UserEventEntity
import com.yrar.hackaton_02_yrar.room.UserDatabase

class RepositoryLocalRoom(val service: UserDatabase): RepositoryLocal {
    override fun getActualEvents(): List<EventEntity> {
        return service.eventDAO().getAllActual(System.currentTimeMillis())
    }

    override fun getArchivedEvents(): List<EventEntity> {
        return service.eventDAO().getAllActual(System.currentTimeMillis())
    }

    override fun saveEventsToCache(events: List<EventEntity>) {
        service.eventDAO().saveEventsToCache(events)
    }

    override fun saveToMyEvents(userEventEntity: UserEventEntity) {
        service.userEventDAO().insert(userEventEntity)
    }

    override fun getMyActualEvents(currentUser: Int): List<EventEntity> {
        return service.userEventDAO().getAllActual(System.currentTimeMillis(), currentUser)
    }

    override fun getMyArchivedEvents(currentUser: Int): List<EventEntity> {
        return service.userEventDAO().getAllActual(System.currentTimeMillis(), currentUser)
    }
}