package com.example.jumping_minds_assignment.ui.onboarding

import androidx.annotation.DrawableRes
import com.example.jumping_minds_assignment.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "Explore Top Animes",
        description = "You can explore the top Animes that are popular right now and see all the details and where to watch your favourite shows.",
        image = R.drawable.onboarding_1
    ),
    Page(
        title = "Create your list of favourites",
        description = "Create a list of your favourite anime and keep track of what you're watching right now",
        image = R.drawable.onboarding_2
    ),
    Page(
        title = "Search globally",
        description = "Search for any animated series or movie from your favourite organisation or animation studio and add them to your MyAnimeList profile.",
        image = R.drawable.onboarding_3
    )
)