package com.example.jumping_minds_assignment.data.remote.dto

import com.example.jumping_minds_assignment.domain.models.Data
import com.example.jumping_minds_assignment.domain.models.Pagination

data class AnimeResponse(
    val `data`: List<Data>,
    val pagination: Pagination
)