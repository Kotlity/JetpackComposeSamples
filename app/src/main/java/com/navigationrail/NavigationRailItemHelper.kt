package com.navigationrail

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationRailItemHelper(val selectedIcon: ImageVector, val unselectedIcon: ImageVector, val title: String, val badgeCount: Int? = null, val hasNews: Boolean = false)
