package com.yrar.hackaton_02_yrar.model.app

import android.os.Parcelable
import com.yrar.hackaton_02_yrar.model.database.InterestEntity
import kotlinx.android.parcel.Parcelize

data class Interest(
    var id: Int,
    var title: String
) {
    constructor(interest: InterestEntity) : this(
        interest.id,
        interest.title
    )
}

