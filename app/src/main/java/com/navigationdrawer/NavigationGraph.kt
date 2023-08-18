package com.navigationdrawer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    contentListViewModel: ContentListViewModel = viewModel()
) {

    val homeList = contentListViewModel.homeList.collectAsStateWithLifecycle().value
    val callList = contentListViewModel.callList.collectAsStateWithLifecycle().value
    val emailList = contentListViewModel.emailList.collectAsStateWithLifecycle().value
    val searchList = contentListViewModel.searchList.collectAsStateWithLifecycle().value

    if (homeList.isEmpty()) {
        contentListViewModel.updateHomeList()
    }
    if (callList.isEmpty()) {
        contentListViewModel.updateCallList()
    }
    if (emailList.isEmpty()) {
        contentListViewModel.updateEmailList()
    }
    if (searchList.isEmpty()) {
        contentListViewModel.updateSearchList()
    }

    NavHost(
        navController = navHostController,
        startDestination = ScreenRoutes.Home.route,
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        composable(ScreenRoutes.Home.route) {
            ContentList(items = homeList)
        }
        composable(ScreenRoutes.Call.route) {
            ContentList(items = callList)
        }
        composable(ScreenRoutes.Email.route) {
            ContentList(items = emailList)
        }
        composable(ScreenRoutes.Search.route) {
            ContentList(items = searchList)
        }
    }
}