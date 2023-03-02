package com.mango.androidrockstars.data.source

import com.mango.androidrockstars.BuildConfig
import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiTvDetailResponse
import com.mango.androidrockstars.data.remote.ImdbApiService
import javax.inject.Inject

class RemoteTopRatedTvDetailDataSource @Inject constructor(
    private val imdbApiService: ImdbApiService
) : TopRatedTvDetailDataSource {

    override suspend fun getTopRatedTvDetail(tvId: Int): ApiTvDetailResponse =
        imdbApiService.getTopRatedTvDetail(tvId, "${BuildConfig.API_KEY}", "en-US")
}
