package com.mango.androidrockstars.domain.repository

import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiDetailResponse

interface TopRatedTvDetailRepository {
    suspend fun getTopRatedTvDetail(): ApiDetailResponse
}