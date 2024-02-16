package com.example.appcentnewsapp.presentation.viewmodel.search

import androidx.paging.PagingData
import com.example.appcentnewsapp.data.local.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)