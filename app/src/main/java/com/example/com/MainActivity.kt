package com.example.com


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.com.graphics.DrawShape
import com.example.com.graphics.ShapeOnTap
import com.example.com.other.LazyGridSpan
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
//    DrawShape(size = 50.dp, outlineWidth = 2.dp,
//    modifier = Modifier.fillMaxSize())
//    DrawShapeAtPoint(size = 50.dp, outlineWidth = 2.dp,
//        x= 100f,y=100f,
//        modifier = Modifier.fillMaxSize())
    ShapeOnTap()
}


@Composable
fun L(list: List<String>) {
    LazyColumn(
        contentPadding = PaddingValues(30.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(list) { i, value ->
            if (i == list.size - 1) {
                Text(text = value)
                Divider(
                    thickness = 2.dp, color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
                Text(text = "End")
            } else {
                Text(text = value)


            }
        }


    }
}

@Composable
fun LazyListWithHeader(map: Map<String, List<String>>) {
    LazyColumn() {
        map.forEach() { key, value ->
            item() {
                Text(
                    text = key,
                    fontSize = 30.sp,
                )
            }

            items(value) { it ->
                Text(text = it)
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComTheme {
        Greeting()
    }
}