package com.example.playlist_maker_android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.playlist_maker_android.ui.search.SearchViewModel

@Composable
fun PlaylistHost(
    startDestination: String = Screen.MAIN_MENU.route,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController, startDestination) {
        composable(route = Screen.MAIN_MENU.route) {
            MenuScreen(
                onSearchClick = { navController.navigate(Screen.SEARCH.route) },
                onSettingsClick = { navController.navigate(Screen.SETTINGS.route) }
            )
        }
        composable(route = Screen.SEARCH.route) {
            val searchViewModel: SearchViewModel = viewModel(
                factory = SearchViewModel.getViewModelFactory()
            )
            SearchScreen(
                modifier = Modifier.fillMaxSize(),
                viewModel = searchViewModel,
                onBackClick = { navController.popBackStack() }
            )
        }
        composable(route = Screen.SETTINGS.route) {
            SettingsScreen(onBackClick = { navController.popBackStack() })
        }
    }
}
