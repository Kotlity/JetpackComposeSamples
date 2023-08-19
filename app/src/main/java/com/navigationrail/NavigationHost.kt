package com.navigationrail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationHost(
    navHostController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        navController = navHostController,
        startDestination = ScreenRoutes.Home.route
    ) {
        composable(ScreenRoutes.Home.route) {
            SimpleScreenContent(ScreenRoutes.Home.route)
        }
        composable(ScreenRoutes.Email.route) {
            SimpleScreenContent(ScreenRoutes.Email.route)
        }
        composable(ScreenRoutes.Add.route) {
            SimpleScreenContent(ScreenRoutes.Add.route)
        }
        composable(ScreenRoutes.Favorite.route) {
            SimpleScreenContent(ScreenRoutes.Favorite.route)
        }
    }
}