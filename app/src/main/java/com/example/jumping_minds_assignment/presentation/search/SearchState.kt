package com.example.jumping_minds_assignment.presentation.search

import androidx.paging.PagingData
import com.example.jumping_minds_assignment.domain.models.Anime
import kotlinx.coroutines.flow.Flow

data class SearchState(
    var searchQuery :String = "",
    val animes : Flow<PagingData<Anime>>? = null
)