package com.mango.androidrockstars.domain.usecase

import com.mango.androidrockstars.data.repository.TopRatedTvDetailRepositoryImpl
import com.mango.androidrockstars.domain.model.TvShowDetail
import com.mango.androidrockstars.domain.repository.TopRatedTvDetailRepository

class GetTopRatedTvDetailUseCase {
    private val topDetailRepository: TopRatedTvDetailRepository = TopRatedTvDetailRepositoryImpl()
    suspend fun getTopRatedTvDetail(tvId: Int): TvShowDetail =
        topDetailRepository.getTopRatedTvDetail(tvId)
}