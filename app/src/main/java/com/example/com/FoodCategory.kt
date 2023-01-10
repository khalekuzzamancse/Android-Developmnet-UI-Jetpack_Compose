package com.example.com

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyCol(list: List<DomainCategory>, onClick: (title: String) -> Unit = {}) {
    LazyColumn(contentPadding = PaddingValues(30.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(list) { item ->
            Surface(
                modifier = Modifier.clickable {
                    onClick(item.title)
                }
            ) {
                ListItem(item)

            }
            Divider(thickness = 2.dp, color = Color.Black,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
        }
    }
}


@Composable
private fun ListItem(item: DomainCategory) {
    Column() {
        Text(
            text = item.title, fontSize = 20.sp, color = Color.Black,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Image(painter = painterResource(id = item.imageId), contentDescription = null)
    }
}

data class DomainCategory(
    val title: String,
    @DrawableRes val imageId: Int,
)
