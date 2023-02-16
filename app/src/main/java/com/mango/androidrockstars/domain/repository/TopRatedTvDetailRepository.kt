package com.mango.androidrockstars.domain.repository

import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResultDetail

interface TopRatedTvDetailRepository {
    suspend fun getTopRatedTvDetail(): ApiResultDetail
}