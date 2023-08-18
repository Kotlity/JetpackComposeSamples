package com.navigationdrawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Search
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationDrawerItemsViewModel: ViewModel() {

    val navigationDrawerItems = MutableStateFlow(
        listOf(
            NavigationDrawerItem(Icons.Default.Call, Icons.Outlined.Call, ScreenRoutes.Call.route, 8),
            NavigationDrawerItem(Icons.Default.Email, Icons.Outlined.Email, ScreenRoutes.Email.route, 35),
            NavigationDrawerItem(Icons.Default.Search, Icons.Outlined.Search, ScreenRoutes.Search.route)
        )
    )
}