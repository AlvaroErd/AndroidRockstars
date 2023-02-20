package com.mango.androidrockstars.data.repository

import com.mango.androidrockstars.data.datasource.features.toprateddetail.remote.mapper.tvShowDetailResponseMapper
import com.mango.androidrockstars.data.source.RemoteTopRatedTvDetailDataSource
import com.mango.androidrockstars.domain.model.TvShowDetail
import com.mango.androidrockstars.domain.repository.TopRatedTvDetailRepository

class TopRatedTvDetailRepositoryImpl : TopRatedTvDetailRepository {
    private val remoteTopRatedTvDetailDataSource: RemoteTopRatedTvDetailDataSource =
        RemoteTopRatedTvDetailDataSource()

    override suspend fun getTopRatedTvDetail(tvId: Int): TvShowDetail {
        val data = remoteTopRatedTvDetailDataSource.getTopRatedTvDetail(tvId)
        return tvShowDetailResponseMapper(data)
    }
}