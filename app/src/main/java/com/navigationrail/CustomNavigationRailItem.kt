package com.navigationrail

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomNavigationRailItem(
    navigationRailItemHelper: NavigationRailItemHelper,
    currentRoute: String,
    onItemClick: (String) -> Unit
) {
    NavigationRailItem(
        selected = currentRoute == navigationRailItemHelper.title,
        onClick = {
            onItemClick(navigationRailItemHelper.title)
        },
        icon = {
            BadgedBox(
                badge =  {
                    if (navigationRailItemHelper.badgeCount != null) Badge {
                        Text(text = navigationRailItemHelper.badgeCount.toString())
                    } else if (navigationRailItemHelper.hasNews) Badge()
                }
            ) {
                Icon(
                    imageVector = if (currentRoute == navigationRailItemHelper.title) navigationRailItemHelper.selectedIcon else navigationRailItemHelper.unselectedIcon,
                    contentDescription = null
                )
            }
        },
        label = {
            Text(
                text = navigationRailItemHelper.title,
                style = if (currentRoute == navigationRailItemHelper.title) MaterialTheme.typography.titleMedium else MaterialTheme.typography.titleSmall
            )
        }
    )
}