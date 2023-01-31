package com.example.com


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.com.graphics.graphicsmodifier.GraphicsLayerModifierDemo
import com.example.com.ui.theme.ComTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()

                }
            }
        }
    }
}


@Composable
fun Greeting() {
   // GraphicsModifierTranslate()
   // GraphicsModifierClipShape()
    GraphicsLayerModifierDemo()

}


@Composable
fun MyUI() {
    Box(modifier = Modifier
        .wrapContentSize()
        .size(size = 300.dp)
        .border(width = 2.dp, color = Color.Magenta, shape = RectangleShape)
        .drawBehind {
            // draw here
            drawLine(
                color = Color.Blue,
                strokeWidth = 2.dp.toPx(),
                start = Offset(x = size.width / 2, y = 0f),
                end = Offset(x = size.width / 2, y = size.height)
            )
        }
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComTheme {
        Greeting()
    }
}