package com.example.appcentnewsapp.presentation.view.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.presentation.view.components.ArticlesList
import com.example.appcentnewsapp.presentation.view.components.SearchBar
import com.example.appcentnewsapp.presentation.viewmodel.search.SearchEvent
import com.example.appcentnewsapp.presentation.viewmodel.search.SearchState
import com.example.appcentnewsapp.util.Dimensions.MediumPadding1


@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(
                top = MediumPadding1, start = MediumPadding1, end = MediumPadding1
            )
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        SearchBar(text = state.searchQuery,
            readOnly = false,
            onValueChange = {
                event(SearchEvent.updateSearchQuery(it))
            },
            onSearch = {
                event(SearchEvent.searchNews)
            },
            onCleanBar = {
                event(SearchEvent.cleanSearchQuery)
            }
        )
        Spacer(modifier = Modifier.height(MediumPadding1))

        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(articles = articles, onClick = { navigateToDetails(it) })
        }
    }
}