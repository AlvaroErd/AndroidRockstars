package com.mango.androidrockstars.domain.usecase

import com.mango.androidrockstars.data.repository.TopRatedTvRepositoryListImpl
import com.mango.androidrockstars.domain.model.TopRatedTvPage
import com.mango.androidrockstars.domain.repository.TopRatedTvRepository

class GetTopRatedTvUseCase {
    private val topRepository: TopRatedTvRepository = TopRatedTvRepositoryListImpl()

    /*Todo Mirar alternativas implementacion de repositorio*/
    suspend fun getTopRatedTv(): TopRatedTvPage = topRepository.getTopRatedTv()
}