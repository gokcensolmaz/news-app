package com.example.appcentnewsapp.presentation.view.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.appcentnewsapp.R
import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.presentation.view.components.ArticlesList
import com.example.appcentnewsapp.presentation.view.components.NewsTopAppBar
import com.example.appcentnewsapp.util.Dimensions.MediumPadding1
import com.example.appcentnewsapp.util.Dimensions.MediumPadding2
import com.example.appcentnewsapp.util.Dimensions.topAppBarTitleSize


@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NewsTopAppBar(onBackClick = {})

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "\uD83D\uDFE5 Breaking News",
            fontSize = topAppBarTitleSize,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.appcent_text)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        ArticlesList(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            articles = articles,
            onClick = {
                navigateToDetails(it)
            }
        )
    }

}