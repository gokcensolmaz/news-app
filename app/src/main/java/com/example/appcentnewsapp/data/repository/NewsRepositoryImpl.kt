package com.example.appcentnewsapp.data.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.appcentnewsapp.data.remote.NewsApi
import com.example.appcentnewsapp.data.remote.NewsPagingResource
import com.example.appcentnewsapp.data.remote.SearchNewsPagingResource
import com.example.appcentnewsapp.data.remote.response.Article
import com.example.appcentnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingResource(
                    newsApi = newsApi,
                    sources = sources.joinToString(",")
                )
            }
        ).flow
    }

    override fun searchNews(
        searchQuery: String,
        sources: List<String>
    ): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingResource(
                    newsApi = newsApi,
                    sources = sources.joinToString(","),
                    searchQuery = searchQuery
                )
            }
        ).flow
    }

}