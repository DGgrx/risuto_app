package com.example.jumping_minds_assignment.domain.usecases.anime

data class AnimeUseCases(
    val getTopAnime: GetTopAnime,
    val getFavouriteAnime: GetFavouriteAnime,
    val searchAnime: SearchAnime,
    val markAsFavAnime: MarkAsFavAnime,
    val deleteAnime: DeleteAnime,
    val insertAnime: InsertAnime,
    val getFavAnimeByID: GetFavAnimeByID
)

