package com.mango.androidrockstars.data.source.interfaces.topratedtvdetail

import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiTvDetailResponse
import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiListResponse

interface TopRatedTvDetailDataSource {
    suspend fun getTopRatedTvDetail(tvId: Int): ApiTvDetailResponse
    suspend fun getTopRatedTvSimilar(tvId: Int): ApiListResponse
}