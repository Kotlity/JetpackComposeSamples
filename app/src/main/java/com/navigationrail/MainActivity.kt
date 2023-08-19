package com.navigationrail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.navigationrail.Dimensions.scaffoldPaddingStart
import com.navigationrail.ui.theme.NavigationRailTheme

class MainActivity : ComponentActivity() {

    private val navigationRailItemsViewModel by viewModels<NavigationRailItemsViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navigationRailItems by navigationRailItemsViewModel.navigationRailItems.collectAsStateWithLifecycle()
            val navHostController = rememberNavController()
            val currentRoute = navHostController.currentBackStackEntryAsState().value?.destination?.route

            NavigationRailTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = scaffoldPaddingStart)
                    ,
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = currentRoute ?: ScreenRoutes.Home.route)
                            }
                        )
                    }
                ) { paddingValues ->
                    NavigationHost(
                        navHostController = navHostController,
                        paddingValues = paddingValues
                    )
                }

                CustomNavigationRail(
                    items = navigationRailItems,
                    currentRoute = currentRoute ?: ScreenRoutes.Home.route,
                    onItemClick = { route ->
                        navHostController.navigate(route) {
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}