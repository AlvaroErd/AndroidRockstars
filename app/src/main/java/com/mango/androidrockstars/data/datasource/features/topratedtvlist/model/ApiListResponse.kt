package com.mango.androidrockstars.data.datasource.features.topratedtvlist.model

import com.google.gson.annotations.SerializedName
import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiDetailResponse

data class ApiListResponse(
    @SerializedName("page") val page: Int = 0,
    @SerializedName("results") val results: List<ApiDetailResponse> = listOf(),
    @SerializedName("totalPages") val totalPages: Int = 0,
    @SerializedName("totalResults") val totalResults: Int = 0,
)