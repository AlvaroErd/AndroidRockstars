package com.mango.androidrockstars.domain.repository.topratedtvdetail

import com.mango.androidrockstars.domain.model.topratedtvdetail.TvShowDetail
import com.mango.androidrockstars.domain.model.topratedtvlist.TopRatedTvPage

interface TopRatedTvDetailRepository {
    suspend fun getTopRatedTvDetail(tvId: Int): TvShowDetail
    suspend fun getTopRatedTvSimilar(tvId: Int): TopRatedTvPage
}