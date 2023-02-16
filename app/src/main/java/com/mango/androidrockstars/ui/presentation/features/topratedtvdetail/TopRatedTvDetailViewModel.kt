package com.mango.androidrockstars.ui.presentation.features.topratedtvdetail

import androidx.lifecycle.ViewModel
import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiResultDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TopRatedTvDetailViewModel : ViewModel() {
    private val _navigationTvTopRatedDetail by lazy { MutableStateFlow(ApiResultDetail()) }
    val navigationTvTopRatedDetail: StateFlow<ApiResultDetail>
        get() = this._navigationTvTopRatedDetail

    fun updateDetails(apiResult: ApiResultDetail) {
        this._navigationTvTopRatedDetail.update {
            apiResult
        }
    }
}
