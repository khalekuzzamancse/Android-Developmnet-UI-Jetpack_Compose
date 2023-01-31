package com.example.com.graphics.brush

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp

@Composable
fun Brush01() {
    val brush = Brush.horizontalGradient(listOf(Color.Red, Color.Blue))
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .size(400.dp)
    ) {
        drawRect(
            brush = brush,
            size = size / 3F
        )

    }

}

@Composable
fun BrushColorStop() {
    val colorStops = arrayOf(
        0.0f to Color.Yellow,
        0.2f to Color.Red,
        1f to Color.Blue
    )
    val bg = Brush.horizontalGradient(colorStops = colorStops)
    Column(
        modifier = Modifier
            .requiredSize(200.dp)
            .background(bg)
    ) {

    }
}