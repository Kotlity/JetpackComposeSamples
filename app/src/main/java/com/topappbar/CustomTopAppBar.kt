package com.topappbar

import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import com.topappbar.Dimensions.xOffset
import com.topappbar.Dimensions.yOffset

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    title: String,
    navigationIcon: ImageVector,
    actions: List<TopAppBarAction>,
    selectedIconIndex: Int,
    onIconClick: (Int) -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
) {
    TopAppBar (
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = null
                )
            }
        },
        actions = {
            actions.forEachIndexed { index, topAppBarAction ->
                BadgedBox(
                    badge = {
                        if (topAppBarAction.badgeCount != null) Badge(modifier = Modifier.offset(x = xOffset, y = yOffset)) {
                            Text(text = topAppBarAction.badgeCount.toString())
                        } else if (topAppBarAction.hasNews) Badge(modifier = Modifier.offset(x = xOffset, y = yOffset))
                    },
                ) {
                    IconButton(onClick = {
                        onIconClick(index)
                    }) {
                        Icon(
                            imageVector = if (selectedIconIndex == index) topAppBarAction.selectedIcon else topAppBarAction.unselectedIcon,
                            contentDescription = null
                        )
                    }
                }
            }
        },
        scrollBehavior = scrollBehavior
    )
}