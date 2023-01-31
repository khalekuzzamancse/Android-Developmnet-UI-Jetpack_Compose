package com.example.com.graphics.logos

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

@Composable
fun TriangleByCoordinate() {


    Canvas(
        modifier = Modifier
            .padding(10.dp)
    ) {
        val path = Path()
        path.apply {
            moveTo(0f, 0f)
            lineTo(317f, 37f)
            lineTo(241f, 311f)
            close()
        }
        drawPath(path = path, color = Color(226, 19, 110, 255))
        val path2 = Path()
        path2.apply {
            moveTo(241f, 312f)
            lineTo(146f, 664f)
            lineTo(292f, 543f)
            close()
        }
        drawPath(path = path2, color = Color(226, 19, 110, 255))
        val path3 = Path()
        path3.apply {
            moveTo(330f, 32f)
            lineTo(254f, 307f)
            lineTo(562f, 353f)
            close()
        }
        drawPath(path = path3, color = Color(226, 19, 110, 255))

        val path4 = Path()
        path4.apply {
            moveTo(254f, 307f)
            lineTo(562f, 353f)
            lineTo(295f, 490f)
            close()
        }
        drawPath(path = path4, color = Color(209, 32, 83, 255))
        val path5 = Path()
        path5.apply {
            moveTo(479f, 224f)
            lineTo(628f, 197f)
            lineTo(573f, 352f)
            close()
        }
        drawPath(path = path5, color = Color(209, 32, 83, 255))
        val path6 = Path()
        path6.apply {
            moveTo(637f, 197f)
            lineTo(614f, 262f)
            lineTo(700f, 262f)
            close()
        }
        drawPath(path = path6, color = Color(209, 32, 83, 255))

        val path7 = Path()
        path7.apply {
            moveTo(566f, 362f)
            lineTo(557f, 390f)
            lineTo(337f, 478f)
            close()
        }
        drawPath(path = path7, color = Color(209, 32, 83, 255))

        val path8 = Path()
        path8.apply {
            moveTo(0f, 45f)
            lineTo(30f, 45f)
            lineTo(120f, 171f)
            close()
        }
        drawPath(path = path8, color =  Color(209, 32, 83, 255))
    }
}
