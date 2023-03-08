package com.mango.androidrockstars.data.repository.topratedtvlist

import com.mango.androidrockstars.data.datasource.features.topratedtvlist.remote.mapper.topRatedTvListResponseMapper
import com.mango.androidrockstars.data.source.interfaces.topratedtvlist.TopRatedTvListDataSource
import com.mango.androidrockstars.domain.model.topratedtvlist.TopRatedTvPage
import com.mango.androidrockstars.domain.repository.topratedtvlist.TopRatedTvListRepository
import javax.inject.Inject

class TopRatedTvListRepositoryImpl @Inject constructor(
    private val remoteTopRatedTvDataSource: TopRatedTvListDataSource
) : TopRatedTvListRepository {


    override suspend fun getTopRatedTvList(): TopRatedTvPage {
        val data = remoteTopRatedTvDataSource.getTopRatedTvList()
        return topRatedTvListResponseMapper(data)
    }
}
