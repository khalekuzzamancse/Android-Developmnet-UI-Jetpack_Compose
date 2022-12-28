package com.example.hospital.compose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageV(@DrawableRes resId:Int){
    Image(painter = painterResource(id =resId),
        contentDescription ="",
        modifier = Modifier
            .size(90.dp)
            .clip(CircleShape),
        contentScale = ContentScale.FillBounds
    )
}
