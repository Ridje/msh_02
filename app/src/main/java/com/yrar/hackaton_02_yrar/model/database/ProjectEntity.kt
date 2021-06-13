package com.yrar.hackaton_02_yrar.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProjectEntity(
    @PrimaryKey
    var id: Int,
    var title: String,
    var leaderId: Int,
    var productDescription: String,
    var productUniqueness: String,
    var productStage: String,
    var productIntellectual_property: String,
    var marketProblematic: String,
    var marketApplication: String,
    var marketValue: String,
    var marketCompetitors: String,
    var projectDateStart: Long,
    var projectLeaderBio: String,
    var projectResources: String,
    var projectCurrentState: String,
    var projectInjectionModel: String,
    var projectPlans: String
)