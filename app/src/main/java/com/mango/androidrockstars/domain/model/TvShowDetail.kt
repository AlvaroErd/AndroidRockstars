package com.mango.androidrockstars.domain.model


data class TvShowDetail(
    val name: String = "",
    val posterPath: String = "",
    val voteAverage: Double = 0.0,
    val voteCount: Int = 1,
    val id: Int = 1,
    val first_air_date: String = "",
    val overview: String = "",
    val original_language: String = "",
)