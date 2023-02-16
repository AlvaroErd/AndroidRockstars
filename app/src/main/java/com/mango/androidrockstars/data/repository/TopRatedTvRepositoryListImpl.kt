package com.mango.androidrockstars.data.repository

import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiResultList
import com.mango.androidrockstars.data.source.RemoteTopRatedTvDataSource
import com.mango.androidrockstars.domain.repository.TopRatedTvRepository

class TopRatedTvRepositoryListImpl : TopRatedTvRepository {
    private val remoteTopRatedTvDataSource: RemoteTopRatedTvDataSource =
        RemoteTopRatedTvDataSource()

    override suspend fun getTopRatedTv(): ApiResultList {
        return remoteTopRatedTvDataSource.getTopRatedTvList()
    }
}
