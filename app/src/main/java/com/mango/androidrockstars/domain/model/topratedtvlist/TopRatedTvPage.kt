package com.mango.androidrockstars.domain.model.topratedtvlist

data class TopRatedTvPage(
    val page: Int = 1,
    val results: List<TopRatedTvProperties>,
    val totalPages: Int = 1,
    val totalResults: Int = 1,
)
