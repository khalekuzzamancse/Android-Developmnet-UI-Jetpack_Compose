package com.example.topnavigation

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TopAppbar01Demo() {
    Scaffold(topBar = { TopAppbar01() }) {

    }
}

@Composable
fun TopAppbar01() {
    TopAppBar(
        title = { Text(text = "My Appbar") },
        actions = {},
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Icon"
                    )
                }
            }
        },
    )
}

