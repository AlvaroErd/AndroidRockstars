package com.mango.androidrockstars.ui.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mango.androidrockstars.ui.theme.AndroidRockStarsTheme

@Composable
fun ProgressIndicator(isDisplayed: Boolean) {
    if (isDisplayed) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(100.dp),
                    color = MaterialTheme.colors.onPrimary
                )
                Text(
                    text = "Loading ...",
                    modifier = Modifier.padding(all = 15.dp)
                )
            }
        }
    }
}


@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProgressIndicatorPreview() {
    AndroidRockStarsTheme {
        ProgressIndicator(isDisplayed = true)
    }
}