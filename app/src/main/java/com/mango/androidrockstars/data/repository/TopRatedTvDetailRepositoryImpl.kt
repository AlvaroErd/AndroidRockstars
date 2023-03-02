package com.mango.androidrockstars.data.repository

import com.mango.androidrockstars.data.datasource.features.toprateddetail.remote.mapper.tvShowDetailResponseMapper
import com.mango.androidrockstars.data.source.TopRatedTvDetailDataSource
import com.mango.androidrockstars.domain.model.TvShowDetail
import com.mango.androidrockstars.domain.repository.TopRatedTvDetailRepository
import javax.inject.Inject

class TopRatedTvDetailRepositoryImpl @Inject constructor(
    private val remoteTopRatedTvDetailDataSource: TopRatedTvDetailDataSource
) : TopRatedTvDetailRepository {

    override suspend fun getTopRatedTvDetail(tvId: Int): TvShowDetail {
        val data = remoteTopRatedTvDetailDataSource.getTopRatedTvDetail(tvId)
        return tvShowDetailResponseMapper(data)
    }
}