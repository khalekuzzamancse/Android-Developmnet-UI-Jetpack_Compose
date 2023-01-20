package com.example.com


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.com.menus.DropDownOnlyTextDemo
import com.example.com.menus.DropDownWithIcon
import com.example.com.menus.DropDownWithIconDemo
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
data class DomainItem(val itemName:String, val icon:ImageVector)

@Composable
fun Greeting() {
//    DrawShape(size = 50.dp, outlineWidth = 2.dp,
//    modifier = Modifier.fillMaxSize())
//    DrawShapeAtPoint(size = 50.dp, outlineWidth = 2.dp,
//        x= 100f,y=100f,
//        modifier = Modifier.fillMaxSize())
    //ShapeOnTap()
   DropDownOnlyTextDemo()
  // DropDownWithIconDemo()
}








@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComTheme {
        Greeting()
    }
}