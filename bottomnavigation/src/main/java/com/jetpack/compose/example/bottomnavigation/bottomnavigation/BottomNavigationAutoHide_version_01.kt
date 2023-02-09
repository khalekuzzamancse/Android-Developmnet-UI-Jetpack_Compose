package com.jetpack.compose.example.bottomnavigation.bottomnavigation

import android.annotation.SuppressLint
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationAutoHideItemVersion01(
    val itemName: String,
    val icon: ImageVector,
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigationAutoHide_ver01Demo() {
    val list = listOf<BottomNavigationAutoHideItemVersion01>(
        BottomNavigationAutoHideItemVersion01("Home", Icons.Default.Home),
        BottomNavigationAutoHideItemVersion01("Search", Icons.Default.Search),
        BottomNavigationAutoHideItemVersion01("Cart", Icons.Default.ShoppingCart),
        BottomNavigationAutoHideItemVersion01("Profile", Icons.Default.Person)
    )
    //this variable will be used for show/hide the bottom bar
    var shouldHide by remember { mutableStateOf(false) }
    Scaffold(
        bottomBar = {
            //if shouldHide==false then empty bottom bar will be showed
            if (!shouldHide)
                BottomNavigationAutoHide_ver01(list)
        },
    ) {

        Button(onClick = { shouldHide = !shouldHide }) {
            androidx.compose.material.Text(text = "Hide Nav")
        }

    }

}


@Composable
fun BottomNavigationAutoHide_ver01(list: List<BottomNavigationAutoHideItemVersion01>) {
    var selectedItem by remember { mutableStateOf(0) }
    NavigationBar() {
        list.forEachIndexed() { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                label = {
                    Text(text = item.itemName)
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = null)
                }
            )
        }
    }
}