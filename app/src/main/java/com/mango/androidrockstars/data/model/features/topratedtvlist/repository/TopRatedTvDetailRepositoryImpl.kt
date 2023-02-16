package com.mango.androidrockstars.data.model.features.topratedtvlist.repository

import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResultDetail
import com.mango.androidrockstars.data.remote.RemoteTopRatedTvDetailDataSource
import com.mango.androidrockstars.domain.repository.TopRatedTvDetailRepository

class TopRatedTvDetailRepositoryImpl : TopRatedTvDetailRepository {
    private val remoteTopRatedTvDetailDataSource: RemoteTopRatedTvDetailDataSource =
        RemoteTopRatedTvDetailDataSource()

    override suspend fun getTopRatedTvDetail(): ApiResultDetail {
        return remoteTopRatedTvDetailDataSource.getTopRatedTvDetail()
    }
}