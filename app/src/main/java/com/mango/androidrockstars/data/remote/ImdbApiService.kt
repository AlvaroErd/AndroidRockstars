package com.mango.androidrockstars.data.remote

import com.mango.androidrockstars.BuildConfig
import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResultDetail
import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResultList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImdbApiService {

    @GET("tv/top_rated")
    suspend fun getTopRatedTv(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int = 1,
        @Query("language") language: String = ""
    ): ApiResultList

    @GET("tv/{tv_id}")
    suspend fun getTopRatedTvDetail(
        @Path("tv_id") TvId: Int = 1,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("language") language: String = ""
    ): ApiResultDetail
}
