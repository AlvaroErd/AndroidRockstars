package com.mango.androidrockstars.ui.presentation.features.topratedtvlist

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.mango.androidrockstars.R
import com.mango.androidrockstars.domain.model.topratedtvlist.TopRatedTvProperties
import com.mango.androidrockstars.ui.presentation.components.ProgressIndicator
import com.mango.androidrockstars.ui.presentation.components.TopBar
import java.text.DecimalFormat

@Composable
fun TopRatedTvListScreen(
    viewModelTvList: TopRatedTvListViewModel,
    onItemClick: (Int) -> Unit
) {
    val loading = viewModelTvList.loading.value
    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(id = R.string.app_name)
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 0.dp),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            ProgressIndicator(isDisplayed = loading)
            ListCards(paddingValues = it, onItemClick = onItemClick)
        }
    }
}

@Composable
fun ListCards(
    topRatedTvListScreenViewModel: TopRatedTvListViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    onItemClick: (Int) -> Unit,
) {
    val topRatedTvListItems: LazyPagingItems<TopRatedTvProperties> =
        topRatedTvListScreenViewModel.topRatedTvPaging.collectAsLazyPagingItems()
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(paddingValues),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        items(topRatedTvListItems.itemCount) { key ->
            topRatedTvListItems[key]?.let { item ->
                ListItemCard(item) {
                    onItemClick(item.id)
                }
            }
        }
    }
}


@Composable
fun ListItemCard(
    item: TopRatedTvProperties,
    onItemClick: (tvId: Int) -> Unit,
) {
    val colorStar = Color(0xFFFBD309)
    var showMore by remember { mutableStateOf(false) }
    val df = DecimalFormat("#.#")
    val voteCountFormatted = if (item.voteCount < 1000)
        "${item.voteCount}" else "${
        if (item.voteCount in 1000..999999)
            df.format((item.voteCount / 1000.0)).toString().replace(',', '.')
        else df.format((item.voteCount / 1000000.0)).toString().replace(',', '.')
    }${if (item.voteCount in 1000..999999) "k" else "M"}"

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier
        ) {
            AsyncImage(
                model = item.posterPathList,
                contentDescription = stringResource(R.string.poster_image, item.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.large)
                    .clickable {
                        onItemClick(item.id)
                    }
                    .aspectRatio(2 / 3f),
            )
            Column(
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .animateContentSize(animationSpec = tween(100))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { showMore = !showMore }
            ) {
                Text(
                    text = item.name,
                    maxLines = if (showMore) Int.MAX_VALUE else 1,
                    overflow = if (showMore) TextOverflow.Visible else TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 5.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.onPrimary
                )
                Row {
                    Text(
                        text = item.voteAverage.toString().replace('.', ','),
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.onPrimary
                    )
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = stringResource(R.string.stars),
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = colorStar
                    )
                    Text(
                        text = "of $voteCountFormatted votes",
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.onPrimary,

                        )
                }
            }
        }
    }
}

/*
Como con Coil y Jetpack no se pueden mostrar imagenes en la preview, lo que podemos hacer es mostrar
 un placeholder con una imagen de nuestro repositorio, asi podemos previsualizar la card completa.

.aspectRatio(2 / 3f),
placeholder = painterResource(R.drawable.wakanda),*/

/*
Otra manera de crear un mock con datos aleatorios

    val list = mutableListOf<ApiDetailResponse>()

    (0..20).forEach {
        list.add(
            ApiDetailResponse(
                posterPath = "",
                name = "Tv Show " + "${Random.nextInt(1, 20)}",
                voteCount = Random.nextInt(20, 700),
                voteAverage = Random.nextDouble(0.1 * 100, 5.0 * 100).roundToInt() / 100.0,
            )
        )
    }
*/