package com.mango.androidrockstars.domain.usecase

import com.mango.androidrockstars.domain.model.topratedtvdetail.TvShowDetail
import com.mango.androidrockstars.domain.repository.topratedtvdetail.TopRatedTvDetailRepository
import javax.inject.Inject

class GetTopRatedTvDetailUseCase @Inject constructor(private val topDetailRepository: TopRatedTvDetailRepository) :
    TopRatedTvDetailRepository {
    override suspend fun getTopRatedTvDetail(tvId: Int): TvShowDetail =
        topDetailRepository.getTopRatedTvDetail(tvId)
}