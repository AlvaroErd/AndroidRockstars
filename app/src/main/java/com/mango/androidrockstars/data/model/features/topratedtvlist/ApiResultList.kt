package com.mango.androidrockstars.data.model.features.topratedtvlist

data class ApiResultList(
    val page: Int,
    val results: List<ApiResult> = listOf(),
    val totalPages: Int,
    val totalResults: Int
)
