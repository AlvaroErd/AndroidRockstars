package com.mango.androidrockstars.domain.usecase

import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiResultDetail
import com.mango.androidrockstars.data.repository.TopRatedTvDetailRepositoryImpl
import com.mango.androidrockstars.domain.repository.TopRatedTvDetailRepository

class GetTopRatedTvDetailTopCase {
    private val topDetailRepository: TopRatedTvDetailRepository = TopRatedTvDetailRepositoryImpl()
    suspend fun getTopRatedTvDetail(): ApiResultDetail = topDetailRepository.getTopRatedTvDetail()
}