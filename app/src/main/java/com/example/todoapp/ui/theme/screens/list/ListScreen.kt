package com.example.todoapp.ui.theme.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.todoapp.R
import com.example.todoapp.ui.theme.fabButtonBackgroundColor
import com.example.todoapp.ui.theme.viewModels.SharedViewModel
import com.example.todoapp.util.Action
import com.example.todoapp.util.SearchAppBarState
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun listScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(key1 = true) {
        sharedViewModel.getAllTasks()
    }

    val action by sharedViewModel.action

    val allTasks by sharedViewModel.allTask.collectAsState()

    val searchTask by sharedViewModel.searchTask.collectAsState()

    val searchAppBarState: SearchAppBarState
            by sharedViewModel.searchAppBarState

    val searchTextState: String by sharedViewModel.searchTextState

    val scaffoldState = rememberScaffoldState()


    DisplaySnackBar(
        scaffoldState = scaffoldState,
        handleDatabaseAction = { sharedViewModel.handleDatabaseActions(action = action) },
        undoClicked = {
            sharedViewModel.action.value = it
        },
        taskTitle = sharedViewModel.title.value,
        action = action
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {
            listContent(
                allTasks = allTasks,
                searchTask = searchTask,
                searchAppBarState = searchAppBarState,
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
) {
    FloatingActionButton(
        onClick = {
            onFabClick(-1)
        },
        backgroundColor = MaterialTheme.colors.fabButtonBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(
                id = R.string.add_Button
            ),
            tint = Color.White
        )
    }
}


@Composable
fun DisplaySnackBar(
    scaffoldState: ScaffoldState,
    handleDatabaseAction: () -> Unit,
    undoClicked: (Action) -> Unit,
    taskTitle: String,
    action: Action
) {
    handleDatabaseAction()

    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = action) {
        if (action != Action.NO_ACTION) {
            scope.launch {
                val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                    message = "${action.name}: $taskTitle",
                    actionLabel = setActionLabel(action = action)
                )
                undoDeletedTask(
                    action = action,
                    snackBarResult = snackBarResult,
                    undoClicked = undoClicked
                )
            }
        }
    }
}

private fun setActionLabel(action: Action): String {
    return if (action.name == "DELETE") {
        "UNDO"
    } else {
        "OK"
    }
}

private fun undoDeletedTask(
    action: Action,
    snackBarResult: SnackbarResult,
    undoClicked: (Action) -> Unit
) {
    if (snackBarResult == SnackbarResult.ActionPerformed && action == Action.DELETE) {
        undoClicked(Action.UNDO)
    }
}
