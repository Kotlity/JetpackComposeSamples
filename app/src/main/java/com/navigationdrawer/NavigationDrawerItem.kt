package com.navigationdrawer

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationDrawerItem(val selectedIcon: ImageVector, val unSelectedIcon: ImageVector, val title: String, val badgeCount: Int? = null)
