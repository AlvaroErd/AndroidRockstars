package com.mango.androidrockstars.ui.presentation.features.topratedtvlist


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mango.androidrockstars.R
import com.mango.androidrockstars.data.model.features.topratedtvlist.ApiResult
import com.mango.androidrockstars.ui.presentation.components.TopBar

@Composable
fun TopRatedTvListScreen(viewModel: TopRatedTvViewModel) {
    val ratedTvList by viewModel.topRatedTvList.collectAsState()

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
        if (viewModel.isLoading.value) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        } else {
//        ListItemCard(viewModel.topRatedTvListMock)
            ListItemCards(ratedTvList)
        }

    }
}

@Composable
fun ListItemCards(ratedTvList: List<ApiResult>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(top = 10.dp, end = 10.dp),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        items(ratedTvList) { item ->
            ListItemCard(item)
        }
    }
}


@Composable
fun ListItemCard(
    item: ApiResult,
) {
    val colorStar = Color(0xFFFBD309)
    var showMore by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier
//                .padding(bottom = 10.dp)
                .clickable {
                },
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${item.posterPath}",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .aspectRatio(2 / 3f)
            )
            Text(
                text = item.name,
                modifier = Modifier.padding(top = 5.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onPrimary
            )
            Row(
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .animateContentSize(animationSpec = tween(100))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { showMore = !showMore }
            ) {
                if (showMore) {
                    Text(
                        text = item.voteAverage.toString(),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = null,
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = colorStar
                    )
                    Text(
                        text = "of ${item.voteCount.toString()} votes",
                        color = MaterialTheme.colors.onPrimary,
                    )
                } else {
                    Text(
                        text = item.voteAverage.toString(),
                        color = MaterialTheme.colors.onPrimary
                    )
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = null,
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = colorStar
                    )
                    Text(
                        text = "of ${item.voteCount.toString()} votes",
                        color = MaterialTheme.colors.onPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

            }
        }
    }
}





//@Preview("Light Theme", showBackground = true)
//@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Composable
//fun TopRatedTvListScreenBothThemesPreview() {
//
//    val list = mutableListOf<TopRatedTvProperties>()
//
//    (0..20).forEach {
//        list.add(
//            TopRatedTvProperties(
//                posterPath = "",
//                name = "Tv Show " + "${Random.nextInt(1, 20)}",
//                voteCount = Random.nextInt(20, 700),
//                voteAverage = Random.nextDouble(0.1 * 100, 5.0 * 100).roundToInt() / 100.0,
//            )
//        )
//    }
//    AndroidRockStarsTheme {
//        AndroidRockStarsTheme {
//            Scaffold(
//                topBar = {
//                    TopBar(
//                        title = stringResource(id = R.string.app_name)
//                    )
//                },
//                modifier = Modifier.fillMaxSize(),
//                backgroundColor = Color.DarkGray
//            ) {
//                it
//                ListItemCard()
//            }
//        }
//    }
//}
//
