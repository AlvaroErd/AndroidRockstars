package com.mango.androidrockstars.domain.model


data class TvShowDetail(
    val name: String,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int,
    val id: Int,
    val first_air_date: String,
    val overview: String,
    val original_language: String
)