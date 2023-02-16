package com.mango.androidrockstars.domain.usecase

import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResultList
import com.mango.androidrockstars.data.model.features.topratedtvlist.repository.TopRatedTvRepositoryImpl
import com.mango.androidrockstars.domain.repository.TopRatedTvRepository

class GetTopRatedTvUseCase {
    private val topRepository: TopRatedTvRepository = TopRatedTvRepositoryImpl()
    suspend fun getTopRatedTv(): ApiResultList = topRepository.getTopRatedTv()
}