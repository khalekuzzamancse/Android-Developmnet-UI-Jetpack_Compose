package com.example.com

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                            Appbar(title = "AA", onNavigationItemClick = {
                                coroutineScope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            })
                        },
                        drawerContent = {
                            DrawerContent(list = l)
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


@Composable
fun DrawerContent(list: List<DomainMenuItem>) {
    LazyColumn(modifier = Modifier) {
        items(list) { item ->
            MenuItem(menuItem = item,
                onClickListener = {Log.i("Clicked","An UnKnown Item")})
        }
    }

}

@Composable
fun MenuItem(
    modifier: Modifier=Modifier,
    menuItem: DomainMenuItem,
    onClickListener: () -> Unit = { },
) {
    Row(modifier.fillMaxWidth().clickable {onClickListener() })
    {
        Icon(imageVector = ImageVector.vectorResource(id = menuItem.icon),
            contentDescription = null)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = menuItem.title, modifier = Modifier)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComTheme {
        Greeting("Android")
    }
}