package com.topappbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.topappbar.Dimensions.verticalSpace

@Composable
fun LazyColumnForTopAppBar(
    paddingValues: PaddingValues,
    items: List<ItemFromList>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(verticalSpace, Alignment.CenterVertically)
    ) {
        if (items.isNotEmpty()) {
            items(items) { itemFromList ->
                ItemUX(itemFromList = itemFromList)
            }
        }
    }
}