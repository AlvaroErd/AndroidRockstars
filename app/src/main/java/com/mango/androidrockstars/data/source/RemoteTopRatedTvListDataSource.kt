package com.mango.androidrockstars.data.source

import com.mango.androidrockstars.BuildConfig
import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiListResponse
import com.mango.androidrockstars.data.remote.ImdbApiService
import javax.inject.Inject

class RemoteTopRatedTvListDataSource @Inject constructor(
    private val api: ImdbApiService
) :
    TopRatedTvListDataSource {

    override suspend fun getTopRatedTvList(): ApiListResponse =
        api.getTopRatedTvList(apiKey = BuildConfig.API_KEY, page = 1, language = "en-US")
}
