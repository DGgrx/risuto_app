package com.example.jumping_minds_assignment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jumping_minds_assignment.domain.models.Anime

@Database(entities = [Anime::class], version = 1)
@TypeConverters(AnimeTypeConverter::class)
abstract class AnimeDatabase : RoomDatabase() {

    abstract val animeDao: AnimeDao

}