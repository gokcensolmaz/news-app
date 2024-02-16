package com.example.appcentnewsapp.domain.useCases

import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetArticleList (
    private val newsRepository: NewsRepository
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.getArticleList()
    }
}