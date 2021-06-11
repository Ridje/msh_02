package com.yrar.hackaton_02_yrar.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EventEntity(
    @PrimaryKey
    var id: Int,
    var title: String,
    var description: String,
    var type: String,
    var date: Long,
    var fullDescription: String,
    var address: String,
    var contactEmail: String,
    var webAddress: String
)