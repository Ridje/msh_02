package com.yrar.hackaton_02_yrar.room.dao

import androidx.room.*
import com.yrar.hackaton_02_yrar.model.database.EventEntity
import com.yrar.hackaton_02_yrar.model.database.UserEventEntity

@Dao
interface UserEventDAO {
    @Query("SELECT EventEntity.* FROM EventEntity INNER JOIN UserEventEntity ON EventEntity.id = UserEventEntity.event_id WHERE IFNULL(EventEntity.date_end, EventEntity.date_start) > :currentTime AND user_id = :currentUser")
    fun getAllActual(currentTime: Long, currentUser: Int): List<EventEntity>

    @Query("SELECT EventEntity.* FROM EventEntity INNER JOIN UserEventEntity ON EventEntity.id = UserEventEntity.event_id WHERE IFNULL(EventEntity.date_end, EventEntity.date_start) < :currentTime AND user_id = :currentUser")
    fun getAllArchived(currentTime: Long, currentUser: Int): List<EventEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEventEntity: UserEventEntity)

    @Delete
    fun delete(userEventEntity: UserEventEntity)

    @Query("SELECT * FROM UserEventEntity WHERE user_id = :currentUser")
    fun all(currentUser: Int): List<UserEventEntity>
}