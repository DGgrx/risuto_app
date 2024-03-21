package com.example.jumping_minds_assignment.ui.favourites

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jumping_minds_assignment.domain.usecases.anime.AnimeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val animeUseCases: AnimeUseCases
): ViewModel(){

    private val _state = mutableStateOf(FavouritesState())
    val state : State<FavouritesState> = _state

    init{
        getFavArticles()
    }

    private fun getFavArticles(){
        animeUseCases.getFavouriteAnime().onEach{
            _state.value = _state.value.copy(favAnimes = it)
        }.launchIn(viewModelScope)
    }

}