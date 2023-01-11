package com.example.com.other

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp


@Composable
fun MenuContent(modifier: Modifier=Modifier,
                list: List<DomainMenuItem>) {
    LazyColumn() {
        items(list) { item ->
            MenuItem(menuItem = item,
                onClickListener = { Log.i("Clicked", "An UnKnown Item") })
        }
    }

}

/*Going to create a composable for Menu Item
following the SRP we write small small composable so that
later easily we can maintain and update them
 */
@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    menuItem: DomainMenuItem,
    onClickListener: () -> Unit = { },
) {
    Row(modifier.fillMaxWidth().clickable { onClickListener() })
    {
        ItemIcon(iconId = menuItem.icon)
        Spacer(modifier = Modifier.width(16.dp))
        ItemTitle(title = menuItem.title)
    }

}

@Composable
fun ItemIcon(@DrawableRes iconId: Int) {
    Icon(imageVector = ImageVector.vectorResource(id = iconId),
        contentDescription = null,
        modifier = Modifier
    )
}

@Composable
fun ItemTitle(title: String) {
    Text(text = title, modifier = Modifier)
}
