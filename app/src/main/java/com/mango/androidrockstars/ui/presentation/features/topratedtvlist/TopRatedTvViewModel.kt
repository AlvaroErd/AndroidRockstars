package com.mango.androidrockstars.ui.presentation.features.topratedtvlist

import androidx.lifecycle.ViewModel
import com.mango.androidrockstars.domain.usecase.TopRatedTvUseCase


class TopRatedTvViewModel(
    topRatedTvUseCase: TopRatedTvUseCase,
) : ViewModel() {
    val getAllTopRatedTv = topRatedTvUseCase.getTopRatedTvUseCases
}
