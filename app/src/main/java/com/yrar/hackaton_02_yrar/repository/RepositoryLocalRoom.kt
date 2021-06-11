package com.yrar.hackaton_02_yrar.repository

import androidx.room.RoomDatabase
import com.yrar.hackaton_02_yrar.room.UserDatabase

class RepositoryLocalRoom(val service: UserDatabase): RepositoryLocal {
}