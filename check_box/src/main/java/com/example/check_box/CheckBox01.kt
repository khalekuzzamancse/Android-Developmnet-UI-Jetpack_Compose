package com.example.check_box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.*
import androidx.compose.ui.state.ToggleableState


@Composable
//this is material 3 checkBox
fun CheckBoxDemo01() {
    var isChecked by remember {
        mutableStateOf(false)
    }
    Checkbox(checked = isChecked,
        onCheckedChange = { isChecked = !isChecked })
}

@Composable
fun TriStateCheckBoxDemo01() {
    var checkBox1State by remember {
        mutableStateOf(true)
    }
    var checkBox2State by remember {
        mutableStateOf(true)
    }
    var checkBox3State by remember {
        mutableStateOf(true)
    }

    val parentCheckBoxState = remember(checkBox1State, checkBox2State, checkBox3State) {
        if (checkBox1State && checkBox2State && checkBox3State)
            ToggleableState.On
        else if (!checkBox1State && !checkBox2State && !checkBox3State)
            ToggleableState.Off
        else
            ToggleableState.Indeterminate
    }

    Column() {
        Row() {
            Text("Parent-CheckBox")
            TriStateCheckbox(
                state = parentCheckBoxState,
                onClick = {
                    val state = !(parentCheckBoxState == ToggleableState.On)
                    checkBox1State = state
                    checkBox2State = state
                    checkBox3State = state
                }
            )

        }
        Checkbox(checked = checkBox1State,
            onCheckedChange = { checkBox1State = it })
        Checkbox(checked = checkBox2State,
            onCheckedChange = { checkBox2State = it })
        Checkbox(checked = checkBox3State,
            onCheckedChange = { checkBox3State = it })

    }
}

