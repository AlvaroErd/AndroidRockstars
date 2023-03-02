package com.mango.androidrockstars.ui.presentation.features.topratedtvdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.androidrockstars.domain.model.TvShowDetail
import com.mango.androidrockstars.domain.repository.TopRatedTvDetailRepository
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

    fun fetchTvShowDetail(tvId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = topRatedTvRepository.getTopRatedTvDetail(tvId)
            _tvTopRatedDetail.update {
                result
            }
        }
    }
}
