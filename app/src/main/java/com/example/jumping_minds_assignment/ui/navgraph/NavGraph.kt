package com.example.jumping_minds_assignment.ui.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.jumping_minds_assignment.ui.onboarding.OnBoardingScreen
import com.example.jumping_minds_assignment.ui.onboarding.OnBoardingViewModel
import com.example.jumping_minds_assignment.ui.search.SearchScreen
import com.example.jumping_minds_assignment.ui.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent)
            }
        }


        navigation(
            route = Route.AnimeNavigation.route,
            startDestination = Route.AnimeNavigationScreen.route
        ) {
            composable(route = Route.AnimeNavigationScreen.route) {
//                val viewModel : HomeViewModel = hiltViewModel()
//                val animes = viewModel.topAnimes.collectAsLazyPagingItems()
//                HomeScreen(
//                    animes = animes,
////                    state = ,
////                    event = ,
//                    navigateToSearch = { },
//                    navigateToDetails = {}
//                )

                val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen(searchState = viewModel.state.value, event = viewModel::onEvent)

            }
        }

    }


}