package com.example.textfield_composable

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDemo01Version1() {
    var text by remember() {
        mutableStateOf(TextFieldValue("example"))
    }
    val callback = fun(it: TextFieldValue) {
        text = it
    }
    TextField(value = text, onValueChange = callback)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDemo01Version2() {
    var text by remember() {
        mutableStateOf(TextFieldValue("example"))
    }
    TextField(value = text, onValueChange = { it ->
        text = it
    })
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldDemo02Version1() {
    var text by remember() {
        mutableStateOf(TextFieldValue("example"))
    }
    TextField(value = text, onValueChange = { it ->
        text = it
    },
        label = { Text(text = "Name")}
    )
}
