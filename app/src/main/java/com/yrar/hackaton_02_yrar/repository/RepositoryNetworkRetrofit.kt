package com.yrar.hackaton_02_yrar.repository

import android.accounts.NetworkErrorException
import com.yrar.hackaton_02_yrar.model.network.EventResponse
import com.yrar.hackaton_02_yrar.retrofit.API

class RepositoryNetworkRetrofit(val service: API): RepositoryNetwork {
    override fun getActualEvents(): List<EventResponse> {
        return service.getAllActual().execute().body() ?: throw NetworkErrorException()
    }

    override fun getArchivedEvents(): List<EventResponse> {
        return service.getAllArchived().execute().body() ?: throw NetworkErrorException()
    }
}