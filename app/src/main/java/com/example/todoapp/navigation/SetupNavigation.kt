package com.example.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.todoapp.navigation.destination.listComposable
import com.example.todoapp.util.Constants.LIST_SCREEN

@Composable
fun setupNavigation(
    navController: NavHostController
){
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ){
        listComposable(
            navigateToTaskScreen = screen.task
        )
    }
}