package com.example.appcentnewsapp.domain.useCases

import androidx.paging.PagingData
import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String): Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery = searchQuery)
    }
}