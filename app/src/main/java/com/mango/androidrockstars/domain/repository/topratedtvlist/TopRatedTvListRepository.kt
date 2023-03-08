package com.mango.androidrockstars.domain.repository.topratedtvlist

import com.mango.androidrockstars.domain.model.topratedtvlist.TopRatedTvPage

interface TopRatedTvListRepository {
    suspend fun getTopRatedTvList(): TopRatedTvPage
}