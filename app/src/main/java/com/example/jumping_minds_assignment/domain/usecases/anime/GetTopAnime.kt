package com.example.jumping_minds_assignment.domain.usecases.anime

import androidx.paging.PagingData
import com.example.jumping_minds_assignment.domain.models.Anime
import com.example.jumping_minds_assignment.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

class GetTopAnime(
    private val animeRepository: AnimeRepository
) {
    operator fun invoke(): Flow<PagingData<Anime>> {
        return animeRepository.getTopAnimes()
    }
}