package com.example.jumping_minds_assignment.domain.usecases.anime

import com.example.jumping_minds_assignment.data.local.AnimeDao
import com.example.jumping_minds_assignment.domain.models.Anime

class InsertAnime(
    private val animeDao: AnimeDao
) {
    suspend operator fun invoke(anime: Anime){
        return animeDao.insert(anime = anime)
    }
}