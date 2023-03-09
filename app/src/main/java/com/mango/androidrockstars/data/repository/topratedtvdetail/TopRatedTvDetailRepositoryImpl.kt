package com.mango.androidrockstars.data.repository.topratedtvdetail

import com.mango.androidrockstars.data.datasource.features.toprateddetail.remote.mapper.tvShowDetailResponseMapper
import com.mango.androidrockstars.data.datasource.features.topratedtvlist.remote.mapper.topRatedTvListResponseMapper
import com.mango.androidrockstars.data.source.interfaces.topratedtvdetail.TopRatedTvDetailDataSource
import com.mango.androidrockstars.domain.model.topratedtvdetail.TvShowDetail
import com.mango.androidrockstars.domain.model.topratedtvlist.TopRatedTvPage
import com.mango.androidrockstars.domain.repository.topratedtvdetail.TopRatedTvDetailRepository
import javax.inject.Inject

class TopRatedTvDetailRepositoryImpl @Inject constructor(
    private val remoteTopRatedTvDetailDataSource: TopRatedTvDetailDataSource
) : TopRatedTvDetailRepository {

    override suspend fun getTopRatedTvDetail(tvId: Int): TvShowDetail {
        val data = remoteTopRatedTvDetailDataSource.getTopRatedTvDetail(tvId)
        return tvShowDetailResponseMapper(data)
    }

    override suspend fun getTopRatedTvSimilar(tvId: Int): TopRatedTvPage {
        val data = remoteTopRatedTvDetailDataSource.getTopRatedTvSimilar(tvId)
        return topRatedTvListResponseMapper(data)
    }
}