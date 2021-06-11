package com.yrar.hackaton_02_yrar.repository

import com.yrar.hackaton_02_yrar.model.database.EventEntity
import com.yrar.hackaton_02_yrar.model.database.UserEventEntity

interface RepositoryLocal {

   fun getActualEvents(): List<EventEntity>
   fun getArchivedEvents(): List<EventEntity>

   fun saveEventsToCache(events: List<EventEntity>)

   fun saveToMyEvents(userEventEntity: UserEventEntity)
   fun getMyActualEvents(currentUser: Int): List<EventEntity>
   fun getMyArchivedEvents(currentUser: Int): List<EventEntity>
}