package com.yrar.hackaton_02_yrar.retrofit

import com.yrar.hackaton_02_yrar.model.network.EventResponse
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("/event/actual")
    fun getAllActual(): Call<List<EventResponse>>

    @GET("/event/archived")
    fun getAllArchived(): Call<List<EventResponse>>

}