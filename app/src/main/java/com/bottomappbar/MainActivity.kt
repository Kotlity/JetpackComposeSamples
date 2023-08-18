package com.bottomappbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bottomappbar.ui.theme.BottomAppBarTheme

class MainActivity : ComponentActivity() {

    private val bottomAppBarIconsViewModel by viewModels<BottomAppBarIconsViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val bottomAppBarItems = bottomAppBarIconsViewModel.bottomAppBarItems.collectAsStateWithLifecycle().value

            BottomAppBarTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        CustomBottomAppBar(icons = bottomAppBarItems)
                    }
                ) { paddingValues ->

                }
            }
        }
    }
}