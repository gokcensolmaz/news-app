package com.example.appcentnewsapp.presentation.viewmodel.details

import com.example.appcentnewsapp.data.local.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article): DetailsEvent()

    object RemoveSideEffect: DetailsEvent()
}