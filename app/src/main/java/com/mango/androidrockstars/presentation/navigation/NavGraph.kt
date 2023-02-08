package com.mango.androidrockstars.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mango.androidrockstars.presentation.features.topratedtvlist.TopRatedTvScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            TopRatedTvScreen(navController = navController)
        }
    }
}