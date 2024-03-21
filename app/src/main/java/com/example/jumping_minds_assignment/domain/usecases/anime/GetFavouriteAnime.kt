package com.example.jumping_minds_assignment.domain.usecases.anime

import com.example.jumping_minds_assignment.data.local.AnimeDao
import com.example.jumping_minds_assignment.domain.models.Anime
import kotlinx.coroutines.flow.Flow

class GetFavouriteAnime(
    private val animeDao: AnimeDao
) {
     operator fun invoke() : Flow<List<Anime>> {
        return animeDao.getFavoriteAnime()
    }
}