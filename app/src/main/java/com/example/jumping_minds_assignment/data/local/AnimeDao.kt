package com.example.jumping_minds_assignment.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jumping_minds_assignment.domain.models.Anime
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(anime: Anime)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(anime: List<Anime>)

    @Delete
    suspend fun delete(anime: Anime)

    @Query("UPDATE anime SET isFavourite = :isFav WHERE mal_id = :mal_id")
    suspend fun markAsFavorite(mal_id: Int, isFav:Boolean)

    @Query("SELECT * FROM anime WHERE isFavourite = 1")
    fun getFavoriteAnime(): Flow<List<Anime>>

    @Query("SELECT * FROM anime WHERE isFavourite = 1 AND mal_id = :mal_id")
    suspend fun getFavAnimeByID(mal_id: Int): Anime

    @Query("SELECT * FROM anime")
    suspend fun getAllAnime(): List<Anime>


}