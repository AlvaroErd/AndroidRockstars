package com.mango.androidrockstars.data.source

import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiResultDetail
import com.mango.androidrockstars.data.remote.ImdbApiService
import com.mango.androidrockstars.data.remote.Service

class RemoteTopRatedTvDetailDataSource {
    private val imdbApiService: ImdbApiService = Service.getInstance()


    suspend fun getTopRatedTvDetail(): ApiResultDetail =
        imdbApiService.getTopRatedTvDetail(0, "", "en-US")
}
