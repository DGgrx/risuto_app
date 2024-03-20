package com.example.jumping_minds_assignment.presentation.home

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

}