package com.example.custom_layout

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.lang.Integer.max


@Composable
fun CustomLayout01_ColumnLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier, content = content
    ) { measurables, constraints ->
        val con = constraints.copy(minWidth = 0, minHeight = 0)
        val placeables = measurables.map { measurable ->
            measurable.measure(con)
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            var yPosition = 0
            placeables.forEach { placeable ->
                // Position item on the screen
                placeable.placeRelative(x = 0, y = yPosition)

                // Record the y co-ord placed up to
                yPosition += placeable.height
            }
        }
    }
}

@Composable
fun CustomLayout02_FormLayoutDemo() {
    CustomLayout02_FormLayout(labelMaxWidth = 200.dp) {
        Text(text = "Name")
        TextField()
        Text(text = "Father Name")
        TextField()
        Text(text = "Mother Name")
        TextField()
    }
}

@Composable
fun TextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    androidx.compose.material.TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        }
    )
}


@Composable
private fun CustomLayout02_FormLayout(
    labelMaxWidth: Dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier, content = content
    ) { measurables, constraints ->
        val labelMeasurables = measurables.filterIndexed { i, measurable -> i % 2 == 0 }
        val textFieldMeasurables = measurables.filterIndexed { i, measurable -> i % 2 == 1 }
        val labelConstraints = Constraints(
            minWidth = 0,
            minHeight = 0,
            maxWidth = labelMaxWidth.toPx().toInt(),
            maxHeight = Constraints.Infinity
        )
        val labelPlaceable = labelMeasurables.map { measurable ->
            measurable.measure(labelConstraints)
        }
        val labelSectionWidth = labelPlaceable.maxOf { it.width }
        val textFiledWidth = constraints.maxWidth - labelSectionWidth
        val textFieldConstraints = Constraints(
            minWidth = textFiledWidth,
            minHeight = 0,
            maxWidth = textFiledWidth,
            maxHeight = Constraints.Infinity
        )
        val textFieldPlaceables = textFieldMeasurables.map { measurable ->
            measurable.measure(textFieldConstraints)
        }
        val layoutHeight = max(
            labelPlaceable.sumOf { it.height },
            textFieldPlaceables.sumOf { it.height }
        )
        layout(constraints.maxWidth, layoutHeight) {
            var y = 0;
            labelPlaceable.forEachIndexed { i, label ->
                val textField = textFieldPlaceables[i]
                val rowHeight = max(label.height, textField.height)
                val moveDownLabel = (rowHeight - label.height / 2)
                val moveDownTextField = (rowHeight - textField.height / 2)
                label.placeRelative(0, y + moveDownLabel)
                textField.placeRelative(labelSectionWidth, y + moveDownTextField)
                y += rowHeight
            }

        }
    }
}