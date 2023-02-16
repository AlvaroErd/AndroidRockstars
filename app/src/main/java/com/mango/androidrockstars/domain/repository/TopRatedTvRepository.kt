package com.mango.androidrockstars.domain.repository

import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiResultList

interface TopRatedTvRepository {
    suspend fun getTopRatedTv(): ApiResultList
}