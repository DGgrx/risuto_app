package com.example.jumping_minds_assignment.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.jumping_minds_assignment.presentation.onboarding.OnBoardingScreen
import com.example.jumping_minds_assignment.presentation.onboarding.OnBoardingViewModel

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
                Text(text = "AnimeNavigationScreen")
            }
        }

    }


}