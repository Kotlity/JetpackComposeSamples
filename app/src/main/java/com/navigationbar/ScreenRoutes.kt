package com.navigationbar

sealed class ScreenRoutes(val route: String) {
    object HOME: ScreenRoutes("Home")
    object FAVORITE: ScreenRoutes("Favorite")
    object MENU: ScreenRoutes("Menu")
}
