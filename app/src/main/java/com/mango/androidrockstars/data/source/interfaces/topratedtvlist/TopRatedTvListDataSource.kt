package com.mango.androidrockstars.data.source.interfaces.topratedtvlist

import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiListResponse

interface TopRatedTvListDataSource {
    suspend fun getTopRatedTvList(): ApiListResponse
}