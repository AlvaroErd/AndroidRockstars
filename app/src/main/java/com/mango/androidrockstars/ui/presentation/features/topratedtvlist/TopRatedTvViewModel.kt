package com.mango.androidrockstars.ui.presentation.features.topratedtvlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResult
import com.mango.androidrockstars.domain.usecase.GetTopRatedTvUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class TopRatedTvViewModel : ViewModel() {
    private val topRatedTvRepository: GetTopRatedTvUseCase = GetTopRatedTvUseCase()

    val isLoading = mutableStateOf(false)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            this@TopRatedTvViewModel._topRatedTvList.update { topRatedTvRepository.getTopRatedTv().results }
        }
    }

    private val _topRatedTvList: MutableStateFlow<List<ApiResult>> by lazy {
        MutableStateFlow(
            listOf()
        )
    }

    val topRatedTvList: StateFlow<List<ApiResult>>
        get() = _topRatedTvList


    fun topRatedTvList() {
        viewModelScope.launch(Dispatchers.Default) {
            _topRatedTvList.update {
                val response = topRatedTvRepository.getTopRatedTv()
                response.results
            }
        }

    }
}


//Mock
//    val topRated1 = TopRatedTvProperties("Peli 1", "", 4.5, 834)
//    val topRated2 = TopRatedTvProperties("Peli 2", "", 3.5, 342)
//    val topRated3 = TopRatedTvProperties("Peli 3", "", 2.5, 32)
//    val topRated4 = TopRatedTvProperties("Peli 4", "", 3.1, 122)
//    val topRated5 = TopRatedTvProperties("Peli 5", "", 2.3, 111)
//    val topRated6 = TopRatedTvProperties("Peli 6", "", 1.8, 8453)
//    val topRated7 = TopRatedTvProperties("Peli 7", "", 4.3, 2342)
//    val topRated8 = TopRatedTvProperties("Peli 8", "", 2.4, 6527)
//
//    val topRatedTvListMock = listOf<TopRatedTvProperties>(
//        topRated1, topRated2, topRated3, topRated4, topRated5, topRated6, topRated7, topRated8
//    )
//}


