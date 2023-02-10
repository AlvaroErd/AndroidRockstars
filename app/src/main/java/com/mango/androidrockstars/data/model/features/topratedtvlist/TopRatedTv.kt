package com.mango.androidrockstars.data.model.features.topratedtvlist


import com.google.gson.annotations.SerializedName

data class TopRatedTv(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
) {
    data class Result(
        @SerializedName("name")
        val name: String,
        @SerializedName("poster_path")
        val posterPath: String,
        @SerializedName("vote_average")
        val voteAverage: Double,
        @SerializedName("vote_count")
        val voteCount: Int,
//        @SerializedName("id")
//        val id: Int,
    )
}

