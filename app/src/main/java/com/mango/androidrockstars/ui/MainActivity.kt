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
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mango.androidrockstars.ui.presentation.features.topratedtvdetail.TopRatedTvDetailActivity
import com.mango.androidrockstars.ui.presentation.features.topratedtvlist.TopRatedTvListScreen
import com.mango.androidrockstars.ui.presentation.features.topratedtvlist.TopRatedTvListViewModel
import com.mango.androidrockstars.ui.theme.AndroidRockStarsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val topRatedTvViewModel: TopRatedTvListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            AndroidRockStarsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface,
                )
                {
                    Thread.sleep(2000)
                    screenSplash.setKeepOnScreenCondition { true }
                    TopRatedTvListScreen(topRatedTvViewModel,
                        onItemClick = { tvId ->
                            navigateToDetailActivity(tvId)
                        }
                    )
                    screenSplash.setKeepOnScreenCondition { false }
                }

            }
        }
    }

    private fun navigateToDetailActivity(tvId: Int) {
        val intent = Intent(this, TopRatedTvDetailActivity::class.java)
        intent.putExtra("TV_ID", tvId)
        this.startActivity(intent)

    }

}