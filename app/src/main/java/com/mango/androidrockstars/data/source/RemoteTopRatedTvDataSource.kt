package com.mango.androidrockstars.data.source

import com.mango.androidrockstars.BuildConfig
import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiListResponse
import com.mango.androidrockstars.data.remote.ImdbApiService
import com.mango.androidrockstars.data.remote.Service

class RemoteTopRatedTvDataSource {
    private val imdbApiService: ImdbApiService = Service.getInstance()

    suspend fun getTopRatedTvList(): ApiListResponse =
        imdbApiService.getTopRatedTv("${BuildConfig.API_KEY}", 1, "en-US")
}
