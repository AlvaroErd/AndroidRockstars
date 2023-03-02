package com.mango.androidrockstars.data.source

import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiListResponse


interface TopRatedTvDataSource {
    suspend fun getTopRatedTvList(): ApiListResponse
}