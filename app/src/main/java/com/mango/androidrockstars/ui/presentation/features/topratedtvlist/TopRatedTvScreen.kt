package com.mango.androidrockstars.ui.presentation.features.topratedtvlist

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mango.androidrockstars.R
import com.mango.androidrockstars.data.model.features.topratedtvlist.TopRatedTv
import com.mango.androidrockstars.ui.presentation.components.TopBar
import com.mango.androidrockstars.ui.presentation.features.topratedtvlist.components.ListItemCard
import com.mango.androidrockstars.ui.theme.AndroidRockStarsTheme
import kotlin.math.roundToInt
import kotlin.random.Random


@Composable
fun TopRatedTvListScreen(navController: NavHostController = rememberNavController()) {

    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(id = R.string.app_name)
            )
        },
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
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
                .padding(top = 10.dp),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
//            contentPadding = PaddingValues(12.dp),
//            verticalArrangement = Arrangement.SpaceEvenly,
//            horizontalArrangement = Arrangement.Center,
//            horizontalArrangement = Arrangement.SpaceBetween,
            horizontalArrangement = Arrangement.spacedBy(12.dp),

            ) {
            items(listItemData){
                ListItemCard(image = "", title = it.name, totalVotes = it.voteCount, averageRate = it.voteAverage, actionClick = {})
            }
        }
}

@Preview("Light Theme", showBackground = true)
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun TopRatedTvListScreenBothThemesPreview() {

    val list = mutableListOf<TopRatedTv.Result>()

    (0..20).forEach {
        list.add(
            TopRatedTv.Result(
                posterPath = "",
                name = "Tv Show " + "${Random.nextInt(1, 20)}",
                voteCount = Random.nextInt(20, 700),
                voteAverage = Random.nextDouble(0.1 * 100, 5.0 * 100).roundToInt() / 100.0,
            )
        )
    }
    AndroidRockStarsTheme {
        AndroidRockStarsTheme {
            Scaffold(
                topBar = {
                    TopBar(
                        title = stringResource(id = R.string.app_name)
                    )
                },
                modifier = Modifier.fillMaxSize(),
                backgroundColor = Color.DarkGray
            ) {
                it
                ListItemCard(list)
            }
        }
    }
}

