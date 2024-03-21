package com.example.jumping_minds_assignment.ui.anime_navigator

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.jumping_minds_assignment.R
import com.example.jumping_minds_assignment.domain.models.Anime
import com.example.jumping_minds_assignment.ui.anime_navigator.components.AnimeBottomNavigation
import com.example.jumping_minds_assignment.ui.anime_navigator.components.BottomNavigationItem
import com.example.jumping_minds_assignment.ui.details.AnimeDetailsScreen
import com.example.jumping_minds_assignment.ui.favourites.FavouritesScreen
import com.example.jumping_minds_assignment.ui.favourites.FavouritesViewModel
import com.example.jumping_minds_assignment.ui.home.HomeScreen
import com.example.jumping_minds_assignment.ui.home.HomeViewModel
import com.example.jumping_minds_assignment.ui.navgraph.Route
import com.example.jumping_minds_assignment.ui.search.SearchScreen
import com.example.jumping_minds_assignment.ui.search.SearchViewModel

@Composable
fun AnimeNavigator() {

    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_popular, text = "Popular"),
            BottomNavigationItem(icon = R.drawable.ic_search, text = "Search"),
            BottomNavigationItem(icon = R.drawable.ic_favorite, text = "Favourites"),
        )
    }

    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableStateOf(1)
    }

    selectedItem = remember(key1 = backStackState){
        when (backStackState?.destination?.route) {
            Route.HomeScreen.route -> 0
            Route.SearchScreen.route -> 1
            Route.FavouritesScreen.route -> 2
            else -> 0
        }
    }

    //Hide the bottom navigation when the user is in the details screen
    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route == Route.HomeScreen.route ||
                backStackState?.destination?.route == Route.SearchScreen.route ||
                backStackState?.destination?.route == Route.FavouritesScreen.route
    }


    Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
        if (isBottomBarVisible) {
            AnimeBottomNavigation(
                items = bottomNavigationItems,
                selectedItem = selectedItem,
                onItemClick = { index ->
                    when (index) {
                        0 -> navigateToTab(
                            navController = navController,
                            route = Route.HomeScreen.route
                        )

                        1 -> navigateToTab(
                            navController = navController,
                            route = Route.SearchScreen.route
                        )

                        2 -> navigateToTab(
                            navController = navController,
                            route = Route.FavouritesScreen.route
                        )
                    }
                }
            )
        }
    }) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.HomeScreen.route) { backStackEntry ->
                val viewModel: HomeViewModel = hiltViewModel()
                val animes = viewModel.topAnimes.collectAsLazyPagingItems()
                HomeScreen(
                    animes = animes,
                    navigateToSearch = {
                        navigateToTab(
                            navController = navController,
                            route = Route.SearchScreen.route
                        )
                    },
                    navigateToDetails = { anime ->
                        navigateToDetails(
                            navController = navController,
                            anime = anime
                        )
                    },
                    event = viewModel::onEvent,
                    state = viewModel.state.value
                )
            }
            composable(route = Route.SearchScreen.route) {
                val viewModel: SearchViewModel = hiltViewModel()
                val state = viewModel.state.value
                OnBackClickStateSaver(navController = navController)
                SearchScreen(
                    searchState = state,
                    event = viewModel::onEvent,
                    navigateToDetails = { anime ->
                        navigateToDetails(
                            navController = navController,
                            anime = anime
                        )
                    }
                )
            }

            composable(route = Route.DetailsScreen.route) {
//                val viewModel: AnimeDetailsView = hiltViewModel()
                navController.previousBackStackEntry?.savedStateHandle?.get<Anime?>("anime")
                    ?.let { anime ->
                        AnimeDetailsScreen(
                            anime = anime,
//                            event = viewModel::onEvent,
                            navigateUp = { navController.navigateUp() },
//                            sideEffect = viewModel.sideEffect
                        )
                    }

            }

            composable(route = Route.FavouritesScreen.route) {
                val viewModel: FavouritesViewModel = hiltViewModel()
                val state = viewModel.state.value
                OnBackClickStateSaver(navController = navController)
                FavouritesScreen(
                    state = state,
                    navigateToDetails = { anime ->
                        navigateToDetails(
                            navController = navController,
                            anime = anime
                        )
                    }
                )
            }


        }
    }
}

@Composable
fun OnBackClickStateSaver(navController: NavController) {
    BackHandler(true) {
        navigateToTab(
            navController = navController,
            route = Route.HomeScreen.route
        )
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { screen_route ->
            popUpTo(screen_route) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }
}

private fun navigateToDetails(navController: NavController, anime: Anime) {
    navController.currentBackStackEntry?.savedStateHandle?.set("anime",anime)
    navController.navigate(
        route = Route.DetailsScreen.route
    )
}