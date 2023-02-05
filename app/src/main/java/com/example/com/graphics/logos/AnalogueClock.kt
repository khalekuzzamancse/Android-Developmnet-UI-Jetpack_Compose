package com.example.com.graphics.logos

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AnalougeClock(modifier: Modifier=Modifier,size:Dp=200.dp){
    Canvas(modifier =modifier){
        val diameter=size.toPx()
        val radius=diameter/2
        val outlineWidth=15f
        drawCircle(radius = radius, color = Color.Gray)//the filled circle
        drawCircle(radius = radius, color = Color.Black, style = Stroke(outlineWidth))//the filled circle
        for(i in 0..11){
            rotate((i/12f)*360){
                //drawing the line
                //line will start at (0,r)
                val start= center-Offset(0f,radius-outlineWidth/2)
                //we want to keep the line straight and line length=30px
                //the end point will be,
                val end=start+Offset(0f,30f)
                drawLine(start = start, end = end, strokeWidth = 10f, color = Color.Red)
            }
        }


    }

}
