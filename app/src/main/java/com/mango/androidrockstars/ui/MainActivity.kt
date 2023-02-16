package com.mango.androidrockstars.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.mango.androidrockstars.data.datasource.features.toprateddetail.model.ApiDetailResponse
import com.mango.androidrockstars.ui.presentation.features.topratedtvdetail.TopRatedTvDetailActivity
import com.mango.androidrockstars.ui.presentation.features.topratedtvdetail.TopRatedTvDetailViewModel
import com.mango.androidrockstars.ui.presentation.features.topratedtvlist.TopRatedTvListScreen
import com.mango.androidrockstars.ui.presentation.features.topratedtvlist.TopRatedTvViewModel
import com.mango.androidrockstars.ui.theme.AndroidRockStarsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val topRatedTvViewModel: TopRatedTvViewModel by viewModels()
    private val topRatedTvDetailViewModel: TopRatedTvDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidRockStarsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface,
                )
                {
                    TopRatedTvListScreen(topRatedTvViewModel, TopRatedTvViewModel())
                }
            }
        }
    }

    private fun navigationToDetail(item: ApiDetailResponse) {
        val intent = Intent(this, TopRatedTvDetailActivity::class.java)
        topRatedTvDetailViewModel.updateDetails(item)
    }
}