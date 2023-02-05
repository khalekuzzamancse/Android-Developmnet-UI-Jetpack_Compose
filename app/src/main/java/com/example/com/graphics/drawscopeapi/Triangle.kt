package com.example.com.graphics.drawscopeapi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
private fun MoveTriangle(size: Dp = 50.dp, outline: Dp = 2.dp) {
    with(LocalDensity.current) {
        val sizePx = size.toPx()
        val outlineWidthPx = outline.toPx()
        val trianglePath = remember(sizePx) {
            Path().apply {
                moveTo(sizePx / 2, 0f)
                lineTo(sizePx, sizePx)
                lineTo(0f, sizePx)
                close()
            }

        }

        fun DrawScope.drawTriangle(x: Float, y: Float) {
            translate(x, y) {
                drawPath(path = trianglePath, color = Color.Red)//filled triangle
                drawPath(
                    path = trianglePath, color = Color.Black,
                    style = Stroke(outlineWidthPx)
                )//filled triangle
            }
        }

    }


}