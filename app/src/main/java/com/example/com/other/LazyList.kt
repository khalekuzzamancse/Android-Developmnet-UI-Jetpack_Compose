package com.example.com.other

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

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

