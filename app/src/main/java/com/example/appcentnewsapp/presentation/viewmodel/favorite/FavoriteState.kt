package com.example.appcentnewsapp.presentation.viewmodel.favorite

import com.example.appcentnewsapp.data.local.Article

data class FavoriteState (
    val articles: List<Article> = emptyList()
)