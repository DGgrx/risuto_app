package com.example.jumping_minds_assignment.data.remote

import com.example.jumping_minds_assignment.data.remote.dto.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApi {

    @GET("top/anime")
    suspend fun getTopAnime(
        @Query("page") page: Int,
        @Query("limit") limit :Int = 20
    ): AnimeResponse

    @GET("anime")
    suspend fun searchAnime(
        @Query("page") page: Int,
        @Query("q") searchQuery: String
    ):AnimeResponse

}