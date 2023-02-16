package com.mango.androidrockstars.data.repository

import com.mango.androidrockstars.data.datasource.features.topratedtvlist.remote.mapper.topRatedTvListResponseMapper
import com.mango.androidrockstars.data.source.RemoteTopRatedTvDataSource
import com.mango.androidrockstars.domain.model.TopRatedTvPage
import com.mango.androidrockstars.domain.repository.TopRatedTvRepository

class TopRatedTvRepositoryListImpl : TopRatedTvRepository {
    private val remoteTopRatedTvDataSource: RemoteTopRatedTvDataSource =
        RemoteTopRatedTvDataSource()

    override suspend fun getTopRatedTv(): TopRatedTvPage {
        val data = remoteTopRatedTvDataSource.getTopRatedTvList()
        return topRatedTvListResponseMapper(data)
    }
}
