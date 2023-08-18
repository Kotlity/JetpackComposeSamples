package com.navigationdrawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ContentListViewModel: ViewModel() {

    var homeList = MutableStateFlow(mutableListOf<ItemForList>())
        private set

    var callList = MutableStateFlow(mutableListOf<ItemForList>())
        private set

    var emailList = MutableStateFlow(mutableListOf<ItemForList>())
        private set

    var searchList = MutableStateFlow(mutableListOf<ItemForList>())
        private set


    fun updateHomeList() {
        repeat(100) { index ->
            homeList.value.add(ItemForList(Icons.Default.Home, "${index.plus(1)}.Home"))
        }
    }

    fun updateCallList() {
        repeat(100) { index ->
            callList.value.add(ItemForList(Icons.Default.Call, "${index.plus(1)}.Call"))
        }
    }

    fun updateEmailList() {
        repeat(100) { index ->
            emailList.value.add(ItemForList(Icons.Default.Email, "${index.plus(1)}.Email"))
        }
    }

    fun updateSearchList() {
        repeat(100) { index ->
            searchList.value.add(ItemForList(Icons.Default.Search, "${index.plus(1)}.Search"))
        }
    }
}