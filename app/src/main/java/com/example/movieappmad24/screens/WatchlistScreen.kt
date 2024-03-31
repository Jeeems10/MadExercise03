package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchlistScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Watchlist") },
            )
        },
        bottomBar = {
           /* NavigationBar {
                NavigationBarItem(
                    label = { Text("Home") },
                    selected = true,
                    onClick = { *//*TODO*//* },
                    icon = { Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Go to home"
                    )
                    }
                )
                NavigationBarItem(
                    label = { Text("Watchlist") },
                    selected = false,
                    onClick = { *//*TODO*//* },
                    icon = { Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Go to watchlist"
                    )
                    }
                )
            }*/
            BottomNavigationBar(navController = navController)
        }
    ) { padding ->
        MovieList(
            modifier = Modifier.padding(padding),
            movies = getWatchlistMovies(),
            navController = navController
        )
    }
}

fun getWatchlistMovies(): List<Movie> {
    return getMovies()
}

@Preview(showBackground = true)
@Composable
fun WatchlistScreenPreview() {
}