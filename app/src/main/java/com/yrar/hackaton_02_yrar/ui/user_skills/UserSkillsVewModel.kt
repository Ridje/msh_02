package com.yrar.hackaton_02_yrar.ui.user_skills

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yrar.hackaton_02_yrar.model.app.Interest
import com.yrar.hackaton_02_yrar.model.app.Role
import com.yrar.hackaton_02_yrar.model.database.InterestEntity
import com.yrar.hackaton_02_yrar.model.database.UserInterestEntity
import com.yrar.hackaton_02_yrar.model.database.UserRoleEntity
import com.yrar.hackaton_02_yrar.repository.RepositoryLocal
import com.yrar.hackaton_02_yrar.repository.RepositoryNetwork
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserSkillsVewModel @Inject constructor(val repositoryNetwork: RepositoryNetwork, val repositoryLocal: RepositoryLocal): ViewModel() {

    private val liveDataToObserveRoles = MutableLiveData<UserRolesState>()
    fun getLiveDataRoles(): LiveData<UserRolesState> = liveDataToObserveRoles

    private val liveDataToObserveInterests = MutableLiveData<UserInterestsState>()
    fun getLiveDataInterests(): LiveData<UserInterestsState> = liveDataToObserveInterests

    fun getUserInterests() {
        liveDataToObserveInterests.postValue(UserInterestsState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            val result = mutableMapOf<Interest, Boolean>()
            try {
                val mapEntities = repositoryLocal.getUserInterests(1)
                for (keyValue in mapEntities) {
                    result[Interest(keyValue.key)] = keyValue.value
                }
                liveDataToObserveInterests.postValue(UserInterestsState.Success(result))
            } catch (error: Throwable) {
                liveDataToObserveInterests.postValue(UserInterestsState.Error(error))
                error.printStackTrace()
            }
        }
    }

    fun putUserInterests(mapInterests: Map<Interest, Boolean>) {
        viewModelScope.launch (Dispatchers.IO) {
            val userInterests = mutableListOf<UserInterestEntity>()
            for (keyValue in mapInterests) {
                if (keyValue.value) {
                    userInterests.add(UserInterestEntity(keyValue.key.id, 1))
                }
            }
            if (userInterests.size < 1 || userInterests.size > 7) {
                return@launch
            }
            repositoryLocal.insertUserInterests(userInterests)
        }
    }

    fun getUserRoles() {
        liveDataToObserveRoles.postValue(UserRolesState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            val result = mutableMapOf<Role, Boolean>()
            try {
                val mapEntities = repositoryLocal.getUserRoles(1)
                for (keyValue in mapEntities) {
                    result[Role(keyValue.key)] = keyValue.value
                }
                liveDataToObserveRoles.postValue(UserRolesState.Success(result))
            } catch (error: Throwable) {
                liveDataToObserveRoles.postValue(UserRolesState.Error(error))
                error.printStackTrace()
            }
        }
    }

    fun putUserRoles(mapRoles: Map<Role, Boolean>) {
        viewModelScope.launch (Dispatchers.IO) {
            val userRoles = mutableListOf<UserRoleEntity>()
            for (keyValue in mapRoles) {
                if (keyValue.value) {
                    userRoles.add(UserRoleEntity(keyValue.key.id, 1))
                }
            }
            if (userRoles.size > 5 || userRoles.size < 1) {
                return@launch
            }
            repositoryLocal.insertUserRoles(userRoles)
        }
    }
}