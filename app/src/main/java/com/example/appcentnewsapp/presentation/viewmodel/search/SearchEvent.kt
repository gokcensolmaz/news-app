package com.example.appcentnewsapp.presentation.viewmodel.search

sealed class SearchEvent {
    data class updateSearchQuery(val searchQuery: String) : SearchEvent()
    object searchNews: SearchEvent()

}