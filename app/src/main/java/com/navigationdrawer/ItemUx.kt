package com.navigationdrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.navigationdrawer.Dimensions.itemUXHorizontalSpace

@Composable
fun ItemUX(itemForList: ItemForList) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(itemUXHorizontalSpace, Alignment.CenterHorizontally)
    ) {
        Icon(
            imageVector = itemForList.icon,
            contentDescription = null
        )
        Text(
            text = itemForList.title,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}