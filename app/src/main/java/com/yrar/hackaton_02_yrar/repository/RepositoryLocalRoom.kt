package com.yrar.hackaton_02_yrar.repository

import com.yrar.hackaton_02_yrar.model.database.*
import com.yrar.hackaton_02_yrar.room.UserDatabase

class RepositoryLocalRoom(val service: UserDatabase): RepositoryLocal {
    override fun getActualEvents(): List<EventEntity> {
        return service.eventDAO().getAllActual(System.currentTimeMillis())
    }

    override fun getArchivedEvents(): List<EventEntity> {
        return service.eventDAO().getAllActual(System.currentTimeMillis())
    }

    override fun getMyAllEvents(currentUser: Int): List<UserEventEntity> {
        return service.userEventDAO().all(currentUser)
    }

    override fun saveEventsToCache(events: List<EventEntity>) {
        service.eventDAO().saveEventsToCache(events)
    }

    override fun saveToMyEvents(userEventEntity: UserEventEntity) {
        service.userEventDAO().insert(userEventEntity)
    }

    override fun removeFromMyEvents(userEventEntity: UserEventEntity) {
        service.userEventDAO().delete(userEventEntity)
    }

    override fun getMyActualEvents(currentUser: Int): List<EventEntity> {
        return service.userEventDAO().getAllActual(System.currentTimeMillis(), currentUser)
    }

    override fun getMyArchivedEvents(currentUser: Int): List<EventEntity> {
        return service.userEventDAO().getAllActual(System.currentTimeMillis(), currentUser)
    }

    override fun isEmptyProfile(currentUser: Int): Boolean {
        return service.catalogsDAO().userInterests(currentUser).isEmpty() || service.catalogsDAO().userRoles(currentUser).isEmpty()
    }

    override fun getUserRoles(currentUser: Int): Map<RoleEntity, Boolean> {

        val resultMap = mutableMapOf<RoleEntity, Boolean>()

        val userRoles = service.catalogsDAO().userRoles(1)

        for (role in service.catalogsDAO().allRoles()) {
            resultMap[role] = userRoles.contains(role)
        }

        return resultMap
    }

    override fun getUserInterests(currentUser: Int): Map<InterestEntity, Boolean> {

        val resultMap = mutableMapOf<InterestEntity, Boolean>()

        val userInterests = service.catalogsDAO().userInterests(1)

        for (interest in service.catalogsDAO().allInterests()) {
            resultMap[interest] = userInterests.contains(interest)
        }

        return resultMap
    }

    override fun insertUserInterests(userInterests: List<UserInterestEntity>) {
        service.catalogsDAO().insertUserInterests(userInterests)
    }

    override fun insertUserRoles(userRoles: List<UserRoleEntity>) {
        service.catalogsDAO().insertUserRoles(userRoles)
    }

}