package com.example.appcentnewsapp.data.remote

import com.example.appcentnewsapp.data.remote.response.NewsResponse
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



    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = "e8a1ecdbafdd4f5da079ed98d3d0dc72"
    }
}