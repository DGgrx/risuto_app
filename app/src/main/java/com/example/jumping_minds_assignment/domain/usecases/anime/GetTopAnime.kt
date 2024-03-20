package com.example.jumping_minds_assignment.domain.usecases.anime

import androidx.paging.PagingData
import com.example.jumping_minds_assignment.domain.models.Data
import com.example.jumping_minds_assignment.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

class GetTopAnime(
    private val animeRepository: AnimeRepository
) {
    operator fun invoke(): Flow<PagingData<Data>> {
        return animeRepository.getTopAnimes()
    }
}