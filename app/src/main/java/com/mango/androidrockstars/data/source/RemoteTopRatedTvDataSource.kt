package com.mango.androidrockstars.data.source

import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiListResponse
import com.mango.androidrockstars.data.remote.ImdbApiService
import com.mango.androidrockstars.data.remote.Service

class RemoteTopRatedTvDataSource {
    private val imdbApiService: ImdbApiService = Service.getInstance()

    suspend fun getTopRatedTvList(): ApiListResponse =
        imdbApiService.getTopRatedTv("6f54b113f248b6b52c4cb077769b03e6", 1, "en-US")
}
