package com.topappbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.topappbar.ui.theme.TopAppBarTheme

class MainActivity : ComponentActivity() {

    private val topAppBarStuffViewModel by viewModels<TopAppBarStuffViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val selectedIconIndex by topAppBarStuffViewModel.selectedIconIndex.collectAsStateWithLifecycle()
            val actionsItemList by topAppBarStuffViewModel.actionsItemList.collectAsStateWithLifecycle()
            val itemsFromList by topAppBarStuffViewModel.itemsFromList.collectAsStateWithLifecycle()

            val topAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
            val nestedScrollConnection = topAppBarScrollBehavior.nestedScrollConnection

            if (itemsFromList.isEmpty()) {
                repeat(100) { index ->
                    topAppBarStuffViewModel.addItemFromList(index)
                }
            }

            TopAppBarTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(nestedScrollConnection),
                    topBar = {
                        CustomTopAppBar(
                            title = stringResource(id = R.string.topAppBarTitle),
                            navigationIcon = Icons.Default.ArrowBack,
                            actions = actionsItemList,
                            selectedIconIndex = selectedIconIndex,
                            onIconClick = { indexClicked ->
                                topAppBarStuffViewModel.changeSelectedIconIndex(indexClicked)
                            },
                            scrollBehavior = topAppBarScrollBehavior
                        )
                    }
                ) { paddingValues ->
                    LazyColumnForTopAppBar(
                        paddingValues = paddingValues,
                        items = itemsFromList
                    )
                }
            }
        }
    }
}