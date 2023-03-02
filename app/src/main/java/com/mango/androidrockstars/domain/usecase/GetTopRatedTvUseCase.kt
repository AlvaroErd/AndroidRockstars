package com.mango.androidrockstars.domain.usecase

import com.mango.androidrockstars.domain.model.TopRatedTvPage
import com.mango.androidrockstars.domain.repository.TopRatedTvRepository
import javax.inject.Inject

class GetTopRatedTvUseCase @Inject constructor(
    private val topRepository: TopRatedTvRepository
) {

    suspend fun getTopRatedTv(): TopRatedTvPage = topRepository.getTopRatedTv()
}