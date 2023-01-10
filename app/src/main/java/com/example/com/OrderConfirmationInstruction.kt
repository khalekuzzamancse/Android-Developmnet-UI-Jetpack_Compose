package com.example.com

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ConfirmOrderInstruction(modifier: Modifier = Modifier) {
    Column(modifier.padding(10.dp)) {
        Text(text = "To confirm the order,please send 20% of the total price")
        Text(text = "We Accept")
        PaymentOptions()
        Text(text = "We Accept")
        //annotating the code

        var w1= AnnotatedString(text ="BHGDHGFF", spanStyle = SpanStyle(Color.Blue))
        var w=AnnotatedString(text = "Use ")+w1+ AnnotatedString(text = " as reference code")
        Text(text =w)
    }

}
@Composable
fun PaymentOptions(){
    Column() {
        PaymentEachRow(iconId = R.drawable.fish, text = "Bkash-01738813865")
        PaymentEachRow(iconId = R.drawable.fish, text = "Bkash-01738813865")
        PaymentEachRow(iconId = R.drawable.fish, text = "Bkash-01738813865")
    }
}

@Composable
private fun PaymentEachRow(
    margin: Dp = 0.dp,
    text: String = "01738813865",
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    @DrawableRes iconId: Int,
) {
    ConstraintLayout(
        modifier = Modifier.wrapContentSize()
    ) {
        val (icon, textRef) = createRefs()
        Text(
            text = text,
            modifier = Modifier.constrainAs(textRef) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        )
        Image(
            modifier = Modifier
                .constrainAs(icon) {
                    top.linkTo(textRef.top)
                    bottom.linkTo(textRef.bottom)
                    end.linkTo(textRef.start)
                    height = Dimension.fillToConstraints
                }
                .wrapContentWidth(),
            painter = painterResource(id = iconId),
            contentDescription = null,
        )
    }

}

