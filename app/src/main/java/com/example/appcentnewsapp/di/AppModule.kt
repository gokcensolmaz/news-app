package com.example.appcentnewsapp.di

import android.app.Application
import androidx.room.Room
import com.example.appcentnewsapp.data.local.NewsDao
import com.example.appcentnewsapp.data.local.NewsDatabase
import com.example.appcentnewsapp.data.local.SourceTypeConverter
import com.example.appcentnewsapp.data.remote.NewsApi
import com.example.appcentnewsapp.data.remote.NewsApi.Companion.BASE_URL
import com.example.appcentnewsapp.data.repository.NewsRepositoryImpl
import com.example.appcentnewsapp.domain.repository.NewsRepository
import com.example.appcentnewsapp.domain.useCases.DeleteArticle
import com.example.appcentnewsapp.domain.useCases.GetArticle
import com.example.appcentnewsapp.domain.useCases.GetArticleList
import com.example.appcentnewsapp.domain.useCases.GetNews
import com.example.appcentnewsapp.domain.useCases.NewsUseCases
import com.example.appcentnewsapp.domain.useCases.SearchNews
import com.example.appcentnewsapp.domain.useCases.UpsertArticle
import com.example.appcentnewsapp.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)


    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            getArticle = GetArticle(newsRepository),
            getArticleList = GetArticleList(newsRepository)
        )
    }
    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(SourceTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}