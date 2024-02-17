package com.example.appcentnewsapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Upsert
    suspend fun upsertArticle(article: Article)

    @Delete
    suspend fun deleteArticle(article: Article)

    @Query("SELECT * FROM Article")
    fun getArticleList(): Flow<List<Article>>

    @Query("SELECT * FROM Article WHERE url = :url")
    suspend fun getArticle(url: String): Article?

}