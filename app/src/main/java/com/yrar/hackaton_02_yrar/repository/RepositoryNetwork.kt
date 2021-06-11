package com.yrar.hackaton_02_yrar.repository

import com.yrar.hackaton_02_yrar.model.database.EventEntity
import com.yrar.hackaton_02_yrar.model.network.EventResponse

interface RepositoryNetwork {

    fun getActualEvents(): List<EventResponse>
    fun getArchivedEvents(): List<EventResponse>
}