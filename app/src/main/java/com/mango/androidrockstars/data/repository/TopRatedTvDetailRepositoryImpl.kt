package com.mango.androidrockstars.data.repository

import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiResultDetail
import com.mango.androidrockstars.data.source.RemoteTopRatedTvDetailDataSource
import com.mango.androidrockstars.domain.repository.TopRatedTvDetailRepository

class TopRatedTvDetailRepositoryImpl : TopRatedTvDetailRepository {
    private val remoteTopRatedTvDetailDataSource: RemoteTopRatedTvDetailDataSource =
        RemoteTopRatedTvDetailDataSource()

    override suspend fun getTopRatedTvDetail(): ApiResultDetail {
        return remoteTopRatedTvDetailDataSource.getTopRatedTvDetail()
    }
}