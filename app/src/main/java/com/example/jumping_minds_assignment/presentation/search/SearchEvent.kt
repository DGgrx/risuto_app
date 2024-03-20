package com.example.jumping_minds_assignment.presentation.search

sealed class SearchEvent {
    data class UpdateSearchQuery(val searchQuery: String): SearchEvent()

    object SearchAnime : SearchEvent()
}