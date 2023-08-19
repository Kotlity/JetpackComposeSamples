package com.navigationrail

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationRailItemsViewModel: ViewModel() {

    val navigationRailItems = MutableStateFlow(
        listOf(
            NavigationRailItemHelper(Icons.Default.Home, Icons.Outlined.Home, "Home", 12),
            NavigationRailItemHelper(Icons.Default.Add, Icons.Outlined.Add, "Add", hasNews = true),
            NavigationRailItemHelper(Icons.Default.Favorite, Icons.Outlined.Favorite, "Favorite")
        )
    )
}