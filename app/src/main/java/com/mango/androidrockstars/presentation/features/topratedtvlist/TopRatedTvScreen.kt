package com.mango.androidrockstars.presentation.features.topratedtvlist

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.mango.androidrockstars.R
import com.mango.androidrockstars.presentation.components.TopBar
import com.mango.androidrockstars.ui.theme.AndroidRockStarsTheme


@Composable
fun TopRatedTvScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopBar(
            title = stringResource(id = R.string.app_name))},
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.DarkGray
    ) {
        it
        Text(text = "Hola soy un texto")
    }
}


@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TopRatedTvScreenBothThemesPreview() {
    AndroidRockStarsTheme {
//        TopRatedTvScreen()
    }
}

////    val movieListItems: LazyPagingItems<TopRatedTv.Result> =
////        TopRatedTvViewModel.TopRatedTv.collectAsLazyPagingItems()
//
//    Scaffold(
//        topBar = { TopBar() },
//        modifier = Modifier.fillMaxSize(),
//        backgroundColor = Color.DarkGray
//    ) {
////        LazyVerticalGrid(
////            columns = GridCells.Fixed(2),
////            modifier = Modifier.fillMaxSize(),
////            verticalArrangement = Arrangement.SpaceEvenly
////        ) {
////            items()
////        }
////    }
//        Text(text = "Hello")
//}
//

