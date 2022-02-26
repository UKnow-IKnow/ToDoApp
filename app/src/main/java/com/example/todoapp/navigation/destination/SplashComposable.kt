package com.example.todoapp.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.todoapp.ui.theme.screens.list.splash.SplashScreen
import com.example.todoapp.util.Constants.SPLASH


fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
){
    composable(
        route = SPLASH
    ){
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}