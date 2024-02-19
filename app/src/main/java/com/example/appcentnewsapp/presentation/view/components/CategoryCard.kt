package com.example.appcentnewsapp.presentation.view.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcentnewsapp.R


@Composable
fun CategoryCard(
    categoryCardItem: CategoryCardItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(150.dp)
            .width(150.dp)
            .padding(5.dp)
            .clickable { categoryCardItem.onClick(categoryCardItem.title) },
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
                        .background(colorResource(R.color.appcent_transparency))
                        .padding(5.dp),
                    color = colorResource(R.color.appcent_text),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp

                )

            }
        }

    }
}

data class CategoryCardItem(
    val imageId: Int,
    val contentDescription: String,
    val title: String,
    val onClick: (String) -> Unit
)

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CategoryCardPreview() {
    CategoryCard(
        CategoryCardItem(
            imageId = R.drawable.business_crop,
            contentDescription = "Business Category",
            title = "Business",
            onClick = {}
        )
    )
}