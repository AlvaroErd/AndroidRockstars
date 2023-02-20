package com.mango.androidrockstars.domain.usecase

import com.mango.androidrockstars.data.repository.TopRatedTvRepositoryListImpl
import com.mango.androidrockstars.domain.model.TopRatedTvPage
import com.mango.androidrockstars.domain.repository.TopRatedTvRepository

class GetTopRatedTvUseCase {
    private val topRepository: TopRatedTvRepository = TopRatedTvRepositoryListImpl()

    suspend fun getTopRatedTv(): TopRatedTvPage = topRepository.getTopRatedTv()
}