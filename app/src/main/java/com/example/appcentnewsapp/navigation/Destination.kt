package com.example.appcentnewsapp.navigation

sealed class Destination(val route: String) {
    object HomeScreen : Destination(route = "main")
    object SearchScreen : Destination(route = "search")
    object FavoriteScreen : Destination(route = "bookmark")
    object DetailsScreen : Destination(route = "news_detail")
    object WebviewScreen: Destination(route = "webview")
}