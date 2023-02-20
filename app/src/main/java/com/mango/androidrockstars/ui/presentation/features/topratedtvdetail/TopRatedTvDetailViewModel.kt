package com.mango.androidrockstars.ui.presentation.features.topratedtvdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.androidrockstars.domain.model.TvShowDetail
import com.mango.androidrockstars.domain.usecase.GetTopRatedTvDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TopRatedTvDetailViewModel : ViewModel() {
    private val topRatedTvDetailUseCase: GetTopRatedTvDetailUseCase = GetTopRatedTvDetailUseCase()

    private val _TvTopRatedDetail: MutableStateFlow<TvShowDetail> by lazy {
        MutableStateFlow(TvShowDetail())
    }

    val tvShowDetail: StateFlow<TvShowDetail>
        get() = _TvTopRatedDetail

    init {
        viewModelScope.launch(Dispatchers.IO) {
            this@TopRatedTvDetailViewModel._TvTopRatedDetail.update { topRatedTvDetailUseCase.getTopRatedTvDetail() }
        }
    }
}
