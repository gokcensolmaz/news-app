package com.example.appcentnewsapp.presentation.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.appcentnewsapp.R
import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.util.Dimensions

@Composable
fun NewsImageBox(article: Article,modifier : Modifier = Modifier){
    val imageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(article.urlToImage)
            .size(Size.ORIGINAL)
            .build()
    ).state
    if (imageState is AsyncImagePainter.State.Error) {
        Box(
            modifier = modifier
                .background(colorResource(id = R.color.appcent_text)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(0.8f),
                imageVector = Icons.Rounded.ImageNotSupported,
                tint = colorResource(id = R.color.appcent),
                contentDescription = null
            )
        }
    }

    if (imageState is AsyncImagePainter.State.Success) {

        Image(
            modifier = modifier,
            painter = imageState.painter,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}