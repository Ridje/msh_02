package com.yrar.hackaton_02_yrar.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yrar.hackaton_02_yrar.model.database.InterestEntity
import com.yrar.hackaton_02_yrar.model.database.RoleEntity
import com.yrar.hackaton_02_yrar.model.database.UserInterestEntity
import com.yrar.hackaton_02_yrar.model.database.UserRoleEntity

@Dao
interface CatalogsDAO {

    @Query("SELECT * FROM RoleEntity INNER JOIN UserRoleEntity ON RoleEntity.id = UserRoleEntity.role_id AND UserRoleEntity.user_id = :currentUser")
    fun userRoles(currentUser: Int): List<RoleEntity>

    @Query("SELECT * FROM InterestEntity INNER JOIN UserInterestEntity ON InterestEntity.id = UserInterestEntity.interest_id AND UserInterestEntity.user_id = :currentUser ")
    fun userInterests(currentUser: Int): List<InterestEntity>

    @Query("SELECT * FROM InterestEntity")
    fun allInterests(): List<InterestEntity>

    @Query("SELECT * FROM RoleEntity")
    fun allRoles(): List<RoleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRole(roleEntity: RoleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInterest(interestEntity: InterestEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserInterests(listUserInterests: List<UserInterestEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserRoles(listUserRoles: List<UserRoleEntity>)
}