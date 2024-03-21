package com.example.jumping_minds_assignment.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.jumping_minds_assignment.domain.models.Anime

class SearchAnimePagingSource (
    private val animeApi: AnimeApi,
    private val searchQuery: String
):PagingSource<Int,Anime>(){
    override fun getRefreshKey(state: PagingState<Int, Anime>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
        val page = params.key ?: 1

        return try {
            val animeResponse = animeApi.searchAnime(page = page, searchQuery = searchQuery)

            LoadResult.Page(
                data = animeResponse.data,
                nextKey = if(animeResponse.pagination.has_next_page == true) page + 1 else null,
                prevKey = if (animeResponse.pagination.current_page == 1) null else page - 1
            )

        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
}