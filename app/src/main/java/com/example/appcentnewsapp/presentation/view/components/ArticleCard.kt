package com.example.appcentnewsapp.presentation.view.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.appcentnewsapp.R
import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.data.remote.response.Source
import com.example.appcentnewsapp.util.Dimensions.ArticleCardSize
import com.example.appcentnewsapp.util.Dimensions.ExtraSmallPadding
import com.example.appcentnewsapp.util.Dimensions.ExtraSmallPadding2
import com.example.appcentnewsapp.util.Dimensions.SmallIconSize
import com.example.appcentnewsapp.ui.theme.AppcentNewsAppTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier, article: Article, onClick: () -> Unit
) {
    val context = LocalContext.current
    Row(modifier = modifier.clickable { onClick() }) {

        Box(modifier = Modifier.weight(0.5f)) {
            Column(
                modifier = Modifier
                    .padding(horizontal = ExtraSmallPadding)
                    .height(ArticleCardSize),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = article.title ?: "Title not available",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(
                        id = R.color.text_title
                    ),
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = article.description ?: "Description not available",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(
                        id = R.color.text_title
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.size(SmallIconSize),
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = colorResource(id = R.color.body)
                        )
                        Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                        Text(
                            text = article.source.name ?: "Source Name",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                            color = colorResource(id = R.color.body)
                        )
                    }
                    Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.size(SmallIconSize),
                            imageVector = Icons.Default.DateRange,
                            contentDescription = null,
                            tint = colorResource(id = R.color.body)
                        )
                        Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                        Text(
                            text = article.publishedAt.split("T")[0] ?: "Date",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                            color = colorResource(id = R.color.body)
                        )
                    }
                }
            }
        }

        Box(modifier = Modifier.weight(0.2f)) {
            NewsImageBox(
                article = article,
                modifier = Modifier
                    .size(ArticleCardSize)
                    .clip(RoundedCornerShape(8.dp)),
            )

        }
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    AppcentNewsAppTheme {
        ArticleCard(
            article = Article(
                author = "",
                content = "",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus velit arcu, finibus nec aliquet sed, efficitur ut tortor. Nulla consequat ante ac augue auctor tempor. Aliquam sit amet maximus nunc, sed suscipit neque. Sed eros lectus, finibus vel nulla sit amet, viverra consectetur nisi. Curabitur cursus nunc ut nisl dictum vehicula. Donec tempor nec libero id lobortis. Aliquam condimentum nec nulla viverra tempus. Donec finibus a purus et ultrices.",
                publishedAt = "2 hours",
                source = Source(id = "", name = "BBC"),
                title = "Her train broke down. Her phone died. And then she met her Saver in a",
                url = "",
                urlToImage = ""
            )
        ) {}
    }
}