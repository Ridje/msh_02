package com.yrar.hackaton_02_yrar.repository

import com.yrar.hackaton_02_yrar.model.database.*

interface RepositoryLocal {

   fun getActualEvents(): List<EventEntity>
   fun getArchivedEvents(): List<EventEntity>

   fun saveEventsToCache(events: List<EventEntity>)

   fun saveToMyEvents(userEventEntity: UserEventEntity)
   fun removeFromMyEvents(userEventEntity: UserEventEntity)
   fun getMyActualEvents(currentUser: Int): List<EventEntity>
   fun getMyArchivedEvents(currentUser: Int): List<EventEntity>
   fun getMyAllEvents(currentUser: Int): List<UserEventEntity>

   fun isEmptyProfile(currentUser: Int): Boolean

   fun getUserRoles(currentUser: Int): Map<RoleEntity, Boolean>
   fun getUserInterests(currentUser: Int): Map<InterestEntity, Boolean>

   fun insertUserInterests(userInterests: List<UserInterestEntity>)
   fun insertUserRoles(userRoles: List<UserRoleEntity>)
}