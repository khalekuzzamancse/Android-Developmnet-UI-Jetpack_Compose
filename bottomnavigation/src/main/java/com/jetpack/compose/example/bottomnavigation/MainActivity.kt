package com.jetpack.compose.example.bottomnavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.compose.example.bottomnavigation.bottomappbar.material3.BottomAppbarDemo
import com.jetpack.compose.example.bottomnavigation.ui.theme.ComTheme
import java.util.*


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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Greeting() {
    Scaffold(
        bottomBar = {
            BottomAppbarDemo()
        },
    ) {



    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComTheme {
        Greeting()
    }
}