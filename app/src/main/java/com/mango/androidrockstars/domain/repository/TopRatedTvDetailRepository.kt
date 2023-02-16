package com.mango.androidrockstars.domain.repository

import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiResultDetail

interface TopRatedTvDetailRepository {
    suspend fun getTopRatedTvDetail(): ApiResultDetail
}