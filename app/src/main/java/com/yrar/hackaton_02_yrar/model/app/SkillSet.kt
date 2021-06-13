package com.yrar.hackaton_02_yrar.model.app

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class SkillSet(
    var roles: MutableList<Role>,
    var interests: MutableList<Interest>
)
