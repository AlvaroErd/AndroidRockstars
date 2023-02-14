package com.mango.androidrockstars.data.remote

import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResultList
import retrofit2.http.GET
import retrofit2.http.Query

interface ImdbApiService {

    @GET("tv/top_rated")
    suspend fun getTopRatedTv(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1,
        @Query("language") language: String = "es"
    ): ApiResultList
}
