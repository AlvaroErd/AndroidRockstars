package com.mango.androidrockstars.ui.presentation.features.topratedtvlist


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
//        ListItemCard(viewModel.topRatedTvListMock)
        ListItemCards(ratedTvList)
    }
}


@Composable
fun ListItemCards(ratedTvList: List<ApiResult>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(top = 10.dp, end = 10.dp),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 5.dp),
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

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier
                .padding(bottom = 10.dp),
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${item.posterPath}",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                text = item.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(top = 7.dp),
                color = MaterialTheme.colors.onPrimary
            )
            Row(
//                modifier = Modifier.fillMaxWidth()
            ) {
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
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}


//@Composable
//fun ListItemCard(ratedTvList: List<ApiResult>) {
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(MaterialTheme.colors.background)
//            .padding(top = 10.dp, end = 10.dp),
//        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 5.dp),
//        horizontalArrangement = Arrangement.spacedBy(20.dp),
//        verticalArrangement = Arrangement.Center,
//    ) {
//        items( ratedTvList )
//    }
//}
//}

//
//@Composable
//fun ListItemCard(
//    itemsTvList: ApiResult
//) {
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(MaterialTheme.colors.background)
//            .padding(top = 10.dp, end = 10.dp),
//        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 5.dp),
//        horizontalArrangement = Arrangement.spacedBy(20.dp),
//        verticalArrangement = Arrangement.Center,
//    ) {
//        ListItemCard(
//            name = itemsTvList.name,
//            posterPath: String,
//            voteAverage: Double,
//            voteCount: Int,
//        )
//
//    }
//}


//
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
