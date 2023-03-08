package com.mango.androidrockstars.domain.usecase

import com.mango.androidrockstars.domain.model.topratedtvlist.TopRatedTvPage
import com.mango.androidrockstars.domain.repository.topratedtvlist.TopRatedTvListRepository
import javax.inject.Inject

class GetTopRatedTvListUseCase @Inject constructor(
    private val topRepository: TopRatedTvListRepository
) {
    suspend fun getTopRatedTv(): TopRatedTvPage = topRepository.getTopRatedTvList()
}