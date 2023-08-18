package com.bottomappbar

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.bottomappbar.Dimensions.floatingActionButtonDefaultElevation
import com.bottomappbar.Dimensions.floatingActionButtonPressedElevation

@Composable
fun CustomBottomAppBar(
    icons: List<ImageVector>
) {

    val interactionSource by remember {
        mutableStateOf(MutableInteractionSource())
    }

    val isFloatingActionButtonPressed = interactionSource.collectIsPressedAsState().value

    BottomAppBar(
        actions = {
            icons.forEach { icon ->
                IconButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null
                    )
                }
            }
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { },
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(
                    defaultElevation = floatingActionButtonDefaultElevation,
                    pressedElevation = floatingActionButtonPressedElevation
                ),
                interactionSource = interactionSource,
                text = {
                    Text(
                        text = stringResource(id = R.string.floatingActionButtonTitle),
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = if (isFloatingActionButtonPressed) FontWeight.Bold else FontWeight.Medium)
                    )
                },
                icon = {
                    Icon(
                        imageVector = if (isFloatingActionButtonPressed) Icons.Default.Done else Icons.Outlined.Done,
                        contentDescription = null
                    )
                }
            )
        }
    )
}