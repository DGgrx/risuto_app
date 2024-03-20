package com.example.jumping_minds_assignment.data.remote.dto

import com.example.jumping_minds_assignment.domain.models.Anime
import com.example.jumping_minds_assignment.domain.models.Pagination

data class AnimeResponse(
    val `data`: List<Anime>,
    val pagination: Pagination
)