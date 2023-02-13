package com.mango.androidrockstars.data.repository

import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResultList
import com.mango.androidrockstars.data.remote.RemoteTopRatedTvDataSource
import com.mango.androidrockstars.domain.repository.TopRatedTvRepository

class TopRatedTvRepositoryImpl : TopRatedTvRepository {
    private val remoteTopRatedTvDataSource: RemoteTopRatedTvDataSource =
        RemoteTopRatedTvDataSource()

    override suspend fun getTopRatedTv(): ApiResultList {
        return remoteTopRatedTvDataSource.getTopRatedTvList()
    }
}