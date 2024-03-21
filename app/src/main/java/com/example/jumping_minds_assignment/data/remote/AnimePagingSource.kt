package com.example.jumping_minds_assignment.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.jumping_minds_assignment.data.local.AnimeDao
import com.example.jumping_minds_assignment.domain.models.Anime

class AnimePagingSource(
    private val animeApi: AnimeApi,
    private val animeDao: AnimeDao
) : PagingSource<Int, Anime>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
        val page = params.key ?: 1

        return try {
            val animeResponse = animeApi.getTopAnime(page = page)
            animeDao.insertAll(animeResponse.data)
            LoadResult.Page(
                data = animeResponse.data,
                nextKey = if (page == animeResponse.pagination.last_visible_page) null else page + 1,
                prevKey = if (animeResponse.pagination.current_page == 1) null else page - 1
            )


        } catch (e: Exception) {
            e.printStackTrace()
            val animeCache = animeDao.getAllAnime()
            LoadResult.Page(
                data = animeCache,
                nextKey = null,
                prevKey = null
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Anime>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}