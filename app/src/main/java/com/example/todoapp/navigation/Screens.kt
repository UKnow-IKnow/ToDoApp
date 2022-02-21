package com.example.todoapp.navigation


import androidx.navigation.NavHostController
import com.example.todoapp.util.Action
import com.example.todoapp.util.Constants.LIST_SCREEN
import com.example.todoapp.util.Constants.SPLASH

class Screens(navController: NavHostController) {
    val splash: () -> Unit = {
        navController.navigate("list/${Action.NO_ACTION}"){
            popUpTo(SPLASH){
                inclusive = true
            }
        }
    }

    val list: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }

    val task: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

}