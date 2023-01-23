package com.example.com.graphics

import android.graphics.Outline
import android.graphics.Path.FillType
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.unit.dp

@Composable
fun Test() {
    Canvas(
        modifier = Modifier
            .wrapContentSize()
            .size(400.dp)
            .background(Color.LightGray)
    ) {
        val path = Path()
        //path.moveTo(250f, 250f)
        path.arcTo(
            rect = Rect(Offset(0f, 0f), Offset(500f, 500f)),
            startAngleDegrees = 30f, sweepAngleDegrees = 90f, forceMoveTo = true
        )
        // lineTo(300f, 1000f)
        drawPath(path = path, color = Color.Red, style = Stroke(5f))


    }
}