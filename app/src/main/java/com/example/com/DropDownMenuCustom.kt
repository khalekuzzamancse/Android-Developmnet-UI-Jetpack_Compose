package com.example.com

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomSpinner(options: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember {
        mutableStateOf(options[0])
    }
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {
        expanded = !expanded
    }, modifier = Modifier) {
        TextField(value = selectedOption,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "label") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )

        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { selected ->
                DropdownMenuItem(onClick = {
                    selectedOption = selected
                    expanded = false
                }) {
                    Text(text = selected)
                }

            }
        }

    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyUI() {


    val listItems = arrayOf("Favorites", "Options", "Settings", "Share")

    var selectedItem by remember {
        mutableStateOf(listItems[0])
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    // the box
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {

        // text field
        TextField(
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "Label") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )

        // menu
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            listItems.forEach { selectedOption ->
                // menu item
                DropdownMenuItem(onClick = {
                    selectedItem = selectedOption
                    expanded = false
                }) {
                    Text(text = selectedOption)
                }
            }
        }
    }
}