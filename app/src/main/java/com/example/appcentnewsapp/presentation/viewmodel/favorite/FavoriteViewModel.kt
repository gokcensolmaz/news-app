package com.example.appcentnewsapp.presentation.viewmodel.favorite

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.domain.useCases.NewsUseCases
import com.example.appcentnewsapp.presentation.viewmodel.details.DetailsEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

    private val _state = mutableStateOf(FavoriteState())
    val state: State<FavoriteState> = _state

    init {
        getArticles()
    }

    var sideEffect by mutableStateOf<String?>(null)
        private set

    fun onEvent(event: FavoriteEvent) {
        when (event) {
            is FavoriteEvent.DeleteArticle -> {
                viewModelScope.launch {
                    deleteArticle(event.article)
                }
            }

            is FavoriteEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }

    private fun getArticles() {
        newsUseCases.getArticleList().onEach {
            _state.value = _state.value.copy(articles = it.asReversed())
        }.launchIn(viewModelScope)
    }

    private suspend fun deleteArticle(article: Article) {
        newsUseCases.deleteArticle(article = article)
        sideEffect = "Article Deleted"
    }
}