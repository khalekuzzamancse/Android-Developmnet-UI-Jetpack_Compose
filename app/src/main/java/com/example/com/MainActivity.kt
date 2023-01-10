package com.example.com


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.com.ui.theme.ComTheme
import com.example.hospital.compose.ListWithDeleteOption


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
    var list = mutableListOf<DomainCategory>()
    val id = R.drawable.fish
    list.add(DomainCategory("Fish", id))
    list.add(DomainCategory("Chicken", id))
    list.add(DomainCategory("Fast Food", id))
    list.add(DomainCategory("Sea Fish", id))
    list.add(DomainCategory("Meat", id))

    val onClick: (title: String) -> Unit = { title ->
        Log.i("Clicked", title)
    }
//    LazyCol(
//        list = list,
//        onClick = onClick
//    )
    val l = remember {
        mutableStateListOf<String>()
    }
    for(i in 1 ..5 ){
        l.add("Hello Item "+i)
    }
    ListWithDeleteOption(l)

}

@Composable
fun L(list:List<String>) {
    LazyColumn(contentPadding = PaddingValues(30.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        itemsIndexed(list){i,value->
            if(i==list.size-1){
                Text(text =value)
                Divider(thickness = 2.dp, color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
                Text(text = "End")
            }
            else
            {
                Text(text =value)


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