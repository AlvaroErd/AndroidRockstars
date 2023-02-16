package com.mango.androidrockstars.data.remote

import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResultDetail

class RemoteTopRatedTvDetailDataSource {
    private val imdbApiService: ImdbApiService = Service.getInstance()


    suspend fun getTopRatedTvDetail(): ApiResultDetail =
        imdbApiService.getTopRatedTvDetail(0, "6f54b113f248b6b52c4cb077769b03e6", "en-US")
}
