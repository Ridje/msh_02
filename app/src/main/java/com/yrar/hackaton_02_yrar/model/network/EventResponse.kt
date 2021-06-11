package com.yrar.hackaton_02_yrar.model.network

import com.fasterxml.jackson.annotation.JsonProperty

data class EventResponse(
    @JsonProperty("id") var id: String,
    @JsonProperty("title") var title: String,
    @JsonProperty("description") var description: String,
    @JsonProperty("type") var type: String,
    @JsonProperty("dateStart") var dateStart: Long,
    @JsonProperty("dateEnd") var dateEnd: Long?,
    @JsonProperty("fullDescription") var fullDescription: String,
    @JsonProperty("address") var address: String,
    @JsonProperty("contactEmail") var contactEmail: String,
    @JsonProperty("webAddress") var webAddress: String
)