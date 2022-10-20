package com.example.mcdonalds.ui.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.mcdonalds.R
import com.example.mcdonalds.model.MenuItem
import com.example.mcdonalds.ui.components.NetworkImage
import com.example.mcdonalds.ui.components.QuantityToggle
import com.example.mcdonalds.ui.theme.McDonaldsTheme

@Composable
fun MenuItem(
    menuItem: MenuItem,
    onClick: () -> Unit,
    onIncrementMenuItemQuantity: () -> Unit,
    onDecrementMenuItemQuantity: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onSurface
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colors.surface),
                contentAlignment = Alignment.Center
            ) {
                NetworkImage(
                    imageUrl = menuItem.image,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.40f),
                    previewPlaceholder = R.drawable.menu_item_double_quarter_pounder_with_cheese_meal
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = menuItem.name,
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    text = menuItem.description,
                    style = MaterialTheme.typography.body2,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$" + "%.2f".format(menuItem.price),
                        style = MaterialTheme.typography.subtitle2
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    QuantityToggle(
                        quantity = menuItem.quantity,
                        onIncrementQuantity = onIncrementMenuItemQuantity,
                        onDecrementQuantity = onDecrementMenuItemQuantity,
                    )
                }
            }
        }
    }
}

@Preview("Menu Item Card")
@Composable
private fun MenuCardPreview() {
    McDonaldsTheme {
        MenuItem(
            menuItem = MenuItem(
                id = 0,
                name = "Double Quarter Pounder with Cheese Meal",
                description = "Get double the fresh beef flavor with a Double Quarter Pounder with Cheese made with fresh beef that’s cooked when you order. Served with our World Famous Fries and your choice of an icy soft drink.",
                image = "",
                price = 0.00,
                categoryId = 0
            ),
            onClick = {},
            onIncrementMenuItemQuantity = {},
            onDecrementMenuItemQuantity = {},
        )
    }
}

@Preview("Menu Item Card • Dark")
@Composable
private fun MenuItemDarkPreview() {
    McDonaldsTheme(lightTheme = false) {
        MenuItem(
            menuItem = MenuItem(
                id = 0,
                name = "Double Quarter Pounder with Cheese Meal",
                description = "Get double the fresh beef flavor with a Double Quarter Pounder with Cheese made with fresh beef that’s cooked when you order. Served with our World Famous Fries and your choice of an icy soft drink.",
                image = "",
                price = 0.00,
                categoryId = 0
            ),
            onClick = {},
            onIncrementMenuItemQuantity = {},
            onDecrementMenuItemQuantity = {},
        )
    }
}
