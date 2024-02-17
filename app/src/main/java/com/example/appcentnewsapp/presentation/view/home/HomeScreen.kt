package com.example.appcentnewsapp.presentation.view.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.util.Dimensions.ExtraSmallPadding2
import com.example.appcentnewsapp.util.Dimensions.MediumPadding1
import com.example.appcentnewsapp.presentation.view.components.ArticleCard
import com.example.appcentnewsapp.presentation.view.components.NewsTopAppBar
import com.example.appcentnewsapp.presentation.view.components.SearchBar


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
        NewsTopAppBar()


        SearchBar(
            modifier = Modifier.padding(horizontal = 25.dp),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = { },
            onClick = { navigateToSearch() },
            onCleanBar = {}
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallPadding2)
        ) {

            items(count = articles.itemCount) {
                articles[it]?.let { article ->
                    ArticleCard(article = article, onClick = {navigateToDetails(article) })
                }
            }
        }
    }

}