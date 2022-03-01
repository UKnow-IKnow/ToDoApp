package com.example.todoapp.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.example.todoapp.ui.theme.screens.list.splash.SplashScreen
import com.example.todoapp.util.Constants.SPLASH



@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit
){
    composable(
        route = SPLASH,
        exitTransition = {
            slideOutVertically(
                animationSpec = tween(800)
            )
        }
    ){
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}