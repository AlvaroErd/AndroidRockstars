package com.mango.androidrockstars.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val LightColorPalette = lightColors(
    background = androidRockstarsLightBackground,
    surface = androidRockstarsLightSurface,
    onSurface = androidRockstarsLightSecondary,
    primary = androidRockstarsLightOnSurface,
    onPrimary = androidRockstarsLightPrimary,
    secondary = androidRockstarsLightOnPrimary,


    )

private val DarkColorPalette = darkColors(
    background = androidRockstarsDarkBackground,
    surface = androidRockstarsDarkSurface,
    onSurface = androidRockstarsDarkSecondary,
    primary = androidRockstarsDarkOnSurface,
    onPrimary = androidRockstarsDarkPrimary,
    secondary = androidRockstarsDarkOnPrimary,

    )

private val darkBlueStatus = androidRockstarsDarkBlueStatus
private val lightGrayStatus = androidRockstarsLightGrayStatus
@Composable
fun AndroidRockStarsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

//    val systemUiController = rememberSystemUiController()
//    SideEffect {
//        systemUiController.setSystemBarsColor(
//            color = if (darkTheme) darkBlueStatus
//            else lightGrayStatus
//        )
//    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}