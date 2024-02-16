package com.example.appcentnewsapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.appcentnewsapp.data.remote.response.Source

@ProvidedTypeConverter
class SourceTypeConverter {
    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id},${source.name}"
    }


    @TypeConverter
    fun stringToSource(source: String): Source {
        return source.split(',').let { sourceArray ->
            Source(id = sourceArray[0], name = sourceArray[1])
        }
    }
}