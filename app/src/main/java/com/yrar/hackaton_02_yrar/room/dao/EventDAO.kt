package com.yrar.hackaton_02_yrar.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yrar.hackaton_02_yrar.model.database.EventEntity

@Dao
interface EventDAO {

    @Query("SELECT * FROM EventEntity WHERE date_end > :currentTime")
    fun getAllActual(currentTime: Long): List<EventEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEventsToCache(entities: List<EventEntity>)
}