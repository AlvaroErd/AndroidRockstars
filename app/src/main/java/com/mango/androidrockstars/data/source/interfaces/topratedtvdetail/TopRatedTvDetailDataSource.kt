package com.mango.androidrockstars.data.source.interfaces.topratedtvdetail

import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiTvDetailResponse

interface TopRatedTvDetailDataSource {
    suspend fun getTopRatedTvDetail(tvId: Int): ApiTvDetailResponse
}