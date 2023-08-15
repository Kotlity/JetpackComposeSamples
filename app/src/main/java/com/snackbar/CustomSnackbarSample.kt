package com.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSnackbarSample() {

    val snackbarState = remember {
        SnackbarHostState()
    }

    val coroutineScope = rememberCoroutineScope()

    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackbarState) { snackbarData ->
                CustomSnackbar(snackbarData = snackbarData)
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(colorResource(id = R.color.boxBackgroundColor)),
            contentAlignment = Alignment.Center
        ) {
            ShowSnackbarButton(
                onButtonClick = {
                    coroutineScope.launch {
                        snackbarState.showSnackbar(
                            CustomSnackbarVisual(
                                action = context.getString(R.string.snackbarActionLabel),
                                snackbarDuration = SnackbarDuration.Short,
                                snackbarMessage = context.getString(R.string.snackbarMessage)
                            )
                        )
                    }
                }
            )
        }
    }
}