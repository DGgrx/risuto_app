package com.example.jumping_minds_assignment.ui.details

import androidx.lifecycle.ViewModel
import com.example.jumping_minds_assignment.domain.usecases.anime.AnimeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(
    private val animeUseCases: AnimeUseCases
): ViewModel(){

//    private val _state = mutableStateOf(AnimeDetailsEvent())
//    val state : State<AnimeDetailsEvent> = _state



}