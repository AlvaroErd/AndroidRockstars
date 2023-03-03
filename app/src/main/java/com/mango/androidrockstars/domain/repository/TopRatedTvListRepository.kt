package com.mango.androidrockstars.domain.repository

import com.mango.androidrockstars.domain.model.TopRatedTvPage

interface TopRatedTvListRepository {
    suspend fun getTopRatedTvList(): TopRatedTvPage
}