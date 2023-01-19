package com.example.com.graphics

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
 private data class Coordinate(
    val x:Float,
    val y: Float
)
private var list= mutableStateListOf<Coordinate>(Coordinate(100f,100f))

@Composable
fun ShapeOnTap(){
    list.forEach() {
       DrawShapeAtPoint(size = 50.dp, outlineWidth = 2.dp,
           x= it.x,y=it.y,
           modifier = Modifier.fillMaxSize())
   }

}
@Composable
 private fun DrawShapeAtPoint(size: Dp, outlineWidth:Dp,
                     x:Float,y:Float, modifier: Modifier=Modifier) {
    with(LocalDensity.current) {
        val sizePx = size.toPx()
        val outlineWidthPx= outlineWidth.toPx()
        val rectangleSize= Size(sizePx,sizePx)
        val trianglePath = remember(sizePx) {
            Path().apply {
                moveTo(sizePx / 2, 0f)
                lineTo(sizePx, sizePx)
                lineTo(0f, sizePx)
                close()
            }


        }
        val outline= remember(outlineWidthPx) {
            Stroke(outlineWidthPx)
        }
        val shapeCenter= remember(sizePx) {
            Offset(sizePx/2,sizePx/2)
        }
        fun DrawScope.drawTriangle(x:Float,y:Float){
            translate(x,y){
                drawPath(path =trianglePath, color = Color.Red)//filled triangle
                drawPath(path =trianglePath, color = Color.Black, style =outline)//filled triangle
            }
        }
        fun DrawScope.drawSquare(x:Float,y:Float){
            translate(x,y){
                drawRect(size=rectangleSize, color = Color.Blue,
                    style = Fill, topLeft = Offset.Zero)//filled
                drawRect(size=rectangleSize, color = Color.Blue,
                    style=outline, topLeft = Offset.Zero)//outlined
            }
        }
        fun DrawScope.drawCircle(x:Float,y:Float){
            translate(x,y){
                drawCircle(radius =sizePx/2, color = Color.Green,
                    style = Fill, center = shapeCenter)//filled
                drawCircle(radius =sizePx/2, color = Color.Black,
                    style = outline, center = shapeCenter)//filled

            }
        }

        Canvas(
            modifier = modifier.
            pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        list.add(Coordinate(it.x,it.y))
                        Log.i("LLLLLL", list.size.toString())
                    },
                )
            }
        ){
            val offset=center- Offset(outlineWidthPx/2,outlineWidthPx/2)
            drawTriangle(x,y)
        }
    }




}