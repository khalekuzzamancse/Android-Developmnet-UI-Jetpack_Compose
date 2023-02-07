package com.jetpack.compose.example.bottomnavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jetpack.compose.example.bottomnavigation.ui.theme.Teal200


@Composable
fun NavBarDemo2() {
    val list = listOf<NavbarItem>(
        NavbarItem("Home", Icons.Default.Home),
        NavbarItem("Setting", Icons.Default.Settings),
        NavbarItem("Search", Icons.Default.Search),
        NavbarItem("Call", Icons.Default.Call),
    )
    BottomNavbarV_2(itemList = list)
}

@Composable
fun BottomNavbarV_3(itemList: List<NavbarItem>) {
    var selectedItem by remember {
        mutableStateOf(0)
    }
    BottomAppBar(cutoutShape = RoundedCornerShape(50)) {
        itemList.forEachIndexed { index, item ->
            BottomNavigationItem(
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                label = { Text(text = item.name) },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = null)
                },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.White
            )


        }

    }
}

@Composable
fun BottomNavbarV_2(itemList: List<NavbarItem>) {

    BottomAppBar(cutoutShape = RoundedCornerShape(50)) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            itemList.forEachIndexed { index, item ->
                if (index == 0) {
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                        IconButton(onClick = { /* doSomething() */ }) {
                            //the first icon
                            Icon(item.icon, contentDescription = null)
                        }
                    }
                } else {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(item.icon, contentDescription = null)
                    }
                }


            }

        }


    }
}

@Composable
fun FABforBottomBar() {
    FloatingActionButton(
        onClick = {
        },
        shape = RoundedCornerShape(50),
        backgroundColor = Teal200
    ) {
        Icon(Icons.Filled.Add, tint = Color.White, contentDescription = "Add")
    }

}