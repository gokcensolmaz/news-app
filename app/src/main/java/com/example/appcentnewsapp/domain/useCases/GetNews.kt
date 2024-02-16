package com.example.appcentnewsapp.domain.useCases

import androidx.paging.PagingData
import com.example.appcentnewsapp.data.remote.response.Article
import com.example.appcentnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources)
    }
}