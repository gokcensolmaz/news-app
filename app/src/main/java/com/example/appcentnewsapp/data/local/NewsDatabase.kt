package com.example.appcentnewsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Article::class], version = 2)
@TypeConverters(SourceTypeConverter::class)
abstract class NewsDatabase : RoomDatabase (){
    abstract val newsDao: NewsDao
}