package com.example.jumping_minds_assignment.domain.repository

import androidx.paging.PagingData
import com.example.jumping_minds_assignment.domain.models.Data
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    fun getTopAnimes() : Flow<PagingData<Data>>
}