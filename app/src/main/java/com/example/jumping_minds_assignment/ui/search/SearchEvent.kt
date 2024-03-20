package com.example.jumping_minds_assignment.ui.search

sealed class SearchEvent {
    data class UpdateSearchQuery(val searchQuery: String): SearchEvent()

    object SearchAnime : SearchEvent()
}