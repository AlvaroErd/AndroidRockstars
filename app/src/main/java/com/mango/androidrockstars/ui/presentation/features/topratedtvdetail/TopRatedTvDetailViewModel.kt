package com.mango.androidrockstars.ui.presentation.features.topratedtvdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.androidrockstars.domain.model.topratedtvdetail.TvShowDetail
import com.mango.androidrockstars.domain.model.topratedtvlist.TopRatedTvProperties
import com.mango.androidrockstars.domain.repository.topratedtvdetail.TopRatedTvDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopRatedTvDetailViewModel @Inject constructor(
    private var topRatedTvRepository: TopRatedTvDetailRepository
) : ViewModel() {

    private val _tvTopRatedDetail: MutableStateFlow<TvShowDetail> by lazy {
        MutableStateFlow(TvShowDetail())
    }

    val tvShowDetail: StateFlow<TvShowDetail>
        get() = _tvTopRatedDetail


    private val _topRatedTvSimilar: MutableStateFlow<List<TopRatedTvProperties>> by lazy {
        MutableStateFlow(listOf())
    }

    val tvShowSimilar: MutableStateFlow<List<TopRatedTvProperties>>
        get() = _topRatedTvSimilar

    fun fetchTvShowDetail(tvId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = topRatedTvRepository.getTopRatedTvDetail(tvId)
            _tvTopRatedDetail.update { result }
            this@TopRatedTvDetailViewModel._topRatedTvSimilar.update {
                topRatedTvRepository.getTopRatedTvSimilar(tvId).results
            }
        }
    }
}

//Mock
val topRated1 = TopRatedTvProperties(1, "", "Tv Show 1", 834, 4.5)
val topRated2 = TopRatedTvProperties(2, "", "Tv Show 2", 342, 3.5)
val topRated3 = TopRatedTvProperties(3, "", "Tv Show 3", 323, 2.5)
val topRated4 = TopRatedTvProperties(4, "", "Tv Show 4", 122, 3.1)
val topRated5 = TopRatedTvProperties(5, "", "Tv Show 5", 111, 2.3)
val topRated6 = TopRatedTvProperties(6, "", "Tv Show 6", 843, 1.8)
val topRated7 = TopRatedTvProperties(7, "", "Tv Show 7", 242, 4.3)
val topRated8 = TopRatedTvProperties(8, "", "Tv Show 8", 657, 2.4)

val topRatedTvListMock = listOf(
    topRated1, topRated2, topRated3, topRated4, topRated5, topRated6, topRated7, topRated8
)