package com.example.todoapp.ui.theme.screens.list.task

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.example.todoapp.ui.theme.topAppBarBackgroundColor
import com.example.todoapp.ui.theme.topAppBarContentColor

@Composable
fun TaskAppBar(){
    
}

@Composable
fun NewTaskAppBar(){
    TopAppBar(
        navigationIcon = {

        },
        title = {
            Text(
                text = "Add Task",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {

        }
    )
}

