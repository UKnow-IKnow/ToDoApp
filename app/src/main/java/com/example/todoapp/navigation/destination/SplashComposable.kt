package com.example.todoapp.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import com.example.todoapp.ui.theme.screens.list.splash.SplashScreen
import com.example.todoapp.util.Constants.SPLASH
import com.google.accompanist.navigation.animation.composable


@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
){
    composable(
        route = SPLASH
    ){
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}