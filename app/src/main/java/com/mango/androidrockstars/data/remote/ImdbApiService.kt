package com.mango.androidrockstars.data.remote

import com.mango.androidrockstars.data.model.features.topratedtvlist.TopRatedTv
import retrofit2.http.GET
import retrofit2.http.Query

interface ImdbApiService {

    @GET("tv/get-top-rated-tv")
    suspend fun getTopRatedTv(
        @Query("api_key") apiKey: String, //pasar a okhttp ya que cada vez que se hace una llamada va a incluir el token
        @Query("page") page: Int = 1,
        @Query("language") language: String = "es"
    ): TopRatedTv
}
