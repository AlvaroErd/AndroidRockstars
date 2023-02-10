package com.mango.androidrockstars.ui.presentation.navigation

sealed class Screen (val route: String) {
    object Home : Screen("home_screen")
}