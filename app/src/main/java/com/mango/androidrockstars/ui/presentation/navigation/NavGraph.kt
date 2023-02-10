package com.mango.androidrockstars.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mango.androidrockstars.ui.presentation.features.topratedtvlist.TopRatedTvListScreen
import com.mango.androidrockstars.ui.presentation.features.topratedtvlist.TopRatedTvViewModel

@Composable
fun NavGraph(navController: NavHostController, topRatedViewModel: TopRatedTvViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            TopRatedTvListScreen(viewModel = topRatedViewModel)
        }
    }
}