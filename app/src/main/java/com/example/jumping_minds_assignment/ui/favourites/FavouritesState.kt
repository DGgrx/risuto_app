package com.example.jumping_minds_assignment.ui.favourites

import com.example.jumping_minds_assignment.domain.models.Anime

data class FavouritesState(
    val favAnimes: List<Anime> = emptyList()
)
