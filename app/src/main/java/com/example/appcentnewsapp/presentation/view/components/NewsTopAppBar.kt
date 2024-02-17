package com.example.appcentnewsapp.presentation.view.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.appcentnewsapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsTopAppBar() {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        colors = topAppBarColors(
            containerColor = colorResource(id = R.color.appcent)
        ),
        title = {
            Image(
                painter = painterResource(id = if (isSystemInDarkTheme()) R.drawable.appcent_logo_bg else R.drawable.appcent_logo_bg_dark),
                contentDescription = null
            )
        },
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TopAppBarPreview() {
    NewsTopAppBar()
}