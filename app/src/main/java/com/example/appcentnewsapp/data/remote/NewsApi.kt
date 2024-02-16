package com.example.appcentnewsapp.data.remote

import com.example.appcentnewsapp.data.remote.response.NewsResponse
import com.example.appcentnewsapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("sources") sources: String
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("sources") sources: String
    ): NewsResponse
}