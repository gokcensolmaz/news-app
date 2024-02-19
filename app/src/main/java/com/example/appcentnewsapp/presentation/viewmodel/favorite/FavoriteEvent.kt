package com.example.appcentnewsapp.presentation.viewmodel.favorite

import com.example.appcentnewsapp.data.local.Article

sealed class FavoriteEvent {
    data class DeleteArticle(val article: Article): FavoriteEvent()

    object RemoveSideEffect: FavoriteEvent()
}