package com.yrar.hackaton_02_yrar.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yrar.hackaton_02_yrar.model.app.Event
import com.yrar.hackaton_02_yrar.model.network.EventResponse

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
    var dateEnd: Long?,
    var fullDescription: String,
    var address: String,
    var contactEmail: String,
    var webAddress: String
) {
    constructor(event: EventResponse) : this(
        event.id,
        event.title,
        event.description,
        event.type,
        event.dateStart,
        event.dateEnd,
        event.fullDescription,
        event.address,
        event.contactEmail,
        event.webAddress
    )

    constructor(event: Event): this(
        event.id,
        event.title,
        event.description,
        event.type,
        event.dateStart,
        event.dateEnd,
        event.fullDescription,
        event.address,
        event.contactEmail,
        event.webAddress
    )
}