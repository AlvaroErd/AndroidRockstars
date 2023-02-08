package com.mango.androidrockstars.presentation.features.topratedtvlist.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mango.androidrockstars.R
import com.mango.androidrockstars.ui.theme.AndroidRockStarsTheme

@Composable
fun ListItem(image: String, title: String, totalVotes: Int, averageRate: Double) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = ""
            )
            Text(text = title)
            Text(text = totalVotes.toString())
            Text(text = averageRate.toString())
        }
    }
}

@Preview("Light Theme", showBackground = true)
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ListItemBothThemesPreview() {
    AndroidRockStarsTheme {
        ListItem(image = "", title = "Movie 1", totalVotes = 10, averageRate = 4.7)
    }
}