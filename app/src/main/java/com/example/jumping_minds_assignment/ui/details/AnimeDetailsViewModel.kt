package com.example.jumping_minds_assignment.ui.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jumping_minds_assignment.domain.models.Anime
import com.example.jumping_minds_assignment.domain.usecases.anime.AnimeUseCases
import com.example.jumping_minds_assignment.utils.UIComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(
    private val animeUseCases: AnimeUseCases
) : ViewModel() {

    // For showing toast
    var sideEffect by mutableStateOf<UIComponent?>(null)
        private set

    fun onEvent(event: AnimeDetailsEvent) {
        when (event) {
            is AnimeDetailsEvent.FavouriteAnime -> {
                viewModelScope.launch {
                    val anime = event.anime

                    if (anime.isFavourite) {
                        removeFromFavAnime(anime)
                    } else {
                        insertAndFavAnime(anime)
                    }

                }
            }

            is AnimeDetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }

    private suspend fun removeFromFavAnime(anime: Anime) {
        anime.mal_id?.let { animeUseCases.markAsFavAnime(mal_id = it, false) }
        sideEffect = UIComponent.Toast("Anime removed from favourites !")
    }

    private suspend fun insertAndFavAnime(anime: Anime) {
        animeUseCases.insertAnime(anime)
        anime.mal_id?.let { animeUseCases.markAsFavAnime(mal_id = it, true) }
        sideEffect = UIComponent.Toast("Anime added to favourites !")
    }


}