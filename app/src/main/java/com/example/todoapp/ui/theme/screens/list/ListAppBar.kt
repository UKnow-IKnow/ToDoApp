package com.example.todoapp.ui.theme.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapp.ui.theme.topAppBarBackgroundColor
import com.example.todoapp.ui.theme.topAppBarContentColor
import com.example.todoapp.R
import com.example.todoapp.data.models.Priority

@Composable
fun ListAppBar(){
    DefaultListAppBar(
        onSearchClicked = {}
    )
}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit
){
    TopAppBar(
        title = {
            Text(text = "Tasks",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions ={
            ListAppBarActions (onSearchClicked = onSearchClicked)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit
){
    SearchAction (onSearchClicked = onSearchClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
){
    IconButton(
        onClick = {onSearchClicked}
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_Action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit
){

}

@Composable
@Preview
private fun DefaultListAppbarPreview(){
    DefaultListAppBar(
        onSearchClicked = {}
    )
}