package com.example.jumping_minds_assignment.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.jumping_minds_assignment.data.remote.AnimeApi
import com.example.jumping_minds_assignment.data.remote.AnimePagingSource
import com.example.jumping_minds_assignment.domain.models.Data
import com.example.jumping_minds_assignment.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

class AnimeRepositoryImpl(
    private val animeApi: AnimeApi
) : AnimeRepository {
    override fun getTopAnimes(): Flow<PagingData<Data>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                AnimePagingSource(
                    animeApi = animeApi,
                )
            }
        ).flow
    }


}