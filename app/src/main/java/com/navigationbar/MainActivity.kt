package com.navigationbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.navigationbar.ui.theme.NavigationBarTheme

class MainActivity : ComponentActivity() {

    private val navigationBarStuffViewModel by viewModels<NavigationBarStuffViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navHostController = rememberNavController()
            val currentRoute = navHostController.currentBackStackEntryAsState().value?.destination?.route
            val navigationItems by navigationBarStuffViewModel.navigationItems.collectAsStateWithLifecycle()

            NavigationBarTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        CustomNavigationBar(
                            navigationItems = navigationItems,
                            currentRoute = currentRoute ?: ScreenRoutes.HOME.route,
                            onIconClick = { route ->
                                navHostController.navigate(route) {
                                    popUpTo(navHostController.graph.findStartDestination().id) {
                                        saveState = true
                                    }

                                    // avoid creating multiple copies for the same destination when reselecting the same item
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                ) { paddingValues ->
                    NavHost(
                        navController = navHostController,
                        ScreenRoutes.HOME.route,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        composable(ScreenRoutes.HOME.route) {
                            SimpleScreen(route = ScreenRoutes.HOME.route)
                        }
                        composable(ScreenRoutes.FAVORITE.route) {
                            SimpleScreen(route = ScreenRoutes.FAVORITE.route)
                        }
                        composable(ScreenRoutes.MENU.route) {
                            SimpleScreen(route = ScreenRoutes.MENU.route)
                        }
                    }
                }
            }
        }
    }
}