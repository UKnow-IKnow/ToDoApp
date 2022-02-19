package com.example.todoapp.ui.theme.screens.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.R
import com.example.todoapp.data.models.Priority
import com.example.todoapp.data.models.ToDoTask
import com.example.todoapp.ui.theme.taskItemBackgroundColor
import com.example.todoapp.ui.theme.taskItemTextColor
import com.example.todoapp.util.RequestState
import com.example.todoapp.util.SearchAppBarState

@ExperimentalMaterialApi
@Composable
fun listContent(
    allTasks: RequestState<List<ToDoTask>>,
    searchTask: RequestState<List<ToDoTask>>,
    searchAppBarState: SearchAppBarState,
    lowPriorityTask: List<ToDoTask>,
    highPriorityTask: List<ToDoTask>,
    sortState: RequestState<Priority>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    if (sortState is RequestState.Success) {
        when {
            searchAppBarState == SearchAppBarState.TRIGGERED -> {
                if (searchTask is RequestState.Success) {
                    HandleListContent(
                        tasks = searchTask.data,
                        navigateToTaskScreen = navigateToTaskScreen
                    )
                }
            }
            sortState.data == Priority.NONE -> {
                if (allTasks is RequestState.Success) {
                    HandleListContent(
                        tasks = allTasks.data,
                        navigateToTaskScreen = navigateToTaskScreen
                    )
                }
            }
            sortState.data == Priority.LOW -> {
                HandleListContent(
                    tasks = lowPriorityTask,
                    navigateToTaskScreen = navigateToTaskScreen
                )
            }
            sortState.data == Priority.HIGH -> {
                HandleListContent(
                    tasks = highPriorityTask,
                    navigateToTaskScreen = navigateToTaskScreen
                )
            }
        }

    }

}

@ExperimentalMaterialApi
@Composable
fun HandleListContent(
    tasks: List<ToDoTask>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    if (tasks.isEmpty()) {
        EmptyContent()
    } else {
        DisplayTasks(
            tasks = tasks,
            navigateToTaskScreen = navigateToTaskScreen
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun DisplayTasks(
    tasks: List<ToDoTask>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    LazyColumn {
        items(
            items = tasks,
            key = { task ->
                task.id
            }
        ) { task ->
            TaskItem(
                toDoTask = task,
                navigateToTaskScreen = navigateToTaskScreen
            )
        }
    }
}

@Composable
fun RedBackground(degree: Float){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)
        .padding(horizontal = 24.dp),
        contentAlignment = Alignment.CenterEnd
    ){
        Icon(
            modifier = Modifier.rotate(degrees = degree),
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(id = R.string.delete_Icon),
            tint = Color.White
        )
    }
}


@ExperimentalMaterialApi
@Composable
fun TaskItem(
    toDoTask: ToDoTask,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.taskItemBackgroundColor,
        shape = RectangleShape,
        elevation = 2.dp,
        onClick = {
            navigateToTaskScreen(toDoTask.id)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    text = toDoTask.title,
                    color = MaterialTheme.colors.taskItemTextColor,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Canvas(
                        modifier = Modifier
                            .width(16.dp)
                            .height(16.dp)
                    ) {
                        drawCircle(
                            color = toDoTask.priority.color
                        )
                    }
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = toDoTask.description,
                color = MaterialTheme.colors.taskItemTextColor,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
private fun TaskItemPreview() {
    TaskItem(
        toDoTask = ToDoTask(
            id = 0,
            title = "Title",
            description = "welcome to hell",
            priority = Priority.HIGH
        )
    ) {}
}