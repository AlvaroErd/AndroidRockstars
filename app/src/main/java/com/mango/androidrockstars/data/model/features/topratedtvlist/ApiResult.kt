package com.mango.androidrockstars.data.model.features.topratedtvlist

import com.google.gson.annotations.SerializedName

data class ApiResult(
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("name") val name: String,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("vote_average") val voteAverage: Double
)