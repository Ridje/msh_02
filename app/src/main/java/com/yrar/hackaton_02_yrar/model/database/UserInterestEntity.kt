package com.yrar.hackaton_02_yrar.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    foreignKeys = [
        ForeignKey
            (
            entity = InterestEntity::class,
            parentColumns = ["id"],
            childColumns = ["interest_id"]
        ),
    ],
    primaryKeys = ["user_id", "interest_id"]
)
data class UserInterestEntity(
    @ColumnInfo(name = "interest_id")
    var interestId: Int,
    @ColumnInfo(name = "user_id")
    var userId: Int
)