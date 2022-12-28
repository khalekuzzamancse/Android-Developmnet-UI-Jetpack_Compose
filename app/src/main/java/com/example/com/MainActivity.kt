package com.example.com

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.com.ui.theme.ComTheme
import kotlinx.coroutines.launch


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
                    val l = mutableListOf<DomainMenuItem>(
                        DomainMenuItem("A", R.drawable.inc),
                        DomainMenuItem("B", R.drawable.inc),
                        DomainMenuItem("C", R.drawable.inc),
                        DomainMenuItem("D", R.drawable.inc),
                    )
                    val scaffoldState = rememberScaffoldState()
                    val coroutineScope = rememberCoroutineScope()
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        scaffoldState = scaffoldState,
                        topBar = {
                            Appbar(title = "AA", onNavigationItemClickListener = {
                                coroutineScope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            })
                        },
                        drawerContent = {
                            MenuContent(list = l)
                        }
                    ) {

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComTheme {
        Greeting("Android")
    }
}