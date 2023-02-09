package com.jetpack.compose.example.bottomnavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jetpack.compose.example.bottomnavigation.ui.theme.Teal200


@Composable
fun NavBarDemo2() {
    val list = listOf<NavbarItem>(
        NavbarItem("Home", Icons.Default.Home),
        NavbarItem("Setting", Icons.Default.Settings),
        NavbarItem("Call", Icons.Default.Call),
       NavbarItem("Call", Icons.Default.Call),
    )
   // BottomAppbarCoveringKeyboard(itemList = list)


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
fun BottomAppbarCoveringKeyboard(itemList: List<NavbarItem>) {

    BottomAppBar(cutoutShape = RoundedCornerShape(50)) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            itemList.forEachIndexed { index, item ->
                if (index == 0) {
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                        IconButton(onClick = {}) {
                            //the first icon
                            Icon(item.icon, contentDescription = null)
                        }
                    }
                }
                else {
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