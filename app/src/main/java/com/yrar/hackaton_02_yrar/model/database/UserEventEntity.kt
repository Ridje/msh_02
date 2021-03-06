package com.yrar.hackaton_02_yrar.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.yrar.hackaton_02_yrar.model.app.Event

@Entity(
    foreignKeys = [
        ForeignKey
            (
            entity = EventEntity::class,
            parentColumns = ["id"],
            childColumns = ["event_id"]
        ),
    ],
    primaryKeys = ["event_id", "user_id"]
)
data class UserEventEntity(
    @ColumnInfo(name = "event_id")
    var eventId: String,
    @ColumnInfo(name = "user_id")
    var userId: Int
) {
    constructor(event: Event) : this(
        event.id,
        1
    )
}