package com.example.com.graphics.drawscopeapi

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ScaleTriangle(size: Dp = 50.dp) {
    with(LocalDensity.current) {
        val sizePx = size.toPx()
        val trianglePath = remember(sizePx) {
            Path().apply {
                Log.i("Message", "Path Creating")
                moveTo(sizePx / 2, 0f)
                lineTo(sizePx, sizePx)
                lineTo(0f, sizePx)
                close()
            }

        }
        Canvas(modifier = Modifier) {




        }

    }
}

private fun DrawScope.drawTriangle(trianglePath: Path) {
        drawPath(path = trianglePath, color = Color.Red)//filled triangle

}