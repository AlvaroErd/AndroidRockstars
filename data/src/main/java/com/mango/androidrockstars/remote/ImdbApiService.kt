package com.mango.androidrockstars.remote

import com.mango.androidrockstars.model.features.topratedtvlist.TopRatedTv
import com.mango.data.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface ImdbApiService {

    @GET("tv/get-top-rated-tv?&api_key=${BuildConfig.API_KEY}")
    suspend fun getTopRatedTv(
        @Query("page") page: Int = 1
    ): TopRatedTv


}