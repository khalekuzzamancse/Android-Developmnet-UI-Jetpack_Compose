package com.example.com.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan

import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyH(list: List<Int>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 15.dp)
    ) {
        items(list) { item ->
            ImageV(resId = item)
        }
    }
}

@Composable
fun LazyCol(list: List<Int>, state: LazyListState) {
    LazyColumn() {
        items(list) { item ->
            ImageV(resId = item)
        }
    }
}
@Composable
fun CustomGrid(list: List<Int>){
    LazyVerticalGrid(columns =object : GridCells {
        override
        fun Density.calculateCrossAxisCellSizes(availableSize: Int, spacing: Int): List<Int> {
            val c1=(availableSize-spacing)*2/3
            val c2=availableSize-c1-spacing
            return listOf(c1,c2)
        }

    }){
        items(list)
        { item ->
            ImageV(resId = item)
        }

    }
}
@Composable
fun LazyG(list: List<Int>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 15.dp),
    ) {
        items(list) { item ->
            ImageV(resId = item)
        }
    }
}
/*
calling data
val list= mutableListOf<Int>()
    for (i in 1..5){
        list.add(R.drawable.flower)
    }
    val map= mutableMapOf<String,List<Int>>()
    map.put("Sunday",list)
    map.put("Monday",list)
    map.put("Tuesday",list)
    LazyGridSpan(map)
 */
@Composable
fun LazyGridSpan(map: Map<String,List<Int>>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 15.dp),
    ) {
        map.forEach(){key,value->
            item(span ={GridItemSpan(maxLineSpan)}){
                Card(elevation = 5.dp,
                    backgroundColor = Color.Green
                ) {
                    Text(text = key)
                }
            }
            items(value) { item ->
                Image(painter = painterResource(id =item),
                    contentDescription ="",
                    modifier = Modifier
                        .size(90.dp),
                    contentScale = ContentScale.FillBounds
                )
            }
        }

    }
}

/*
calling data

 val l = remember {
        mutableStateListOf<String>()
    }
    for(i in 1 ..5 ){
        l.add("Hello Item "+i)
    }
    ListWithDeleteOption(l)
 */
@Composable
fun ListWithDeleteOption(list:MutableList<String>){
    LazyColumn(){
        items(list){item ->  
            Row() {
                Text(text=item)
                Button(onClick = { list.remove(item) }) {
                    Text(text = "Delete")
                }
                
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
@Composable
private fun L(list: List<String>) {
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