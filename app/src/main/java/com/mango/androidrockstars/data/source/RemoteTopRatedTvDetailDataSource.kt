package com.mango.androidrockstars.data.source

import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiDetailResponse
import com.mango.androidrockstars.data.remote.ImdbApiService
import com.mango.androidrockstars.data.remote.Service

class RemoteTopRatedTvDetailDataSource {
    private val imdbApiService: ImdbApiService = Service.getInstance()


    suspend fun getTopRatedTvDetail(): ApiDetailResponse =
        imdbApiService.getTopRatedTvDetail(0, "", "en-US")
}
