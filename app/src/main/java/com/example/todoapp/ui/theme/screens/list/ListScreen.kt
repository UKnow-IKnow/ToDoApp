package com.example.todoapp.ui.theme.screens.list

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapp.R

@Composable
fun listScreen(
    navigateToTaskScreen: (Int) -> Unit
){
    Scaffold(
        content = {},
        floatingActionButton = {
            listFab(onFabClick = navigateToTaskScreen)
        }
    )
}

@Composable
fun listFab(
    onFabClick: (Int) -> Unit
){
    FloatingActionButton(
        onClick = {
            onFabClick(-1)
        }
    ) {
        Icon(imageVector = Icons.Filled.Add,
            contentDescription = stringResource(
                id = R.string.add_Button
            ),
            tint = Color.White
        )
    }
}

@Composable
@Preview
private fun listscreenPreview(){
    listScreen(navigateToTaskScreen = {})
}