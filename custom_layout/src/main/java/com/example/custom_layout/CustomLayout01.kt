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
@Composable
private fun FormLayout(
    eachRow1stChildMaxWidth: Dp,
    verticalGap: Dp = 5.dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier, content = content
    ) { measurables, constraints ->
        val firstColumnChildMeasureAbles = measurables.filterIndexed { i, measurable -> i % 2 == 0 }
        val secondColumnChildMeasureAbles = measurables.filterIndexed { i, measurable -> i % 2 == 1 }
        val eachRow1stChildConstraint = Constraints(
            minWidth = 0,
            minHeight = 0,
            maxWidth = eachRow1stChildMaxWidth.toPx().toInt(),
            maxHeight = Constraints.Infinity
        )
        val firstColumnChildPlaceAbles = firstColumnChildMeasureAbles.map { measurable ->
            measurable.measure(eachRow1stChildConstraint)
        }
        //let gap between two column=5dp

        val firstColumnWidth = firstColumnChildPlaceAbles.maxOf { it.width + verticalGap.toPx().toInt() }
        val secondColumnWidth = constraints.maxWidth - firstColumnWidth
        val eachRowSecondChildConstraint = Constraints(
            minWidth = secondColumnWidth,
            minHeight = 0,
            maxWidth = secondColumnWidth,
            maxHeight = Constraints.Infinity
        )
        val secondColumnChildPlaceAbles = secondColumnChildMeasureAbles.map { measurable ->
            measurable.measure(eachRowSecondChildConstraint)
        }
        val layoutHeight = max(
            firstColumnChildPlaceAbles.sumOf { it.height },
            secondColumnChildPlaceAbles.sumOf { it.height }
        )
        layout(constraints.maxWidth, layoutHeight) {
            var y = 0;
            firstColumnChildPlaceAbles.forEachIndexed { i, label ->
                val textField = secondColumnChildPlaceAbles[i]
                val rowHeight = max(label.height, textField.height)
                val eachRow1stChildMoveDown = (rowHeight - label.height) / 2
                val eachRow2ndChildMoveDown = (rowHeight - textField.height) / 2
                label.placeRelative(0, y + eachRow1stChildMoveDown)
                textField.placeRelative(firstColumnWidth, y + eachRow2ndChildMoveDown)
                y += rowHeight
            }

        }
    }
}