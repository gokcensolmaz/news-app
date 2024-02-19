package com.example.appcentnewsapp.navigation

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.appcentnewsapp.data.local.Article
import com.example.appcentnewsapp.presentation.view.components.BottomNavigationItem
import com.example.appcentnewsapp.presentation.view.components.NewsBottomNavigation
import com.example.appcentnewsapp.presentation.view.details.DetailsScreen
import com.example.appcentnewsapp.presentation.view.favorite.FavoriteScreen
import com.example.appcentnewsapp.presentation.view.home.HomeScreen
import com.example.appcentnewsapp.presentation.view.search.SearchScreen
import com.example.appcentnewsapp.presentation.view.webview.WebViewScreen
import com.example.appcentnewsapp.presentation.viewmodel.details.DetailsEvent
import com.example.appcentnewsapp.presentation.viewmodel.details.DetailsViewModel
import com.example.appcentnewsapp.presentation.viewmodel.favorite.FavoriteEvent
import com.example.appcentnewsapp.presentation.viewmodel.favorite.FavoriteViewModel
import com.example.appcentnewsapp.presentation.viewmodel.home.HomeViewModel
import com.example.appcentnewsapp.presentation.viewmodel.search.SearchViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Navigation() {

    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = Icons.Default.Home, text = "Home"),
            BottomNavigationItem(icon = Icons.Default.Search, text = "Search"),
            BottomNavigationItem(icon = Icons.Default.FavoriteBorder, text = "Favorite"),
        )
    }

    val navController = rememberNavController()
    val backstackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    selectedItem = remember(key1 = backstackState) {
        when (backstackState?.destination?.route) {
            Destination.HomeScreen.route -> 0
            Destination.SearchScreen.route -> 1
            Destination.FavoriteScreen.route -> 2
            else -> 0
        }
    }
    val isBottomBarVisible = remember(key1 = backstackState) {
        backstackState?.destination?.route == Destination.HomeScreen.route ||
                backstackState?.destination?.route == Destination.SearchScreen.route ||
                backstackState?.destination?.route == Destination.FavoriteScreen.route
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isBottomBarVisible) {
                NewsBottomNavigation(
                    items = bottomNavigationItems,
                    selected = selectedItem,
                    onItemClick = { index ->
                        when (index) {
                            0 -> navigateToTap(
                                navController = navController,
                                route = Destination.HomeScreen.route
                            )

                            1 -> navigateToTap(
                                navController = navController,
                                route = Destination.SearchScreen.route
                            )

                            2 -> navigateToTap(
                                navController = navController,
                                route = Destination.FavoriteScreen.route
                            )
                        }
                    }
                )
            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()

        NavHost(
            modifier = Modifier.padding(bottom = bottomPadding),
            navController = navController,
            startDestination = Destination.HomeScreen.route
        ) {
            composable(Destination.HomeScreen.route) {
                val viewModel: HomeViewModel = hiltViewModel()
                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(
                    articles = articles,
                    navigateToSearch = {
                        navigateToTap(
                            navController = navController,
                            route = Destination.SearchScreen.route
                        )
                    },
                    navigateToDetails = { article ->
                        navigateToDetails(navController, article)
                    }
                )
            }

            composable(Destination.FavoriteScreen.route) {
                val viewModel: FavoriteViewModel = hiltViewModel()
                val state = viewModel.state.value

                if (viewModel.sideEffect != null) {
                    Toast.makeText(LocalContext.current, viewModel.sideEffect, Toast.LENGTH_SHORT)
                        .show()
                    viewModel.onEvent(FavoriteEvent.RemoveSideEffect)
                }

                FavoriteScreen(
                    state = state,
                    navigateToDetails = { article ->
                        navigateToDetails(navController = navController, article = article)
                    },
                    event = viewModel::onEvent
                )
            }
            composable(Destination.SearchScreen.route) {
                val viewModel: SearchViewModel = hiltViewModel()
                val state = viewModel.state.value
                SearchScreen(
                    state = state,
                    event = viewModel::onEvent,
                    navigateToDetails = { article ->
                        navigateToDetails(
                            navController = navController,
                            article = article
                        )
                    }
                )
            }
            composable(Destination.DetailsScreen.route) {
                val viewModel: DetailsViewModel = hiltViewModel()
                if (viewModel.sideEffect != null) {
                    Toast.makeText(LocalContext.current, viewModel.sideEffect, Toast.LENGTH_SHORT)
                        .show()
                    viewModel.onEvent(DetailsEvent.RemoveSideEffect)
                }
                navController.previousBackStackEntry?.savedStateHandle?.get<Article?>("article")
                    ?.let { article ->
                        DetailsScreen(
                            article = article,
                            event = viewModel::onEvent,
                            navigateUp = { navController.navigateUp() },
                            navigateToWebView = {
                                navigateToWebView(
                                    navController = navController,
                                    article = article
                                )
                            }
                        )

                    }
            }
            composable(Destination.WebviewScreen.route) {
                navController.previousBackStackEntry?.savedStateHandle?.get<Article?>("article")
                    ?.let { article ->
                        WebViewScreen(
                            url = article.url,
                            navigateUp = { navController.navigateUp() },
                        )

                    }

            }
        }
    }
}

fun navigateToWebView(navController: NavController, article: Article) {
    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(Destination.WebviewScreen.route)

}

private fun navigateToTap(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}

private fun navigateToDetails(navController: NavController, article: Article) {
    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(Destination.DetailsScreen.route)
}