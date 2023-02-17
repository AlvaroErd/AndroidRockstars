package com.mango.androidrockstars.ui.presentation.features.topratedtvlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiDetailResponse
import com.mango.androidrockstars.domain.model.TopRatedTvProperties
import com.mango.androidrockstars.domain.usecase.GetTopRatedTvUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class TopRatedTvViewModel : ViewModel() {
    private val topRatedTvUseCase: GetTopRatedTvUseCase = GetTopRatedTvUseCase()

    private val _topRatedTvList: MutableStateFlow<List<TopRatedTvProperties>> by lazy {
        MutableStateFlow(
            listOf()
        )
    }

    val topRatedTvList: StateFlow<List<TopRatedTvProperties>>
        get() = _topRatedTvList


    init {
        viewModelScope.launch(Dispatchers.IO) {
            this@TopRatedTvViewModel._topRatedTvList.update { topRatedTvUseCase.getTopRatedTv().results }
        }
    }


    //For CricularProgressIndicator
    val isLoading = mutableStateOf(false)
}


//Mock
val topRated1 =
    ApiDetailResponse(1, "/tfdiVvJkYMbUOXDWibPjzu5dY6S.jpg", "Peli 1", 8223, 4.7, "", "", "")
val topRated2 =
    ApiDetailResponse(2, "/utOLkQhxuhwN3PN0UEPnfhJnkrf.jpg", "Peli 2", 342, 3.5, "", "", "")
val topRated3 =
    ApiDetailResponse(3, "/1yeVJox3rjo2jBKrrihIMj7uoS9.jpg", "Peli 3", 32, 2.5, "", "", "")
val topRated4 =
    ApiDetailResponse(4, "/esKFbCWAGyUUNshT5HE5BIpvbcL.jpg", "Peli 4", 122, 3.1, "", "", "")
val topRated5 =
    ApiDetailResponse(5, "/mWNadwBZIx8NyEw4smGftYtHHrE.jpg", "Peli 5", 111, 2.3, "", "", "")
val topRated6 =
    ApiDetailResponse(6, "/vHXZGe5tz4fcrqki9ZANkJISVKg.jpg", "Peli 6", 8453, 1.8, "", "", "")
val topRated7 =
    ApiDetailResponse(7, "/jIhL6mlT7AblhbHJgEoiBIOUVl1.jpg", "Peli 7", 2342, 4.3, "", "", "")
val topRated8 =
    ApiDetailResponse(8, "/u0cLcBQITrYqfHsn06fxnQwtqiE.jpg", "Peli 8", 6527, 2.4, "", "", "")

val topRatedTvListMock = listOf<ApiDetailResponse>(
    topRated1, topRated2, topRated3, topRated4, topRated5, topRated6, topRated7, topRated8
)