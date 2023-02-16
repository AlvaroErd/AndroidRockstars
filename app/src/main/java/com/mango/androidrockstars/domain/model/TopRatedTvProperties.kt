package com.mango.androidrockstars.domain.model

data class TopRatedTvProperties(
    val name: String,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int,
    val id: Int,
)

data class topRatedTvList(val result: List<TopRatedTvProperties> = listOf())
