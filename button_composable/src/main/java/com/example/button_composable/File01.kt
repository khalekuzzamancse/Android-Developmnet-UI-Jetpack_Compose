package com.example.button_composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun ButtonO1() {
    var shouldEnabled by remember {
        mutableStateOf(true)
    }
    Button(
        onClick = { shouldEnabled = !shouldEnabled },
        enabled = shouldEnabled
    ) {
        Icon(
            Icons.Filled.Send,
            contentDescription = "Localized description",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Send")
    }
}