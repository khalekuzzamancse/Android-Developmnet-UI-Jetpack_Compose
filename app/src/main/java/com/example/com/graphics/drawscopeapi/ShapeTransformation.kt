package com.example.com.graphics.drawscopeapi

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.dp

@Composable
fun RotateRectangle() {
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .size(200.dp)
            .background(Color.Magenta)
    ) {
        rotate(degrees = 45F)
        {
            drawRect(
                color = Color.Gray,
                topLeft = Offset(x = size.width / 3F, y = size.height / 3F),
                size = size / 3F
            )
        }
    }
}

@Composable
fun ScaleRectangle() {
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .size(400.dp)
    ) {
        scale(
            scaleX = 2f,
            scaleY = 3f,
        ) {
            drawRect(color = Color.Gray,
                topLeft = Offset(x = size.width / 3F, y = size.height / 3F),
                size = size / 3F
            )
        }
    }
}

@Composable
fun RectangleMove() {
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .size(400.dp)
    ) {
        translate(left = 200f, top = 300f) {
            drawRect(
                color = Color.Gray,
                topLeft = Offset(x = size.width / 3F, y = size.height / 3F),
                size = size / 3F
            )
        }
    }
}

@Composable
fun RectangleWithTransformation() {
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .size(400.dp)
    ) {
        withTransform({
            translate(10.0f, 12.0f)
            rotate(45.0f, center)
            scale(2.0f, 0.5f)
        }) {
            drawRect(
                color = Color.Gray,
                topLeft = Offset(x = size.width / 3F, y = size.height / 3F),
                size = size / 3F
            )
        }


    }
}