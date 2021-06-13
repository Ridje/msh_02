package com.yrar.hackaton_02_yrar.model.app

import com.yrar.hackaton_02_yrar.model.database.RoleEntity

data class Role(val id: Int,
val title: String
) {
    constructor(role: RoleEntity) : this(
        role.id,
        role.title
    )
}
