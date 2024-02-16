package com.example.appcentnewsapp.data.remote.response

import com.example.appcentnewsapp.data.local.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
