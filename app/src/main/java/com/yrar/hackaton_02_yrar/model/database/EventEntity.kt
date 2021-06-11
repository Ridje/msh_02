package com.yrar.hackaton_02_yrar.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EventEntity(
    @PrimaryKey
    var id: String,
    var title: String,
    var description: String,
    var type: String,
    @ColumnInfo(name = "date_start")
    var dateStart: Long,
    @ColumnInfo(name = "date_end")
    var dateEnd: Long,
    var fullDescription: String,
    var address: String,
    var contactEmail: String,
    var webAddress: String
)