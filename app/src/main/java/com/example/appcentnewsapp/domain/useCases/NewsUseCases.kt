package com.example.appcentnewsapp.domain.useCases

data class NewsUseCases (
    val getNews: GetNews,
    val searchNews: SearchNews,
    val searchNewsWithCategory: SearchNewsWithCategory,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val getArticle: GetArticle,
    val getArticleList: GetArticleList
)