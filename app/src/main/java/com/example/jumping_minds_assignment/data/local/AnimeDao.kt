package com.example.jumping_minds_assignment.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.jumping_minds_assignment.domain.models.Anime

@Dao
interface AnimeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(anime: Anime)

    @Delete
    suspend fun deleteArticle(anime: Anime)

}