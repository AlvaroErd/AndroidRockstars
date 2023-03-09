package com.mango.androidrockstars.ui.presentation.features.topratedtvdetail

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mango.androidrockstars.R
import com.mango.androidrockstars.domain.model.topratedtvlist.TopRatedTvProperties
import com.mango.androidrockstars.ui.theme.AndroidRockStarsTheme
import com.mango.androidrockstars.ui.theme.androidRockstarsLightSurface

@Composable
fun ListSimilarTvShowCards(
    items: List<TopRatedTvProperties>, onItemClick: (tvId: Int) -> Unit
) {
    AndroidRockStarsTheme {
        Column(
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 12.dp),
        ) {
            Text(
                text = stringResource(R.string.similar_tv_shows),
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface
            )
            Spacer(modifier = Modifier.height(5.dp))
            LazyRow {
                items(items) { item ->
                    SimilarTvShowCard(item = item, onItemClick = onItemClick)
                }
            }
        }
    }
}

@Composable
fun SimilarTvShowCard(
    item: TopRatedTvProperties,
    onItemClick: (tvId: Int) -> Unit,
) {
    val colorStar = Color(0xFFFBD309)
    Box(
        modifier = Modifier
            .height(200.dp)
            .width(150.dp)
            .padding(end = 7.dp),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = item.posterPathList,
            contentDescription = stringResource(R.string.poster_image, item.name),
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .clickable {
                    onItemClick(item.id)
                }
                .fillMaxSize(1f)
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            Brush.verticalGradient(
                                0.5f to Color.Black.copy(alpha = 0F),
                                1F to Color.Black
                            )
                        )
                    }
                },
        )
        Text(
            text = item.name,
            modifier = Modifier.padding(top = 120.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = androidRockstarsLightSurface
        )
        Row(modifier = Modifier.padding(top = 160.dp)) {
            Text(
                text = item.voteAverage.toString(),
                color = androidRockstarsLightSurface,
                fontSize = 12.sp,
            )
            Icon(
                Icons.Filled.Star,
                contentDescription = stringResource(R.string.stars),
                modifier = Modifier.size(ButtonDefaults.IconSize),
                tint = colorStar
            )
        }
    }
}


@SuppressLint("ResourceType")
@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SimilarTvShowCardBothThemesPreview() {
    AndroidRockStarsTheme {
        SimilarTvShowCard(
            TopRatedTvProperties(
                id = 8,
                posterPathList = "",
                name = "Movie 1",
                voteCount = 423,
                voteAverage = 4.8
            ),
            { }
        )
    }
}


@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ListSimilarTvShowCardsPreview() {
    AndroidRockStarsTheme {
        ListSimilarTvShowCards(items = topRatedTvListMock, onItemClick = {})
    }
}