package com.navigationbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.navigationbar.Dimensions.titleSize

@Composable
fun SimpleScreen(route: String) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = route,
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = titleSize,
                fontWeight = FontWeight.Bold
            )
        )
    }
}