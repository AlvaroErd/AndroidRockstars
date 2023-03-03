package com.mango.androidrockstars.data.source

import com.mango.androidrockstars.BuildConfig
import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiTvDetailResponse
import com.mango.androidrockstars.data.remote.ImdbApiService
import javax.inject.Inject

class RemoteTopRatedTvDetailDataSource @Inject constructor(
    private val api: ImdbApiService
) : TopRatedTvDetailDataSource {

    override suspend fun getTopRatedTvDetail(tvId: Int): ApiTvDetailResponse =
        api.getTopRatedTvDetail(tvId = tvId, apiKey = BuildConfig.API_KEY, language = "en-US")
}
