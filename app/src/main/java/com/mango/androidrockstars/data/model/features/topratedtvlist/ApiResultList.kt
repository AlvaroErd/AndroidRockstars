package com.mango.androidrockstars.data.model.features.topratedtvlist

import com.google.gson.annotations.SerializedName

data class ApiResultList(
    @SerializedName("page") val page: Int = 0,
    @SerializedName("results") val results: List<ApiResultDetail> = listOf(),
    @SerializedName("totalPages") val totalPages: Int = 0,
    @SerializedName("totalResults") val totalResults: Int = 0,
)