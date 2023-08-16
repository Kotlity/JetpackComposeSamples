package com.topappbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Favorite
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class TopAppBarStuffViewModel: ViewModel() {

    var selectedIconIndex = MutableStateFlow(-1)
        private set

    var actionsItemList = MutableStateFlow(
        listOf(
        TopAppBarAction(Icons.Default.Add, Icons.Outlined.Add, hasNews = true),
        TopAppBarAction(Icons.Default.Call, Icons.Outlined.Call, badgeCount = 15),
        TopAppBarAction(Icons.Default.Favorite, Icons.Outlined.Favorite, badgeCount = 8)
    ))

    var itemsFromList = MutableStateFlow<MutableList<ItemFromList>>(mutableListOf())
        private set


    fun changeSelectedIconIndex(index: Int) {
        selectedIconIndex.value = index
    }

    fun addItemFromList(index: Int) {
        itemsFromList.value.add(ItemFromList(if (index % 2 == 0) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown, "$index.Some content"))
    }
}