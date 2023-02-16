package com.mango.androidrockstars.domain.model

data class TopRatedTvPage(
    val page: Int = 1,
    val results: List<TopRatedTvProperties>,
    val totalPages: Int = 0,
    val totalResults: Int = 0,

    )
