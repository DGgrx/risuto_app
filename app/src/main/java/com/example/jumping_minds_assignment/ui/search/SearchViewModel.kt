package com.example.jumping_minds_assignment.ui.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.jumping_minds_assignment.domain.usecases.anime.AnimeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val animeUseCases: AnimeUseCases
) : ViewModel(){

    private val _state =  mutableStateOf(SearchState())
    var state : State<SearchState> = _state

    fun onEvent(event: SearchEvent){
        when(event){
            is SearchEvent.UpdateSearchQuery ->{
                _state.value = state.value.copy(searchQuery = event.searchQuery)
            }
            is SearchEvent.SearchAnime ->{
                searchAnime()
            }
        }
    }

    private fun searchAnime() {
        val animeData = animeUseCases.searchAnime(
            searchQuery = state.value.searchQuery
        ).cachedIn(viewModelScope)

        _state.value = state.value.copy(animes = animeData)
    }


}