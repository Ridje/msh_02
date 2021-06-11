package com.yrar.hackaton_02_yrar.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yrar.hackaton_02_yrar.model.database.EventEntity
import com.yrar.hackaton_02_yrar.model.database.UserEventEntity
import com.yrar.hackaton_02_yrar.room.dao.EventDAO
import com.yrar.hackaton_02_yrar.room.dao.UserEventDAO

@Database(
    entities = [EventEntity::class, UserEventEntity::class],
    version = 1,
    exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    abstract fun eventDAO(): EventDAO

    abstract fun userEventDAO(): UserEventDAO

}