package com.mango.androidrockstars.data.repository

import com.mango.androidrockstars.data.datasource.features.topratedtvlist.remote.mapper.topRatedTvListResponseMapper
import com.mango.androidrockstars.data.source.TopRatedTvListDataSource
import com.mango.androidrockstars.domain.model.TopRatedTvPage
import com.mango.androidrockstars.domain.repository.TopRatedTvListRepository
import javax.inject.Inject

class TopRatedTvListRepositoryImpl @Inject constructor(
    private val remoteTopRatedTvDataSource: TopRatedTvListDataSource
) : TopRatedTvListRepository {


    override suspend fun getTopRatedTvList(): TopRatedTvPage {
        val data = remoteTopRatedTvDataSource.getTopRatedTvList()
        return topRatedTvListResponseMapper(data)
    }
}
