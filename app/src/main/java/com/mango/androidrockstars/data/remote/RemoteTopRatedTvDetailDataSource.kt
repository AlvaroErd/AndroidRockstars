package com.mango.androidrockstars.data.remote

import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResultDetail

class RemoteTopRatedTvDetailDataSource {
    private val imdbApiService: ImdbApiService = Service.getInstance()


    suspend fun getTopRatedTvDetail(): ApiResultDetail =
        imdbApiService.getTopRatedTvDetail(0, "", "en-US")
}
