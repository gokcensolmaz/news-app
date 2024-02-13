package com.example.appcentnewsapp.data.remote

import com.example.appcentnewsapp.data.remote.respond.NewsArticleDto
import retrofit2.http.GET

interface NewsApi {

    @GET()
    suspend fun getNewsArticles(

    ): NewsArticleDto




    companion object{
        const val BASE_URL = "https://newsapi.org/v2/"
        const val  API_KEY = "e8a1ecdbafdd4f5da079ed98d3d0dc72"
    }
}