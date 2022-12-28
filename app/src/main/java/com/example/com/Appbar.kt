package com.example.com

import android.graphics.BitmapFactory.Options
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp


@Composable
fun Appbar(title: String, onNavigationItemClickListener: () -> Unit) {
    TopAppBar(title = { AppbarTitle(title = title) },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            DrawerIcon {
                onNavigationItemClickListener()
            }
        }, actions = {
            MoreActionIcon()

        }
    )
}


@Composable
fun DrawerIcon(onNavigationItemClickListener: () -> Unit) {
    IconButton(onClick = {
        onNavigationItemClickListener()
    }) {
        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
    }
}

@Composable
fun MoreActionIcon() {
    var showOption by remember{ mutableStateOf(false) }
    IconButton(onClick = { showOption=!showOption }) {
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
    }
    DropdownMenu(expanded =showOption, onDismissRequest = { showOption=false }) {
       MoreActionItem(onClick = {  }, title = "Aaaa", iconId =R.drawable.inc )
        MoreActionItem(onClick = {  }, title = "BBBBB", iconId =R.drawable.inc )
    }

}

@Composable
fun MoreActionItem(
    onClick: () -> Unit,
    title: String,
    @DrawableRes iconId: Int,
) {
    DropdownMenuItem(onClick = { onClick() }) {
        ItemIcon(iconId = iconId)
        Spacer(modifier = Modifier.width(16.dp))
        ItemTitle(title = title)
    }

}



@Composable
fun AppbarTitle(title: String) {
    Text(text = title, modifier = Modifier)
}
