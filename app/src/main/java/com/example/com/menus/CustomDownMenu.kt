package com.example.com.menus

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.com.DomainItem
@Composable
fun DropDownOnlyTextDemo(){
    val list = listOf<String>("Login", "About Us", "Contact Us")
    DropDownOnlyText(list = list)
}
@Composable
fun DropDownWithIconDemo(){
    val list = listOf<DomainItem>(
        DomainItem("Email",Icons.Default.Email),
        DomainItem("Phone",Icons.Default.Phone),
        DomainItem("Love",Icons.Default.Favorite)
    )
    DropDownWithIcon(list = list)
}
@Composable
 fun DropDownWithIcon(list: List<DomainItem>) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopEnd)

    ) {
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Open Options"
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded != expanded
            },
            modifier = Modifier.wrapContentSize(),
        ) {
            list.forEachIndexed { index, value ->
                EachMenuItem(value = value)
            }
        }
    }


}
@Composable
private fun ColumnScope.EachMenuItem(value: DomainItem) {
    DropdownMenuItem(
        onClick = {
            Log.i("Clicked", value.itemName)
        },
    ) {
        Icon(
            imageVector = value.icon,
            contentDescription = null
        )
        Text(text = value.itemName)
    }
}
@Composable
fun DropDownOnlyText(list: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopEnd)

    ) {
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Open Options"
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded != expanded
            },
            modifier = Modifier.wrapContentSize(),
        ) {
            list.forEachIndexed { index, value ->
                DropdownMenuItem(
                    onClick = {
                        Log.i("Clicked", value)
                    },
                ) {
                    Text(text = value)
                }


            }
        }
    }


}
