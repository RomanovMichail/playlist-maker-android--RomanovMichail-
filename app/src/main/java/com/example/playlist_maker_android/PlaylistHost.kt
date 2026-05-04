package com.example.playlist_maker_android

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun PlaylistHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MAIN.name
    ) {
        composable(Screen.MAIN.name) {
            MainScreen(
                onSearchClick = {
                    navController.navigate(Screen.SEARCH.name)
                },
                onSettingsClick = {
                    navController.navigate(Screen.SETTINGS.name)
                }
            )
        }

        composable(Screen.SEARCH.name) {
            SearchScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.SETTINGS.name) {
            SettingsScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
