package com.navigationbar

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomNavigationBar(
    navigationItems: List<NavigationItemHelper>,
    currentRoute: String,
    onIconClick: (String) -> Unit
) {

    NavigationBar {
        navigationItems.forEach { navigationItemHelper ->
            NavigationBarItem(
                selected = currentRoute == navigationItemHelper.title,
                onClick = {
                    onIconClick(navigationItemHelper.title)
                },
                icon = {
                    BadgedBox(badge = {
                        if (navigationItemHelper.hasNews) Badge()
                        else if (navigationItemHelper.badgeCount != null) Badge {
                            Text(text = navigationItemHelper.badgeCount.toString())
                        }
                    }) {
                        Icon(imageVector = if (currentRoute == navigationItemHelper.title) navigationItemHelper.selectedIcon else navigationItemHelper.unselectedIcon,
                            contentDescription = null
                        )
                    }
                },
                label = {
                    Text(text = navigationItemHelper.title)
                }
            )
        }
    }
}