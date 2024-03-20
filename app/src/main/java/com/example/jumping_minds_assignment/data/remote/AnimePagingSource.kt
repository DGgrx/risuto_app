package com.example.jumping_minds_assignment.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.jumping_minds_assignment.domain.models.Data

class AnimePagingSource(
    private val animeApi: AnimeApi,
) : PagingSource<Int, Data>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val page = params.key ?: 1

        return try {
            val animeResponse = animeApi.getTopAnime(page = page)

            LoadResult.Page(
                data = animeResponse.data,
                nextKey = if (page == animeResponse.pagination.last_visible_page) null else page + 1,
                prevKey = if (animeResponse.pagination.current_page == 1) null else page - 1
            )

        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}