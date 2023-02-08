package com.jetpack.compose.example.bottomnavigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

data class NavbarItem(
    val name: String,
    val icon: ImageVector,
    //add more if you need
)



@Composable
private fun BottomNavbarV_1(itemList: List<NavbarItem>) {
    var selectedItem by remember {
        mutableStateOf(0)
    }
    BottomNavigation(elevation = 8.dp) {
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
