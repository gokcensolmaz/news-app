package com.example.appcentnewsapp.presentation.view.details

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.appcentnewsapp.R
import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.data.remote.response.Source
import com.example.appcentnewsapp.presentation.viewmodel.details.DetailsEvent
import com.example.appcentnewsapp.ui.theme.AppcentNewsAppTheme
import com.example.appcentnewsapp.util.Dimensions.ArticleImageHeight
import com.example.appcentnewsapp.util.Dimensions.MediumPadding1


@Composable
fun DetailsScreen(
    article: Article,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailsTopBar(
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onFavoriteClick = { event(DetailsEvent.UpsertDeleteArticle(article = article)) },
            onBackClick = navigateUp
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(
                start = MediumPadding1, end = MediumPadding1, top = MediumPadding1
            )
        ) {
            item {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageHeight)
                        .clip(MaterialTheme.shapes.medium),
                    model = ImageRequest.Builder(context = context).data(article.urlToImage)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(MediumPadding1))
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(
                        id = R.color.text_title
                    )
                )
                Spacer(modifier = Modifier.height(MediumPadding1))
                Row(
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    article.author?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.bodySmall,
                            color = colorResource(
                                id = R.color.text_title
                            )
                        )
                    }
                    Row(horizontalArrangement = Arrangement.SpaceAround) {
                        Icon(
                            imageVector = Icons.Default.DateRange, contentDescription = null
                        )
                        Text(
                            text = article.publishedAt,
                            style = MaterialTheme.typography.bodySmall,
                            color = colorResource(
                                id = R.color.text_title
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(MediumPadding1))


                Text(
                    text = article.content,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(
                        id = R.color.body
                    )
                )
                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = {
                        Intent(Intent.ACTION_VIEW).also {
                            it.data = Uri.parse(article.url)
                            if (it.resolveActivity(context.packageManager) != null) {
                                context.startActivity(it)
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.appcent_indicator)

                    )
                ) {
                    Text(text = "New's Source", color = colorResource(id = R.color.appcent_text))
                    Spacer(modifier = Modifier.width(MediumPadding1))
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = colorResource(id = R.color.appcent_text)
                    )
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    AppcentNewsAppTheme(dynamicColor = false) {
        DetailsScreen(article = Article(
            author = "Crypto Saurus",
            title = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
            description = "Coinbase says Apple blocked its last app release on NFTs in Wallet ... - CryptoSaurus",
            content = "We use cookies and data to Deliver and maintain Google services Track outages and protect against spam, fraud, and abuse Measure audience engagement and site statistics to unde… [+1131 chars]",
            publishedAt = "2023-06-16T22:24:33Z",
            source = Source(
                id = "", name = "bbc"
            ),
            url = "https://consent.google.com/ml?continue=https://news.google.com/rss/articles/CBMiaWh0dHBzOi8vY3J5cHRvc2F1cnVzLnRlY2gvY29pbmJhc2Utc2F5cy1hcHBsZS1ibG9ja2VkLWl0cy1sYXN0LWFwcC1yZWxlYXNlLW9uLW5mdHMtaW4td2FsbGV0LXJldXRlcnMtY29tL9IBAA?oc%3D5&gl=FR&hl=en-US&cm=2&pc=n&src=1",
            urlToImage = "https://media.wired.com/photos/6495d5e893ba5cd8bbdc95af/191:100/w_1280,c_limit/The-EU-Rules-Phone-Batteries-Must-Be-Replaceable-Gear-2BE6PRN.jpg"
        ), event = {}) {

        }
    }
}