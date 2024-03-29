package com.mango.androidrockstars.data.datasource.features.toprateddetail.model

import com.google.gson.annotations.SerializedName

data class ApiTvDetailResponse(
    @SerializedName("id") val tv_Id: Int = 0,
    @SerializedName("poster_path") val posterPath: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("vote_count") val voteCount: Int = 0,
    @SerializedName("vote_average") val voteAverage: Double = 0.0,
    @SerializedName("first_air_date") val first_air_date: String = "",
    @SerializedName("overview") val overview: String = "",
    @SerializedName("original_language") val original_language: String = "",
)