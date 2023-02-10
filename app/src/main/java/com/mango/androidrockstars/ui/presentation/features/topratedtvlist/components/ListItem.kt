package com.mango.androidrockstars.ui.presentation.features.topratedtvlist.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mango.androidrockstars.R
import com.mango.androidrockstars.data.model.features.topratedtvlist.TopRatedTv
import com.mango.androidrockstars.ui.theme.AndroidRockStarsTheme

@Composable
fun ListItemCard(
    image: String,
    title: String,
    totalVotes: Int,
    averageRate: Double,
    actionClick: (TopRatedTv.Result) -> Unit,
    colorStar: Color = Color(0xFFFBD309),
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = Modifier
                .padding(bottom = 10.dp),
        ) {
//            AsyncImage(
//                model = "https://loremflickr.com/400/400/cat?",
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .size(180.dp),
//                contentScale = ContentScale.Crop,
//                )
            Image(
//                painter = painterResource(id = R.drawable.ic_launcher_background),
                painter = painterResource(id = R.drawable.wakanda),
                contentDescription = null,
                modifier = Modifier
                    .clip(shape = MaterialTheme.shapes.medium),
//            contentScale = ContentScale.FillHeight,
                alignment = Alignment.Center,
            )
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(top = 7.dp),
                color = MaterialTheme.colors.onPrimary
            )
            Row(
//                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = averageRate.toString(),
                    color = MaterialTheme.colors.onPrimary
                )
                Icon(
                    Icons.Filled.Star,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = colorStar
                )
                Text(
                    text = "of ${totalVotes.toString()} votes",
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}

@Preview("Light Theme", showBackground = true)
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ListItemBothThemesPreview() {
    AndroidRockStarsTheme {
        ListItemCard(
            image = "",
            title = "Movie 1",
            totalVotes = 10,
            averageRate = 4.7,
            actionClick = { })
    }
}