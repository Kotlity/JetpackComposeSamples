package com.navigationrail

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.navigationrail.Dimensions.navigationRailContentPadding
import com.navigationrail.Dimensions.navigationRailFloatingActionButtonDefaultElevation
import com.navigationrail.Dimensions.navigationRailFloatingActionButtonPressedElevation
import com.navigationrail.Dimensions.navigationRailPaddingEnd

@Composable
fun CustomNavigationRail(
    items: List<NavigationRailItemHelper>,
    currentRoute: String,
    onItemClick: (String) -> Unit
) {

    val floatingActionButtonInteractionSource by remember {
        mutableStateOf(MutableInteractionSource())
    }

    val isFloatingActionButtonPressed by floatingActionButtonInteractionSource.collectIsPressedAsState()

    NavigationRail(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.onSecondary)
            .padding(navigationRailPaddingEnd),
        header = {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
            FloatingActionButton(
                onClick = {
                    onItemClick(ScreenRoutes.Email.route)
                },
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = navigationRailFloatingActionButtonDefaultElevation,
                    pressedElevation = navigationRailFloatingActionButtonPressedElevation
                ),
                interactionSource = floatingActionButtonInteractionSource
            ) {
                Icon(
                    imageVector = if (isFloatingActionButtonPressed) Icons.Default.Email else Icons.Outlined.Email,
                    contentDescription = null
                )
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(navigationRailContentPadding),
                verticalArrangement = Arrangement.spacedBy(navigationRailContentPadding, Alignment.Bottom)
            ) {
                items.forEach { navigationRailItemHelper ->
                    CustomNavigationRailItem(
                        navigationRailItemHelper = navigationRailItemHelper,
                        currentRoute = currentRoute,
                        onItemClick = onItemClick
                    )
                }
            }
        }
    )
}