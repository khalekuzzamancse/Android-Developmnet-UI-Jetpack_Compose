package com.jetpack.compose.example.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Constraints
import kotlin.math.abs

@Composable
fun CustomBottomNavigation01Demo() {
    CustomBottomNavigation01()
}

@Composable
fun CustomBottomNavigation01() {
    CustomLayout02_(modifier = Modifier.background(Color.LightGray)) {
        Icon(imageVector = Icons.Default.Home, contentDescription = null)
        Text(text = "Home")
        Icon(imageVector = Icons.Default.Settings, contentDescription = null)
        Text(text = "Setting")
        Icon(imageVector = Icons.Default.Search, contentDescription = null)
        Text(text = "Search")
        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
        Text(text = "Cart")
    }

}

@Composable
fun CustomLayout02_(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier, content = content
    ) { measurables, constraints ->
        val iconMeasureables = measurables.filterIndexed { i, measurable -> i % 2 == 0 }
        val textMeasurables = measurables.filterIndexed { i, measurable -> i % 2 == 1 }
        val constraints2 = Constraints(
            minWidth = 0,
            minHeight = 0,
            maxHeight = constraints.maxHeight,
            maxWidth = constraints.maxWidth
        )
        val iconPlaceable = iconMeasureables.map { measurable ->
            measurable.measure(constraints2)
        }

        val textPlaceables = textMeasurables.map { measurable ->
            measurable.measure(constraints2)
        }
        val sectionWidths = mutableListOf<Int>()
        for (i in 0..iconPlaceable.size - 1) {
            sectionWidths.add(maxOf(iconPlaceable[i].width, textPlaceables[i].width))
        }
        var placeableItemTotalWidth = 0;
        for (i in 0..sectionWidths.size - 1) {
            placeableItemTotalWidth += sectionWidths[i]
        }
        val remainingFreeWidth = constraints.maxWidth - placeableItemTotalWidth
        val gapWidth = remainingFreeWidth / (iconPlaceable.size - 1)
        val eachSectionTopLeftX = mutableListOf<Int>()
        eachSectionTopLeftX.add(0)
        var sum = 0
        for (i in 1..iconPlaceable.size) {
            sum = sum + sectionWidths[i - 1]
            eachSectionTopLeftX.add(sum + i * gapWidth)
        }

        val layoutHeight = iconPlaceable[0].height + textPlaceables[0].height
        layout(constraints.maxWidth, layoutHeight) {
            var y = 0;
            iconPlaceable.forEachIndexed { i, placeable ->
                val shiftTextX= abs(iconPlaceable[i].width-textPlaceables[i].width)/2
                placeable.placeRelative(eachSectionTopLeftX.get(i)+shiftTextX, y)
            }
            textPlaceables.forEachIndexed { i, placeable ->

                placeable.placeRelative(eachSectionTopLeftX.get(i),placeable.height)
            }
        }
    }
}
