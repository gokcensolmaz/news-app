package com.example.appcentnewsapp.presentation.view.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcentnewsapp.R
import com.example.appcentnewsapp.ui.theme.AppcentNewsAppTheme
import com.example.appcentnewsapp.util.Dimensions.ExtraSmallPadding2
import com.example.appcentnewsapp.util.Dimensions.IconSize

@Composable
fun NewsBottomNavigation(
    items: List<BottomNavigationItem>,
    selected: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = colorResource(id = R.color.appcent),
        tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selected,
                onClick = { onItemClick(index) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            modifier = Modifier.size(IconSize),
                            imageVector = item.icon,
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.height(ExtraSmallPadding2))
                        Text(text = item.text, style = MaterialTheme.typography.labelSmall)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.appcent),
                    selectedTextColor = colorResource(id = R.color.appcent),
                    unselectedIconColor = colorResource(id = R.color.appcent_text),
                    unselectedTextColor = colorResource(id = R.color.appcent_text),
                    indicatorColor = colorResource(id = R.color.appcent_indicator),
                )
            )
        }
    }

}

data class BottomNavigationItem(
    val icon: ImageVector,
    val text: String
)


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NewsBottomNavigationPreview() {
    AppcentNewsAppTheme(dynamicColor = false) {
        NewsBottomNavigation(
            items = listOf(
                BottomNavigationItem(icon = Icons.Default.Home, text = "Home"),
                BottomNavigationItem(icon = Icons.Default.Search, text = "Search"),
                BottomNavigationItem(icon = Icons.Default.FavoriteBorder, text = "Favorite"),
            ), selected = 0, onItemClick = {}
        )
    }
}