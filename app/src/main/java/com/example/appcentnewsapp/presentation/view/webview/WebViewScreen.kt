package com.example.appcentnewsapp.presentation.view.webview

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.appcentnewsapp.presentation.view.components.NewsTopAppBar


@Composable
fun WebViewScreen(url: String,navigateUp: () -> Unit) {
    Column {
        NewsTopAppBar(title = "News Source", onBackClick = { navigateUp()})
        AndroidView(
            factory = {
                WebView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    loadUrl(url)
                }
            },
            update = {
                it.loadUrl(url)
            }
        )
    }

}

@Preview
@Composable
fun WebviewScreenPreview() {
    WebViewScreen(url = "https://www.google.com",{})
}