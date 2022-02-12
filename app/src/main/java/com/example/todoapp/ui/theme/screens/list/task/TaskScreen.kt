package com.example.todoapp.ui.theme.screens.list.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.todoapp.util.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit
) {

    Scaffold(
        topBar = {
            TaskAppBar(navigateToListScreen = navigateToListScreen)
        },
        content = {}
    )

}