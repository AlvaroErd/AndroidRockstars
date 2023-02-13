package com.mango.androidrockstars.domain.repository

import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResultList

interface TopRatedTvRepository {
    suspend fun getTopRatedTv(): ApiResultList
}