package com.example.appcentnewsapp.domain.repository

import androidx.paging.PagingData
import com.example.appcentnewsapp.data.remote.response.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(language: List<String>): Flow<PagingData<Article>>
    fun searchNews(searchQuery: String, language: List<String>): Flow<PagingData<Article>>
}