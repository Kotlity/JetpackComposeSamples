package com.topappbar

import androidx.compose.ui.graphics.vector.ImageVector

data class TopAppBarAction(val selectedIcon: ImageVector, val unselectedIcon: ImageVector, val badgeCount: Int? = null, val hasNews: Boolean = false)
