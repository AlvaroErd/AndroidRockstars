package com.mango.androidrockstars.data.repository

import com.mango.androidrockstars.data.datasource.features.topratedtvlist.remote.mapper.topRatedTvListResponseMapper
import com.mango.androidrockstars.data.source.TopRatedTvDataSource
import com.mango.androidrockstars.domain.model.TopRatedTvPage
import com.mango.androidrockstars.domain.repository.TopRatedTvRepository
import javax.inject.Inject

class TopRatedTvListRepositoryImpl @Inject constructor(
    private val remoteTopRatedTvDataSource: TopRatedTvDataSource
) : TopRatedTvRepository {


    override suspend fun getTopRatedTv(): TopRatedTvPage {
        val data = remoteTopRatedTvDataSource.getTopRatedTvList()
        return topRatedTvListResponseMapper(data)
    }
}
