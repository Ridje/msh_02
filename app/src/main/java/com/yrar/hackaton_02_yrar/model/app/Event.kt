package com.yrar.hackaton_02_yrar.model.app

import android.os.Parcelable
import com.yrar.hackaton_02_yrar.model.database.EventEntity
import com.yrar.hackaton_02_yrar.model.network.EventResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(
    var id: String,
    var title: String,
    var description: String,
    var type: String,
    var dateStart: Long,
    var dateEnd: Long?,
    var fullDescription: String,
    var address: String,
    var contactEmail: String,
    var webAddress: String,
    var isFavourite: Boolean = false
): Parcelable {
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

    constructor(event: EventEntity) : this(
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
