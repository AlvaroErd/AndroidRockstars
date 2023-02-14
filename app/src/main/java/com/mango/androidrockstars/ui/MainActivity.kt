package com.mango.androidrockstars.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mango.androidrockstars.ui.presentation.features.topratedtvlist.TopRatedTvListScreen
import com.mango.androidrockstars.ui.presentation.features.topratedtvlist.TopRatedTvViewModel
import com.mango.androidrockstars.ui.theme.AndroidRockStarsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val topRatedTvViewModel: TopRatedTvViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidRockStarsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface,
                )
                {
                    navController = rememberNavController()
//                    NavGraph(navController = navController, topRatedViewModel = topRatedTvViewModel)
                    TopRatedTvListScreen(topRatedTvViewModel)
                }
            }
        }
    }
}