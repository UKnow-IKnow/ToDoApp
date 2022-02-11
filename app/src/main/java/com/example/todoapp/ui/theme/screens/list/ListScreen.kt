package com.example.todoapp.ui.theme.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.todoapp.R
import com.example.todoapp.ui.theme.fabButtonBackgroundColor
import com.example.todoapp.ui.theme.viewModels.SharedViewModel
import com.example.todoapp.util.SearchAppBarState

@ExperimentalMaterialApi
@Composable
fun listScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
){
    LaunchedEffect(key1 = true){
        sharedViewModel.getAllTasks()
    }

    val allTasks by sharedViewModel.allTask.collectAsState()

    val searchAppBarState: SearchAppBarState
        by sharedViewModel.searchAppBarState

    val searchTextState: String by sharedViewModel.searchTextState

    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {
            listContent(
                tasks = allTasks,
                navigateToTaskScreen = navigateToTaskScreen
            )
        },
        floatingActionButton = {
            listFab(onFabClick = navigateToTaskScreen)
        }
    )
}

@Composable
fun listFab(
    onFabClick: (taskId: Int) -> Unit
){
    FloatingActionButton(
        onClick = {
            onFabClick(-1)
        },
        backgroundColor = MaterialTheme.colors.fabButtonBackgroundColor
    ) {
        Icon(imageVector = Icons.Filled.Add,
            contentDescription = stringResource(
                id = R.string.add_Button
            ),
            tint = Color.White
        )
    }
}

