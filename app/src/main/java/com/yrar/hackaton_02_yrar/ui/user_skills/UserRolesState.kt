package com.yrar.hackaton_02_yrar.ui.user_skills

import com.yrar.hackaton_02_yrar.model.app.Role

sealed class UserRolesState {
    data class Success(val roles: MutableMap<Role, Boolean>): UserRolesState()
    data class Error(val error: Throwable): UserRolesState()
    object Loading: UserRolesState()
}
