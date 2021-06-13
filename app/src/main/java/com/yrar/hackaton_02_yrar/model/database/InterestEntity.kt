package com.yrar.hackaton_02_yrar.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class InterestEntity(@PrimaryKey(autoGenerate = true)
                      var id: Int,
                      var title: String)