package com.bottomappbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class BottomAppBarIconsViewModel: ViewModel() {

    val bottomAppBarItems = MutableStateFlow(
        listOf(
            Icons.Default.Favorite,
            Icons.Default.Search,
            Icons.Default.Call
        )
    )
}