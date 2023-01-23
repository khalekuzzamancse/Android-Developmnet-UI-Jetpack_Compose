package com.example.com.menus

import android.util.Log
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun CustomSpinnerDemoOnlyText() {
    val list = listOf("Abul", "Babul", "Kabul")
    CustomSpinner(options = list) {
        Log.i("Selected", it)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomSpinner(options: List<String>, onSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember {
        mutableStateOf(options[0])

    }

    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {
        expanded = !expanded
    }, modifier = Modifier.wrapContentSize()) {
        TextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "DropDown") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),

            )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { selected ->
                DropdownMenuItem(onClick = {
                    onSelected(selected)
                    selectedOption = selected
                    expanded = false
                }) {
                    Text(text = selected)
                }
            }

        }

    }
}
