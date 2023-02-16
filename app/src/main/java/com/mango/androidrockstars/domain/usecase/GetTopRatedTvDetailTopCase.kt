package com.mango.androidrockstars.domain.usecase

import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResultDetail
import com.mango.androidrockstars.data.model.features.topratedtvlist.repository.TopRatedTvDetailRepositoryImpl
import com.mango.androidrockstars.domain.repository.TopRatedTvDetailRepository

class GetTopRatedTvDetailTopCase {
    private val topDetailRepository: TopRatedTvDetailRepository = TopRatedTvDetailRepositoryImpl()
    suspend fun getTopRatedTvDetail(): ApiResultDetail = topDetailRepository.getTopRatedTvDetail()
}