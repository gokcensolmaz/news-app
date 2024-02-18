package com.example.appcentnewsapp.presentation.view.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.appcentnewsapp.R
import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.presentation.view.components.ArticlesList
import com.example.appcentnewsapp.presentation.view.components.NewsTopAppBar
import com.example.appcentnewsapp.presentation.view.components.SearchBar
import com.example.appcentnewsapp.presentation.viewmodel.search.SearchEvent
import com.example.appcentnewsapp.presentation.viewmodel.search.SearchState
import com.example.appcentnewsapp.util.Dimensions
import com.example.appcentnewsapp.util.Dimensions.MediumPadding1
import com.example.appcentnewsapp.util.Dimensions.MediumPadding2


@Composable
fun SearchScreen(
    state: SearchState, event: (SearchEvent) -> Unit, navigateToDetails: (Article) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        NewsTopAppBar(title = null, onBackClick = {})
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "\uD83D\uDD0D Search News",
            fontSize = Dimensions.topAppBarTitleSize,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.appcent_text)
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        SearchBar(modifier = Modifier.padding(horizontal = 25.dp),
            text = state.searchQuery,
            readOnly = false,
            onValueChange = {
                event(SearchEvent.updateSearchQuery(it))
            },
            onSearch = {
                event(SearchEvent.searchNews)
            },
            onCleanBar = {
                event(SearchEvent.cleanSearchQuery)
            })
        Spacer(modifier = Modifier.height(MediumPadding1))


        if (state.articles == null) {
            Text(
                modifier = Modifier.padding(horizontal = 18.dp),
                text = "\uD83D\uDDC2\uFE0F Categories",
                fontSize = Dimensions.categoriesSize,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.appcent_text)
            )
            Spacer(modifier= Modifier.height(MediumPadding2))
            SearchCategoryScreen(
                onClick = { event(SearchEvent.searchNewsWithCategory(it)) }
            )
        } else {
            state.articles?.let {
                val articles = it.collectAsLazyPagingItems()
                ArticlesList(articles = articles, onClick = { navigateToDetails(it) })
            }
        }

    }
}