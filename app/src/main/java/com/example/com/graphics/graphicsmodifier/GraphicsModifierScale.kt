package com.example.com.graphics.graphicsmodifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GraphicsModifierScale() {
    Column() {
        Text(
            text = "Hello World !"
        )
        Text(
            text = "Hello World !",
            modifier = Modifier.graphicsLayer {//GraphicsLayerScope
                this.translationX = 2f
                this.translationY = 1.5f
            }

        )

    }


}

@Composable
fun GraphicsModifierTranslate() {
    Column() {
        Text(
            text = "Hello World !"
        )
        Text(
            text = "Hello World !",
            modifier = Modifier.graphicsLayer {//GraphicsLayerScope
                this.translationX = 100.dp.toPx()
                this.translationY = 10.dp.toPx()
            }

        )

    }


}

@Composable
fun GraphicsModifierClipShape() {
    Text(
        text = "Hello World !",
        fontSize=30.sp,
        modifier = Modifier
            .wrapContentSize()
            .graphicsLayer {//GraphicsLayerScope
                this.clip = true
                shape = CircleShape

            }
            .background(Color(0xFFF06292))
    )


}