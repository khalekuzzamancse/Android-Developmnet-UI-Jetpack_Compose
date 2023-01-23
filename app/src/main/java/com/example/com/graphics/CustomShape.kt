package com.example.com.graphics

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp


@Composable
fun MessageBox() {
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .size(400.dp)
    ) {
        val path = Path().apply {
            arcTo(
                rect = Rect(offset = Offset(0f, 0f), size = Size(100f, 100f)),
                startAngleDegrees = 180f, sweepAngleDegrees = 90f, forceMoveTo = true
            )

            lineTo(300f, 0f)
            //-----------------------
            //creating the triangle path
            lineTo(500f, 0f)
            lineTo(400f, 100f)
            //---------------------
            lineTo(400f, 200f)


            arcTo(
                rect = Rect(offset = Offset(300f, 200f), size = Size(100f, 100f)),
                startAngleDegrees = 0f, sweepAngleDegrees = 90f, forceMoveTo = false
            )
            lineTo(100f, 300f)
            arcTo(
                rect = Rect(offset = Offset(0f, 200f), size = Size(100f, 100f)),
                startAngleDegrees = 90f, sweepAngleDegrees = 90f, forceMoveTo = false
            )
            lineTo(0f, 50f)

        }
        drawPath(path = path, color = Color.Red, style = Stroke(5f))


    }
}

@Composable
fun RoundedRecByPath() {
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .size(400.dp)
    ) {
        val path = Path().apply {
            arcTo(
                rect = Rect(Offset(0f, 0f), Offset(100f, 100f)),
                startAngleDegrees = 180f, sweepAngleDegrees = 90f, forceMoveTo = false
            )
            lineTo(300f, 0f)
            arcTo(
                rect = Rect(Offset(300f, 0f), Offset(400f, 100f)),
                startAngleDegrees = 270f, sweepAngleDegrees = 90f, forceMoveTo = false
            )
            lineTo(400f, 200f)
            arcTo(
                rect = Rect(Offset(300f, 0f), Offset(400f, 100f)),
                startAngleDegrees = 270f, sweepAngleDegrees = 90f, forceMoveTo = true
            )
            lineTo(400f, 300f)
            arcTo(
                rect = Rect(Offset(300f, 300f), Offset(400f, 400f)),
                startAngleDegrees = 0f, sweepAngleDegrees = 90f, forceMoveTo = false
            )
            lineTo(100f, 400f)
            arcTo(
                rect = Rect(Offset(0f, 300f), Offset(100f, 400f)),
                startAngleDegrees = 90f, sweepAngleDegrees = 90f, forceMoveTo = false
            )
            lineTo(0f, 50f)
        }

        drawPath(path = path, color = Color.Red, style = Stroke(5f))


    }
}