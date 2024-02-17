package com.example.appcentnewsapp.data.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.appcentnewsapp.data.remote.NewsApi
import com.example.appcentnewsapp.data.remote.NewsPagingResource
import com.example.appcentnewsapp.data.remote.SearchNewsPagingResource
import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.data.local.NewsDao
import com.example.appcentnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
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
        searchQuery: String
    ): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingResource(
                    newsApi = newsApi,
                    searchQuery = searchQuery
                )
            }
        ).flow
    }

    override fun searchNewsWithCategory(
        searchQuery: String
    ): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingResource(
                    newsApi = newsApi,
                    searchQuery = searchQuery
                )
            }
        ).flow
    }

    override suspend fun upsertArticle(article: Article) {
        newsDao.upsertArticle(article)
    }

    override suspend fun deleteArticle(article: Article) {
        newsDao.deleteArticle(article)
    }

    override fun getArticleList(): Flow<List<Article>> {
        return newsDao.getArticleList()
    }

    override suspend fun getArticle(url: String): Article? {
        return newsDao.getArticle(url)
    }

}