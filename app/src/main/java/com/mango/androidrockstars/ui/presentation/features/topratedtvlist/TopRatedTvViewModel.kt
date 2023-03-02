package com.mango.androidrockstars.ui.presentation.features.topratedtvlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.androidrockstars.domain.model.TopRatedTvProperties
import com.mango.androidrockstars.domain.usecase.GetTopRatedTvUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopRatedTvViewModel @Inject constructor(
    private val topRatedTvUseCase: GetTopRatedTvUseCase
) : ViewModel() {


    private val _topRatedTvList: MutableStateFlow<List<TopRatedTvProperties>> by lazy {
        MutableStateFlow(
            listOf()
        )
    }

    val topRatedTvList: StateFlow<List<TopRatedTvProperties>>
        get() = _topRatedTvList


    //For manage state of CircularProgressIndicator
    val loading = mutableStateOf(true)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            // To show that the Circular Progress indicator is loading during 0.5 sec
            delay(500)
            this@TopRatedTvViewModel._topRatedTvList.update { topRatedTvUseCase.getTopRatedTv().results }
            loading.value = false
        }
    }
}

//Mock
val topRated1 = TopRatedTvProperties("Tv Show 1", "", 4.5, 834, 1)
val topRated2 = TopRatedTvProperties("Tv Show 2", "", 3.5, 342, 2)
val topRated3 = TopRatedTvProperties("Tv Show 3", "", 2.5, 32, 3)
val topRated4 = TopRatedTvProperties("Tv Show 4", "", 3.1, 122, 4)
val topRated5 = TopRatedTvProperties("Tv Show 5", "", 2.3, 111, 5)
val topRated6 = TopRatedTvProperties("Tv Show 6", "", 1.8, 8453, 6)
val topRated7 = TopRatedTvProperties("Tv Show 7", "", 4.3, 2342, 7)
val topRated8 = TopRatedTvProperties("Tv Show 8", "", 2.4, 6527, 8)

val topRatedTvListMock = listOf(
    topRated1, topRated2, topRated3, topRated4, topRated5, topRated6, topRated7, topRated8
)
