package com.example.jumping_minds_assignment.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.jumping_minds_assignment.domain.usecases.anime.AnimeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val animeUseCases: AnimeUseCases
) : ViewModel() {

    val topAnimes = animeUseCases.getTopAnime().cachedIn(viewModelScope)


    private val _state = mutableStateOf(HomeState())
    val state : State<HomeState> = _state


    fun onEvent(event : HomeEvent){}
}