package com.mango.androidrockstars.domain.repository

import com.mango.androidrockstars.domain.model.TvShowDetail

interface TopRatedTvDetailRepository {
    suspend fun getTopRatedTvDetail(): TvShowDetail
}