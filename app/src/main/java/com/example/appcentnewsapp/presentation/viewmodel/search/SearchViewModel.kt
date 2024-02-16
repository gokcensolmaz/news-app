package com.example.appcentnewsapp.presentation.viewmodel.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.appcentnewsapp.domain.useCases.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {
    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    fun onEvent(event: SearchEvent){
        when(event){
            is SearchEvent.updateSearchQuery -> {
                _state.value = state.value.copy(event.searchQuery)
            }
            is SearchEvent.searchNews ->{
                searchNews()
            }
        }

    }

    private fun searchNews() {
        val articles = newsUseCases.searchNews(
            searchQuery = state.value.searchQuery
        ).cachedIn(viewModelScope)
        _state.value = state.value.copy(articles = articles)
    }
}