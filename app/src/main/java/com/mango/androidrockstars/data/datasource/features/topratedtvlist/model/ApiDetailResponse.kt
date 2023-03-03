package com.mango.androidrockstars.data.datasource.features.topratedtvlist.model

import com.google.gson.annotations.SerializedName

data class ApiDetailResponse(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("poster_path") val posterPath: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("vote_count") val voteCount: Int = 0,
    @SerializedName("vote_average") val voteAverage: Double = 0.0,
)