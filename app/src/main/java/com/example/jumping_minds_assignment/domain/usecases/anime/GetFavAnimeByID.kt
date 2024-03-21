package com.example.jumping_minds_assignment.domain.usecases.anime

import com.example.jumping_minds_assignment.data.local.AnimeDao
import com.example.jumping_minds_assignment.domain.models.Anime

class GetFavAnimeByID(
    private val animeDao: AnimeDao
) {
    suspend operator fun invoke(mal_id: Int): Anime {
        return animeDao.getFavAnimeByID(mal_id = mal_id)
    }
}