package com.example.appcentnewsapp.presentation.view.search

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appcentnewsapp.R

@Composable
fun SearchCategoryScreen(
    onClick: (String) -> Unit
) {

    val categoryCardItems = remember {
        listOf(
            CategoryCardItem(
                imageId = R.drawable.business_crop,
                contentDescription = "Business Category",
                title = "Business Category",
                onClick = { onClick("Business") }
            ),
            CategoryCardItem(
                imageId = R.drawable.entertainment_crop,
                contentDescription = "Entertainment Category",
                title = "Entertainment Category",
                onClick = { onClick("Entertainment") }
            ),
            CategoryCardItem(
                imageId = R.drawable.general_crop,
                contentDescription = "General Category",
                title = "General Category",
                onClick = { onClick("General") }
            ),
            CategoryCardItem(
                imageId = R.drawable.health_crop,
                contentDescription = "Health Category",
                title = "Health Category",
                onClick = { onClick("Health") }
            ),
            CategoryCardItem(
                imageId = R.drawable.science_crop,
                contentDescription = "Science Category",
                title = "Science Category",
                onClick = { onClick("Science") }
            ),
            CategoryCardItem(
                imageId = R.drawable.sport_crop,
                contentDescription = "Sport Category",
                title = "Sport Category",
                onClick = { onClick("Sport") }
            ),
            CategoryCardItem(
                imageId = R.drawable.technology_crop,
                contentDescription = "Technology Category",
                title = "Technology Category",
                onClick = { onClick("Technology") }
            )
        )
    }
    LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {
        items(categoryCardItems) { categoryCardItem ->
            CategoryCard(categoryCardItem = categoryCardItem)
        }
    }
}

data class CategoryCardItem(
    val imageId: Int,
    val contentDescription: String,
    val title: String,
    val onClick: () -> Unit
)

@Composable
fun CategoryCard(
    categoryCardItem: CategoryCardItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(200.dp)
            .width(200.dp)
            .padding(5.dp)
            .clickable { categoryCardItem.onClick },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 30.dp,
        ),
        border = BorderStroke(width = 1.dp, color = colorResource(R.color.appcent_text))
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        ) {
            Image(
                painter = painterResource(id = categoryCardItem.imageId),
                contentDescription = categoryCardItem.contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomStart,
            ) {

                Text(
                    text = categoryCardItem.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0x90FFFFFF))
                        .padding(5.dp),
                    color = colorResource(R.color.appcent_text)

                )

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SearchCategoryScreenPreview() {
    SearchCategoryScreen(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun CategoryCardPreview() {
    CategoryCard(
        CategoryCardItem(
            imageId = R.drawable.business_crop,
            contentDescription = "Business Category",
            title = "Business Category",
            onClick = {}
        )
    )
}