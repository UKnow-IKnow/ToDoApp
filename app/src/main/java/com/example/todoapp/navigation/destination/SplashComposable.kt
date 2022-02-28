package com.example.todoapp.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.example.todoapp.ui.theme.screens.list.splash.SplashScreen
import com.example.todoapp.util.Constants.SPLASH


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
){
    composable(
        route = SPLASH
    ){
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}