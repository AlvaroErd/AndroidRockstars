package com.mango.androidrockstars.ui.presentation.features.topratedtvlist

import androidx.lifecycle.ViewModel
import com.mango.androidrockstars.domain.model.TopRatedTvProperties


class TopRatedTvViewModel(
//    topRatedTvUseCase: TopRatedTvUseCase,
) : ViewModel() {
//    val getAllTopRatedTv = topRatedTvUseCase.getTopRatedTvUseCases

        val topRated1 = TopRatedTvProperties("Peli 1", "", 4.5, 834)
        val topRated2 = TopRatedTvProperties("Peli 2", "", 3.5, 342)
        val topRated3 = TopRatedTvProperties("Peli 3", "", 2.5, 32)
        val topRated4 = TopRatedTvProperties("Peli 4", "", 3.1, 122)
        val topRated5 = TopRatedTvProperties("Peli 5", "", 2.3, 111)
        val topRated6 = TopRatedTvProperties("Peli 6", "", 1.8, 8453)
        val topRated7 = TopRatedTvProperties("Peli 7", "", 4.3, 2342)
        val topRated8 = TopRatedTvProperties("Peli 8", "", 2.4, 6527)

    val topRatedTvList = listOf<TopRatedTvProperties>(
        topRated1, topRated2, topRated3, topRated4, topRated5, topRated6, topRated7, topRated8
    )
}

