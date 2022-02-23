package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavHostController
import com.example.todoapp.navigation.setupNavigation
import com.example.todoapp.ui.theme.ToDoAppTheme
import com.example.todoapp.ui.theme.viewModels.SharedViewModel
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalAnimationApi
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                navController = rememberAnimatedNavController()
                setupNavigation(
                    navController = navController,
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }
}

