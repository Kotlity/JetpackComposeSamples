package com.navigationbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.lifecycle.ViewModel
import com.navigationbar.Dimensions.badgeCount
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationBarStuffViewModel: ViewModel() {

    val navigationItems = MutableStateFlow(
        listOf(
            NavigationItemHelper(Icons.Default.Home, Icons.Outlined.Home, ScreenRoutes.HOME.route),
            NavigationItemHelper(Icons.Default.Favorite, Icons.Outlined.Favorite, ScreenRoutes.FAVORITE.route, badgeCount = badgeCount),
            NavigationItemHelper(Icons.Default.Menu, Icons.Outlined.Menu, ScreenRoutes.MENU.route, hasNews = true),
        )
    )
}