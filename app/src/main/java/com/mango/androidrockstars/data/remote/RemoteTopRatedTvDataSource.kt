package com.mango.androidrockstars.data.remote

import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResultList

class RemoteTopRatedTvDataSource {
    private val imdbApiService: ImdbApiService = Service.getInstance()

    suspend fun getTopRatedTvList(): ApiResultList =
        imdbApiService.getTopRatedTv("6f54b113f248b6b52c4cb077769b03e6")
}
