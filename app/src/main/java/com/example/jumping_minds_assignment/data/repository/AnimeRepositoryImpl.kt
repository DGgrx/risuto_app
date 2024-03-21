package com.example.jumping_minds_assignment.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.jumping_minds_assignment.data.local.AnimeDao
import com.example.jumping_minds_assignment.data.remote.AnimeApi
import com.example.jumping_minds_assignment.data.remote.AnimePagingSource
import com.example.jumping_minds_assignment.data.remote.SearchAnimePagingSource
import com.example.jumping_minds_assignment.domain.models.Anime
import com.example.jumping_minds_assignment.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow

class AnimeRepositoryImpl(
    private val animeApi: AnimeApi,
    private val animeDao: AnimeDao
) : AnimeRepository {
    override fun getTopAnimes(): Flow<PagingData<Anime>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                AnimePagingSource(
                    animeApi = animeApi,
                    animeDao = animeDao,
                )
            }
        ).flow
    }

    override fun searchAnime(searchQuery: String): Flow<PagingData<Anime>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                SearchAnimePagingSource(
                    animeApi = animeApi,
                    searchQuery = searchQuery
                )
            }
        ).flow
    }


}