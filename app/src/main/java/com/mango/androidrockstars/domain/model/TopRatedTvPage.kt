package com.mango.androidrockstars.domain.model

data class TopRatedTvPage(
    val page: Int = 1,
    val movies: List<TopRatedTvProperties>,
)
