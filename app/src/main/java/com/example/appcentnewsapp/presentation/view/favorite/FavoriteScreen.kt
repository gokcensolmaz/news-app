package com.example.appcentnewsapp.presentation.view.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appcentnewsapp.R
import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.presentation.view.components.ArticlesList
import com.example.appcentnewsapp.presentation.view.components.NewsTopAppBar
import com.example.appcentnewsapp.presentation.viewmodel.details.DetailsEvent
import com.example.appcentnewsapp.presentation.viewmodel.favorite.FavoriteEvent
import com.example.appcentnewsapp.presentation.viewmodel.favorite.FavoriteState
import com.example.appcentnewsapp.util.Dimensions
import com.example.appcentnewsapp.util.Dimensions.MediumPadding1

@Composable
fun FavoriteScreen(
    state: FavoriteState,
    navigateToDetails: (Article) -> Unit,
    event: (FavoriteEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NewsTopAppBar(onBackClick = {})

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "❤\uFE0F Favorite",
            fontSize = Dimensions.topAppBarTitleSize,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.appcent_text)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        ArticlesList(articles = state.articles, onClick = { navigateToDetails(it) },event = event)

    }
}