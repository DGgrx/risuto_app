package com.example.jumping_minds_assignment.ui.navgraph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object HomeScreen : Route(route = "homeScreen")
    object SearchScreen : Route(route = "searchScreen")
    object FavouritesScreen : Route(route = "favouritesScreen")
    object DetailsScreen : Route(route = "detailsScreen")
    object AppStartNavigation : Route(route = "appStartNavigation")
    object AnimeNavigation : Route(route = "animeNavigation")
    object AnimeNavigationScreen : Route(route = "animeNavigationScreen")
}