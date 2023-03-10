package com.example.check_box

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.check_box.ui.theme.ComTheme

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
                    Greeting("Android")
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
data class Person(
    var name: String,
)

@SuppressLint("UnrememberedMutableState")
@Composable
fun Greeting(name: String) {
    Counter()

}



@Composable
fun Counter() {
    var cnt by remember{
        mutableStateOf(0)
    }
    Text(
        text = "${cnt}",
        modifier = Modifier.clickable {
            cnt++
        }
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComTheme {
        Greeting("Android")
    }
}