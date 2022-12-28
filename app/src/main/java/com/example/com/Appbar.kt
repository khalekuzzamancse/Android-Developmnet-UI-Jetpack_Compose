package com.example.com

import android.util.Log
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun Appbar(title: String, onNavigationItemClick: () -> Unit) {

    TopAppBar(title = { Text(text = title) },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            IconButton(onClick = {
                Log.i("!!!!!!", "okay-2")
                onNavigationItemClick()
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }
        }
    )
}
