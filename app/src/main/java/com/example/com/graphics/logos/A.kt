package com.example.com.graphics.logos

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

@Composable
fun FF() {
    Canvas(
        modifier = Modifier
            .wrapContentSize(Alignment.TopEnd)
            .size(50.dp)
            .background(color = Color(224, 206, 214, 255))
    ) {
        val x = size.height

        drawPath(
            path = getTrianglePath(100f, 200f, 0f, size.height, size.width, x),
            color = Color(226, 19, 110, 255)
        )
    }
}

private fun getTrianglePath(
    x1: Float, y1: Float,
    x2: Float, y2: Float,
    x3: Float, y3: Float,
): Path {
    val path = Path()
    path.apply {
        moveTo(x1, y1)
        lineTo(x2, y2)
        lineTo(x3, y3)
        close()
    }
    return path;
}