package com.mango.androidrockstars.ui.presentation.features.topratedtvlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mango.androidrockstars.data.datasource.features.topratedtvlist.model.ApiDetailResponse
import com.mango.androidrockstars.data.remote.pagination.TopRatedTvListPagingSource
import com.mango.androidrockstars.data.repository.TopRatedTvRepository
import com.mango.androidrockstars.domain.model.TopRatedTvProperties
import com.mango.androidrockstars.domain.usecase.GetTopRatedTvListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopRatedTvListViewModel @Inject constructor(
    private val topRatedTvUseCase: GetTopRatedTvListUseCase,
    private val topRatedTvRepository: TopRatedTvRepository
) : ViewModel() {

    private val _topRatedTvList: MutableStateFlow<List<TopRatedTvProperties>> by lazy {
        MutableStateFlow(
            listOf()
        )
    }

//    val topRatedTvList: StateFlow<List<TopRatedTvProperties>>
//        get() = _topRatedTvList


    //For manage state of CircularProgressIndicator
    val loading = mutableStateOf(true)

    //For Paging
    val topRatedTvPaging: Flow<PagingData<ApiDetailResponse>> = Pager(PagingConfig(pageSize = 1)) {
        TopRatedTvListPagingSource(topRatedTvRepository)
    }.flow.cachedIn(viewModelScope)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            // To show that the Circular Progress indicator is loading during 0.5 sec
            delay(500)
            this@TopRatedTvListViewModel._topRatedTvList.update { topRatedTvUseCase.getTopRatedTv().results }
            loading.value = false
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
