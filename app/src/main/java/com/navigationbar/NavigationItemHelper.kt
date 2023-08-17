package com.navigationbar

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItemHelper(val selectedIcon: ImageVector, val unselectedIcon: ImageVector, val title: String, val badgeCount: Int? = null, val hasNews: Boolean = false)