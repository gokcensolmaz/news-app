package com.example.appcentnewsapp.presentation.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.appcentnewsapp.domain.useCases.NewsUseCases
import com.example.appcentnewsapp.util.Constants.NEWS_SOURCES
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {
    val news = newsUseCases.getNews(
        sources = NEWS_SOURCES
    ).cachedIn(viewModelScope)
}
