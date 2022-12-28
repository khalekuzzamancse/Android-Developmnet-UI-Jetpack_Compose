package com.example.hospital.compose

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable

@Composable
fun BottomNav(){
    BottomNavigation() {
        BottomNavigationItem(selected = true,
            onClick = {  },
            icon ={ Icon(Icons.Default.Email, contentDescription = "") },
            label ={ Text(text = "Email") }
        )
        BottomNavigationItem(selected = true,
            onClick = {  },
            icon ={ Icon(Icons.Default.Call, contentDescription = "") },
            label ={ Text(text = "Call") })
    }
}
