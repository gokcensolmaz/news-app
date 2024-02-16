package com.example.appcentnewsapp.di

import com.example.appcentnewsapp.data.remote.NewsApi
import com.example.appcentnewsapp.data.remote.NewsApi.Companion.BASE_URL
import com.example.appcentnewsapp.data.repository.NewsRepositoryImpl
import com.example.appcentnewsapp.domain.repository.NewsRepository
import com.example.appcentnewsapp.domain.useCases.GetNews
import com.example.appcentnewsapp.domain.useCases.NewsUseCases
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
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)


    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }
}