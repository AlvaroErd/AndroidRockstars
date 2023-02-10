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
import com.mango.androidrockstars.R
import com.mango.androidrockstars.domain.model.TopRatedTvProperties
import com.mango.androidrockstars.ui.presentation.components.TopBar
import com.mango.androidrockstars.ui.presentation.features.topratedtvlist.components.ListItemCard
import com.mango.androidrockstars.ui.theme.AndroidRockStarsTheme
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun TopRatedTvListScreen(viewModel: TopRatedTvViewModel) {
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
        ListItemCard(viewModel.topRatedTvList)
    }
}
@Composable
fun ListItemCard(listItemData: List<TopRatedTvProperties>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(top = 10.dp, end = 10.dp),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.Center,


        ) {
        items(listItemData) {
            ListItemCard(
                image = "",
                title = it.name,
                totalVotes = it.voteCount,
                averageRate = it.voteAverage,
                actionClick = {})
        }
    }
}

@Preview("Light Theme", showBackground = true)
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun TopRatedTvListScreenBothThemesPreview() {

    val list = mutableListOf<TopRatedTvProperties>()

    (0..20).forEach {
        list.add(
            TopRatedTvProperties(
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

