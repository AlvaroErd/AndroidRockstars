package com.mango.androidrockstars.domain.repository.topratedtvdetail

import com.mango.androidrockstars.domain.model.topratedtvdetail.TvShowDetail

interface TopRatedTvDetailRepository {
    suspend fun getTopRatedTvDetail(tvId: Int): TvShowDetail
}