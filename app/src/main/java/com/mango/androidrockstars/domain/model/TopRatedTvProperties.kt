package com.mango.androidrockstars.domain.model

data class TopRatedTvProperties(
    val id: Int,
    val posterPathList: String,
    val name: String,
    val voteCount: Int,
    val voteAverage: Double,
)
