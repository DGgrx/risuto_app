package com.example.jumping_minds_assignment.ui.home

data class HomeState(
    val animeTicker: String = "",
    val isLoading: Boolean = false,
    val scrollValue: Int = 0,
    val maxScrollingValue: Int = 0
)