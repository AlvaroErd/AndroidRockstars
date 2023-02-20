package com.mango.androidrockstars.data.datasource.features.topratedtvlist.model

import com.google.gson.annotations.SerializedName

data class ApiListResponse(
    @SerializedName("page") val page: Int = 0,
    @SerializedName("results") val results: List<ApiDetailResponse> = listOf(),
    @SerializedName("totalPages") val totalPages: Int = 0,
    @SerializedName("totalResults") val totalResults: Int = 0,
)