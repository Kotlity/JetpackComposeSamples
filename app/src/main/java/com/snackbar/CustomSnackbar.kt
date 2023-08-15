package com.snackbar

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.snackbar.Dimensions.snackbarShape

@Composable
fun CustomSnackbar(
    snackbarData: SnackbarData
) {
    val customSnackbarVisuals = snackbarData.visuals as CustomSnackbarVisual
    val snackbarActionLabel = customSnackbarVisuals.actionLabel
    val snackbarMessage = customSnackbarVisuals.message

    Snackbar(
        modifier = Modifier
            .padding(Dimensions.snackbarPadding)
            .border(
                width = Dimensions.snackbarBorderWidth,
                color = colorResource(id = R.color.snackbarBorderColor),
                shape = RoundedCornerShape(snackbarShape)
            ),
        shape = RoundedCornerShape(snackbarShape),
        action = {
            TextButton(
                modifier = Modifier.padding(5.dp),
                onClick = { snackbarData.dismiss() },
                colors = ButtonDefaults.textButtonColors(containerColor = colorResource(id = R.color.snackbarActionLabelColor))
            ) {
                Text(text = snackbarActionLabel,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                )
            }
        },
        containerColor = colorResource(id = R.color.snackbarContainerColor)
    ) {
        Text(
            text = snackbarMessage,
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
        )
    }
}