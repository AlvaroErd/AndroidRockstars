package com.mango.androidrockstars.ui.presentation.features.topratedtvdetail

import androidx.lifecycle.ViewModel
import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TopRatedTvDetailViewModel : ViewModel() {
    private val _navigationTvTopRatedDetail by lazy { MutableStateFlow(ApiResult()) }
    val navigationTvTopRatedDetail: StateFlow<ApiResult>
        get() = this._navigationTvTopRatedDetail

    fun updateDetails(apiResult: ApiResult) {
        this._navigationTvTopRatedDetail.update {
            apiResult
        }
    }
}
