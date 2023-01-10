package com.example.com

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleQuantity() {
    Column(
        modifier = Modifier.border(
            width = 2.dp,
            color= Color.Red,
            shape = RoundedCornerShape(5.dp))
    ) {
        ItemImage()
        CommonText(text = "Title", fontSize = 25.sp)
        EachRow(margin = 10.dp, text1 = "Size", text2 = "4 Kg.")
        EachRow(margin = 10.dp, text1 = "Total Weight", text2 = "8 Kg.")
        EachRow(margin = 10.dp, text1 = "Price", text2 = "700 Tk.")
        EachRow(text1 = "Total Price", text2 = "1700 Tk.")
    }


}

@Composable
private fun ItemImage() {
    Image(
        painter = painterResource(id = R.drawable.fish),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .size(50.dp), alignment = Alignment.Center
    )
}

@Composable
private fun EachRow(
    margin: Dp = 0.dp,
    text1: String,
    text2: String,
    color1: Color = Color.Unspecified,
    color2: Color = Color.Unspecified,
    fontSize1: TextUnit = TextUnit.Unspecified,
    fontSize2: TextUnit = TextUnit.Unspecified,
) {
    Row(modifier = Modifier
        .padding(horizontal = margin)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        androidx.compose.material.Text(modifier = Modifier
            .weight(1f, fill = false),
            text = text1)
        Spacer(modifier = Modifier
            .weight(0.2f))
        androidx.compose.material.Text(modifier =
        Modifier.weight(1f, fill = false), text = text2)
    }
}

@Composable
private fun CommonText(text: String, fontSize: TextUnit = TextUnit.Unspecified) {
    androidx.compose.material.Text(text = text, fontSize = fontSize
    )
}
