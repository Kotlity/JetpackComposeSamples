package com.navigationdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.navigationdrawer.ui.theme.NavigationDrawerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val navigationDrawerItemsViewModel by viewModels<NavigationDrawerItemsViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val coroutineScope = rememberCoroutineScope()
            val navigationDrawerItems = navigationDrawerItemsViewModel.navigationDrawerItems.collectAsStateWithLifecycle().value
            val navHostController = rememberNavController()
            val currentRoute = navHostController.currentBackStackEntryAsState().value?.destination?.route

            NavigationDrawerTheme {
                CustomNavigationDrawer(
                    drawerState = drawerState,
                    navigationDrawerItems = navigationDrawerItems,
                    currentRoute = currentRoute ?: ScreenRoutes.Home.route,
                    onItemClick = { route ->
                        navHostController.navigate(route) {
                            launchSingleTop = true
                        }
                        coroutineScope.launch {
                            drawerState.close()
                        }
                    }
                ) {
                    CustomTopAppBar(
                        onMenuIconClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        },
                        currentRoute = currentRoute
                    ) { paddingValues ->
                        NavigationGraph(
                            navHostController = navHostController,
                            paddingValues = paddingValues
                        )
                    }
                }
            }
        }
    }
}