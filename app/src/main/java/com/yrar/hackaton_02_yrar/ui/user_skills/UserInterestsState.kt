package com.yrar.hackaton_02_yrar.ui.user_skills

import com.yrar.hackaton_02_yrar.model.app.Interest

sealed class UserInterestsState {
    data class Success(val interests: MutableMap<Interest, Boolean>): UserInterestsState()
    data class Error(val error: Throwable): UserInterestsState()
    object Loading: UserInterestsState()
}