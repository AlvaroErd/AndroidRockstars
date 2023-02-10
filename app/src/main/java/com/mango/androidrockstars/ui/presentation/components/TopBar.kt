package com.mango.androidrockstars.ui.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.mango.androidrockstars.R
import com.mango.androidrockstars.ui.theme.AndroidRockStarsTheme


@Composable
fun TopBar(
    title: String,
    actionBack: (() -> Unit)? = null,
) {

    TopAppBar(
        title = {
            Text(
                (title),
                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h5
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        navigationIcon = {
            if (actionBack != null) {
                IconButton(onClick = actionBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}


@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TopBarBothThemesPreview() {
    AndroidRockStarsTheme {

        TopBar(title = "Next destination with back icon", { })
    }
}