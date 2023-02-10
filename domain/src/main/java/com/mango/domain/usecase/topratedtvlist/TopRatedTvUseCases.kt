package com.mango.domain.usecase.topratedtvlist

data class TopRatedTvUseCases(
    val getTopRatedTvUseCase: GetTopRatedTvUseCase
)

class TopRatedTvUseCases(private val repository: MovieDomainRepository) {
    suspend operator fun invoke(): Flow<List<Movie>> {
        return flowOf(repository.getNowPlaying())
    }
}
