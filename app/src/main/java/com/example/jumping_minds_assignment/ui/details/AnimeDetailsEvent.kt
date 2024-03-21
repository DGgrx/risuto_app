package com.example.jumping_minds_assignment.ui.details

import com.example.jumping_minds_assignment.domain.models.Anime

sealed class AnimeDetailsEvent {
    data class FavouriteAnime(var anime: Anime) : AnimeDetailsEvent()

    object RemoveSideEffect : AnimeDetailsEvent()
}