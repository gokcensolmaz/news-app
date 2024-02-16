package com.example.appcentnewsapp.domain.repository

import androidx.paging.PagingData
import com.example.appcentnewsapp.data.local.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>
    fun searchNews(searchQuery: String): Flow<PagingData<Article>>
    suspend fun upsertArticle(article: Article)
    suspend fun deleteArticle(article: Article)
    fun getArticleList(): Flow<List<Article>>
    suspend fun getArticle(url: String): Article?
}