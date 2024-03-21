package com.example.jumping_minds_assignment.domain.usecases.anime

import com.example.jumping_minds_assignment.data.local.AnimeDao

class MarkAsFavAnime(
    private val animeDao: AnimeDao
) {
    suspend operator fun invoke(mal_id: Int, isFav: Boolean) {
        return animeDao.markAsFavorite(mal_id = mal_id, isFav)
    }
}