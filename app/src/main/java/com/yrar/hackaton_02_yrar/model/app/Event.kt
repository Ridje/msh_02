package com.yrar.hackaton_02_yrar.model.app

import android.os.Parcelable
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
    var webAddress: String
): Parcelable {
    constructor(eventResponse: EventResponse) : this(
        eventResponse.id,
        eventResponse.title,
        eventResponse.description,
        eventResponse.type,
        eventResponse.dateStart,
        eventResponse.dateEnd,
        eventResponse.fullDescription,
        eventResponse.address,
        eventResponse.contactEmail,
        eventResponse.webAddress
    )
}
