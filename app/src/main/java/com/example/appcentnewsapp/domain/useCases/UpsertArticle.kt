package com.example.appcentnewsapp.domain.useCases

import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.domain.repository.NewsRepository

class UpsertArticle(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(article: Article) {
        newsRepository.upsertArticle(article)
    }
}