package com.mango.androidrockstars.domain.usecase

import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiResultList
import com.mango.androidrockstars.data.repository.TopRatedTvRepositoryListImpl
import com.mango.androidrockstars.domain.repository.TopRatedTvRepository

class GetTopRatedTvUseCase {
    private val topRepository: TopRatedTvRepository = TopRatedTvRepositoryListImpl()
    suspend fun getTopRatedTv(): ApiResultList = topRepository.getTopRatedTv()
}