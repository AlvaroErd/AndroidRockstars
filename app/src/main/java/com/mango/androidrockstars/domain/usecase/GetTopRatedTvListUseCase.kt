package com.mango.androidrockstars.domain.usecase

import com.mango.androidrockstars.domain.model.TopRatedTvPage
import com.mango.androidrockstars.domain.repository.TopRatedTvListRepository
import javax.inject.Inject

class GetTopRatedTvListUseCase @Inject constructor(
    private val topRepository: TopRatedTvListRepository
) {
    suspend fun getTopRatedTv(): TopRatedTvPage = topRepository.getTopRatedTvList()
}