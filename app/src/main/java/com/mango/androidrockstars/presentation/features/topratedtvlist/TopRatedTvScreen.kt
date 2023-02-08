package com.mango.androidrockstars.presentation.features.topratedtvlist

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mango.androidrockstars.R
import com.mango.androidrockstars.model.features.topratedtvlist.TopRatedTv
import com.mango.androidrockstars.presentation.components.TopBar
import com.mango.androidrockstars.presentation.features.topratedtvlist.components.ListItem
import com.mango.androidrockstars.ui.theme.AndroidRockStarsTheme
import kotlin.random.Random


@Composable
fun TopRatedTvScreen(navController: NavHostController = rememberNavController()){

    Scaffold(
        topBar = { TopBar(
            title = stringResource(id = R.string.app_name))},
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.DarkGray
    ) {
        it
    }
}
@Composable
fun ListItemCard(listItemData : List<TopRatedTv.Result>) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            items(listItemData){
                ListItem(image = "", title = it.name, totalVotes = it.voteCount, averageRate = it.voteAverage)
            }
        }
}

@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TopRatedTvScreenBothThemesPreview() {

    val list = mutableListOf<TopRatedTv.Result>()

    (0..20).forEach {
        list.add(
            TopRatedTv.Result(
                posterPath = "",
                name = "Movie $i",
                voteCount = Random.nextInt(20, 700),
                voteAverage = Random.nextDouble(0.1, 5.0)
            )
        )
    }

    AndroidRockStarsTheme {
        ListItemCard(listOf())
    }
}

