package com.navigationdrawer

sealed class ScreenRoutes(val route: String) {
    object Home: ScreenRoutes("Home")
    object Call: ScreenRoutes("Call")
    object Email: ScreenRoutes("Email")
    object Search: ScreenRoutes("Search")
}
