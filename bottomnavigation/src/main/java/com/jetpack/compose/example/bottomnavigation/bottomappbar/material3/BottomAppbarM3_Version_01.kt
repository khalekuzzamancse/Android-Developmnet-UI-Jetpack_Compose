package com.jetpack.compose.example.bottomnavigation.bottomappbar.material3

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.jetpack.compose.example.bottomnavigation.NavbarItem
import com.jetpack.compose.example.bottomnavigation.ui.theme.Teal200

@Composable
fun BottomAppbarDemo() {
    val list = listOf<NavbarItem>(
        NavbarItem("Home", Icons.Default.Home),
        NavbarItem("Setting", Icons.Default.Settings),
        NavbarItem("Search", Icons.Default.Search),

        )
    BottomAppbarM3WithFAB(list)
}

@Composable
fun BottomAppbarM3WithFAB(list: List<NavbarItem>) {
    BottomAppBar(
        actions = {
                list.forEach { item ->
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(item.icon, contentDescription = item.name)
                    }
                }

        },
        containerColor = Color.Blue,
        floatingActionButton = { FAB() }
    )

}

@Composable
private fun FAB() {
    FloatingActionButton(
        onClick = {
        },
        shape = RoundedCornerShape(50),
        backgroundColor = Teal200
    ) {

        Icon(Icons.Filled.Add, tint = Color.White, contentDescription = "Add")
    }

}

@Composable
fun BottomAppbarM3NoFAB() {
    BottomAppBar() {

    }
}
