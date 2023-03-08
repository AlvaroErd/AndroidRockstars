package com.mango.androidrockstars.data.repository

import com.mango.androidrockstars.BuildConfig
import com.mango.androidrockstars.data.remote.ImdbApiService
import javax.inject.Inject

class TopRatedTvRepository @Inject constructor(private val apiService: ImdbApiService) {

    suspend fun getAllTvShows(
        page: Int,
        apiKey: String = BuildConfig.API_KEY,
        language: String = "en-US"
    ) = apiService.getTopRatedTvList(
        apiKey = apiKey,
        page = page,
        language = language
    )
}