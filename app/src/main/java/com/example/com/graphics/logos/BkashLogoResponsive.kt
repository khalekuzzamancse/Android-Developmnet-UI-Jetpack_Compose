package com.example.com.graphics.logos

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp


@Composable
fun BkashLogoResizeable() {
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .size(100.dp)

    ) {
        drawPath(
            path = getTrianglePath(size.width, 0f, 0f, .45285f, .055722f, .34428f, .46373f),
            color = Color(226, 19, 110, 255)
        )
        drawPath(
            path = getTrianglePath(size.width, 0.35f, 0.489457f, .428571f, .820783f, .221428f, 1f),
            color = Color(226, 19, 110, 255)
        )
        drawPath(
            path = getTrianglePath(
                size.width, 0.47571f, 0.06475f, .3642857f, .4789156f, .8071428f, .549698f
            ),
            color = Color(226, 19, 110, 255)
        )
        drawPath(
            path = getTrianglePath(size.width, 0.36428f, 0.47891f, .807142f, .549698f, .421428f, .753012f),
            color = Color(209, 32, 83, 255)
        )
        drawPath(
            path = getTrianglePath(
                size.width,
                0.68571f,
                0.35391f,
                .821428f,
                .549698f,
                .9f,
                .308734f
            ),
            color = Color(209, 32, 83, 255)
        )
        drawPath(
            path = getTrianglePath(
                size.width,
                0.914285f,
                0.316365f,
                .885714f,
                .406626f,
                1f,
                .4141566f
            ),
            color = Color(209, 32, 83, 255)
        )
        ///
        drawPath(
            path = getTrianglePath(
                size.width,
                .00428f,
                .081325f,
                .05f,
                .081235f,
                .1857f,
                .26355f
            ),
            color = Color(209, 32, 83, 255)
        )
        drawPath(
            path = getTrianglePath(
                size.width,
                .81f,
                .56475f,
                .8f,
                .60240f,
                .48571f,
                .734939f
            ),
            color = Color(209, 32, 83, 255)
        )
    }

}

private fun getTrianglePath(
    width: Float,
    x1: Float, y1: Float,
    x2: Float, y2: Float,
    x3: Float, y3: Float,
): Path {
    val height = 0.94857f * width
    val path = Path()
    path.apply {
        moveTo(x1 * width, y1 * height)
        lineTo(x3 * width, y3 * height)
        lineTo(x2 * width, y2 * height)
        close()
    }
    return path;
}