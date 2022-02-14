package com.example.todoapp.ui.theme.screens.list.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.todoapp.data.models.Priority
import com.example.todoapp.data.models.ToDoTask
import com.example.todoapp.ui.theme.viewModels.SharedViewModel
import com.example.todoapp.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {

    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(
                selectedTask = selectedTask,
                navigateToListScreen = { action ->

                }
            )
        },
        content = {
            TaskContent(
                title = title,
                onTitleChange = {
                    sharedViewModel.updateTitle(it)
                },
                description = description,
                onDescriptionChange = {
                    sharedViewModel.description.value = it
                },
                priority = priority,
                onPrioritySelected = {
                    sharedViewModel.priority.value = it
                }
            )
        }
    )

}