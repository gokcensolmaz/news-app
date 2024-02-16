package com.example.appcentnewsapp.data.repository

import androidx.paging.PagingData
import com.example.appcentnewsapp.data.remote.NewsApi
import com.example.appcentnewsapp.data.remote.response.Article
import com.example.appcentnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository{
    override fun getNews(language: List<String>): Flow<PagingData<Article>> {
        TODO("Not yet implemented")
    }

    override fun searchNews(
        searchQuery: String,
        language: List<String>
    ): Flow<PagingData<Article>> {
        TODO("Not yet implemented")
    }

}