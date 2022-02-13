package com.example.todoapp.ui.theme.screens.list.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.todoapp.data.models.ToDoTask
import com.example.todoapp.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask=selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        },
        content = {}
    )

}