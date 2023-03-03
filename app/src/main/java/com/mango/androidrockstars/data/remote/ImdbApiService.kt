package com.mango.androidrockstars.data.remote

import com.mango.androidrockstars.BuildConfig
import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiTvDetailResponse
import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImdbApiService {

    @GET("tv/top_rated")
    suspend fun getTopRatedTvList(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int = 1,
        @Query("language") language: String = ""
    ): ApiListResponse

    @GET("tv/{tv_id}")
    suspend fun getTopRatedTvDetail(
        @Path("tv_id") tvId: Int = 1,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("language") language: String = "",
    ): ApiTvDetailResponse
}