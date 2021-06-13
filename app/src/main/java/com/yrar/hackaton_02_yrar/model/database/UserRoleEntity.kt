package com.yrar.hackaton_02_yrar.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    foreignKeys = [
        ForeignKey
            (
            entity = RoleEntity::class,
            parentColumns = ["id"],
            childColumns = ["role_id"]
        ),
    ],
    primaryKeys = ["user_id", "role_id"]
)
data class UserRoleEntity(
    @ColumnInfo(name = "role_id")
    var roleId: Int,
    @ColumnInfo(name = "user_id")
    var userId: Int
)