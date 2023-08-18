package com.navigationdrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.navigationdrawer.Dimensions.itemUXVerticalSpace

@Composable
fun ContentList(items: List<ItemForList>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(itemUXVerticalSpace, Alignment.CenterVertically)
    ) {
        items(items) { itemForList ->
            ItemUX(itemForList = itemForList)
        }
    }
}