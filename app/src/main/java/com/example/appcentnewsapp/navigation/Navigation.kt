package com.example.appcentnewsapp.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.MainScreen.route) {
        composable(Destination.MainScreen.route) {
            Text(text = "Main Screen")
        }
        composable(Destination.BookmarkScreen.route) {
            Text(text = "Bookmark Screen")
        }
        composable(Destination.NewsDetailScreen.route) {
            Text(text = "News Detail Screen")
        }
        composable(Destination.NewsWebviewScreen.route) {
            Text(text = "Web view Screen")
        }
    }
}