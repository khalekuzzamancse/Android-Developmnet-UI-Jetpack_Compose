package com.example.com.graphics.logos

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun BkashLogoBadVersion() {
    Canvas(
        modifier = Modifier
            .padding(10.dp)
    ) {
        drawPath(
            path = getTrianglePath(0f, 0f, 317f, 37f, 241f, 311f),
            color = Color(226, 19, 110, 255)
        )
        drawPath(
            path = getTrianglePath(241f, 312f, 146f, 664f, 292f, 543f),
            color = Color(226, 19, 110, 255)
        )
        drawPath(
            path = getTrianglePath(330f, 32f, 254f, 307f, 562f, 353f),
            color = Color(226, 19, 110, 255)
        )
        drawPath(
            path = getTrianglePath(254f, 307f, 562f, 353f, 295f, 490f),
            color = Color(209, 32, 83, 255)
        )
        drawPath(
            path = getTrianglePath(479f, 224f, 628f, 197f, 573f, 352f),
            color = Color(209, 32, 83, 255)
        )
        drawPath(
            path = getTrianglePath(637f, 197f, 614f, 262f, 700f, 262f),
            color = Color(209, 32, 83, 255)
        )
        drawPath(
            path = getTrianglePath(566f, 362f, 557f, 390f, 337f, 478f),
            color = Color(209, 32, 83, 255)
        )
        drawPath(
            path = getTrianglePath(0f, 45f, 30f, 45f, 120f, 171f),
            color = Color(209, 32, 83, 255)
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

@Composable
fun CupBottom() {
    Canvas(
        modifier = Modifier
            .padding(10.dp)
    ) {
        val path = Path().apply {
            moveTo(180f, 575f)
            lineTo(430f, 575f)
            arcTo(
                rect = Rect(offset = Offset(430f, 575f), size = Size(25f, 25f)),
                startAngleDegrees = 270f, sweepAngleDegrees = 90f, forceMoveTo = false
            )
            lineTo(455f, 700f)
            lineTo(155f, 700f)
            lineTo(155f, 600f)
            arcTo(
                rect = Rect(offset = Offset(155f, 575f), size = Size(25f, 25f)),
                startAngleDegrees = 180f, sweepAngleDegrees = 90f, forceMoveTo = false
            )
            close()
        }



        drawPath(
            path = path,
            color = Color(209, 32, 83, 255),

            )


    }

}