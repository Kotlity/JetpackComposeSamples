package com.snackbar

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals

class CustomSnackbarVisual(private val action: String, private val snackbarDuration: SnackbarDuration, private val snackbarMessage: String):
    SnackbarVisuals {

    override val actionLabel: String
        get() = action
    override val duration: SnackbarDuration
        get() = snackbarDuration
    override val message: String
        get() = snackbarMessage
    override val withDismissAction: Boolean
        get() = false
}