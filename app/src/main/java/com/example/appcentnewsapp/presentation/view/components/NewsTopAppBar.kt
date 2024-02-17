package com.example.appcentnewsapp.presentation.view.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
fun NewsTopAppBar(title: String? = null, onBackClick: () -> Unit) {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        colors = topAppBarColors(
            containerColor = colorResource(id = R.color.appcent)
        ),
        title = {
            if (title == null) {
                Image(
                    painter = painterResource(id = if (isSystemInDarkTheme()) R.drawable.appcent_logo_bg else R.drawable.appcent_logo_bg_dark),
                    contentDescription = null
                )
            } else Text(text = title)

        },
        navigationIcon = {
            if (title == "Web View") {
                IconButton(onClick = { onBackClick() }) {
                    Icon(imageVector =  Icons.Default.ArrowBack, contentDescription = null)

                }
            } else null
        }
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TopAppBarPreview() {
    NewsTopAppBar(onBackClick = {})
}