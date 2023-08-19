package com.navigationrail

sealed class ScreenRoutes(val route: String) {
    object Home: ScreenRoutes("Home")
    object Email: ScreenRoutes("Email")
    object Add: ScreenRoutes("Add")
    object Favorite: ScreenRoutes("Favorite")
}
