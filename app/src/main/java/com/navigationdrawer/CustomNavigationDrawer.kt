package com.navigationdrawer

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.navigationdrawer.Dimensions.navigationDrawerItemVerticalSpace

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomNavigationDrawer(
    drawerState: DrawerState,
    navigationDrawerItems: List<NavigationDrawerItem>,
    currentRoute: String,
    onItemClick: (String) -> Unit,
    content: @Composable () -> Unit
) {
    
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                navigationDrawerItems.forEach { navigationDrawerItem ->
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = navigationDrawerItem.title,
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = if (currentRoute == navigationDrawerItem.title) FontWeight.Bold else FontWeight.Medium)
                            )
                        },
                        selected = currentRoute == navigationDrawerItem.title,
                        onClick = {
                            onItemClick(navigationDrawerItem.title)
                        },
                        icon = {
                            Icon(
                                imageVector = if (currentRoute == navigationDrawerItem.title) navigationDrawerItem.selectedIcon else navigationDrawerItem.unSelectedIcon,
                                contentDescription = null
                            )
                        },
                        badge = {
                            navigationDrawerItem.badgeCount?.let { badgeCount ->
                                Badge {
                                    Text(text = badgeCount.toString())
                                }
                            }
                        },
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding)
                            .padding(vertical = navigationDrawerItemVerticalSpace)
                    )
                }
            }
        },
        drawerState = drawerState
    ) {
        content()
    }
}