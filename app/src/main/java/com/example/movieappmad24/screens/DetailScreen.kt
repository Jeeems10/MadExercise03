package com.example.movieappmad24.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavController,movieId: String?) {
    val movie = getMovieById(movieId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = movie?.title ?: "Movie Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) {
        Text(text = "Hello detailscreen $movieId")
    }
}

fun getMovieById(movieId: String?): Movie? {
    return getMovies().find { it.id == movieId }
}