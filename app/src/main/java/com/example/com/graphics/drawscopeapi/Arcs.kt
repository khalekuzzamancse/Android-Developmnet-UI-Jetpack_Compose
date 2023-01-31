package com.example.com.graphics.drawscopeapi

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.unit.dp

@Composable
fun Arc1(){
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .size(400.dp)
    ){
        drawArc(
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = false,
            color = Color.Blue,
            style =Stroke(4f)

        )
    }
}
@Composable
fun DrawCircle(){
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .size(400.dp)
    ){
       drawCircle(
           color = Color.Red
       )
    }
}
@Composable
fun DrawLine(){
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .size(400.dp)
    ){
        drawLine(
            start = Offset(x=0f,y=0f),
            end = Offset(500f,500f)
           , color = Color.Red
        )
    }
}
@Composable
fun DrawText(){
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .size(400.dp)
    ){

    }
}