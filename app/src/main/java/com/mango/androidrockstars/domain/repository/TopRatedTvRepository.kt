package com.mango.androidrockstars.domain.repository

import com.mango.androidrockstars.domain.model.TopRatedTvPage

interface TopRatedTvRepository {
    suspend fun getTopRatedTv(): TopRatedTvPage
}