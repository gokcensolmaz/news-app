package com.example.appcentnewsapp.navigation

sealed class Destination(val route: String) {
    object MainScreen : Destination(route = "main")
    object BookmarkScreen : Destination(route = "bookmark")
    object NewsDetailScreen : Destination(route = "news_detail")
    object NewsWebviewScreen: Destination(route = "webview")
}