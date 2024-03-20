package com.example.jumping_minds_assignment.domain.models

data class Pagination(
    val current_page: Int,
    val has_next_page: Boolean,
    val last_visible_page: Int
)