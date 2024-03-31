package com.example.movieappmad24.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp


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
        movie?.let { movieDetails ->
            Column {
                MovieRow(movie = movieDetails)
                ImageCarousel(images = movieDetails.images)
            }
        } ?: Text(text = "Movie not found")
    }
}

@Composable
fun ImageCarousel(images: List<String>) {
    LazyRow(modifier = Modifier.padding(vertical = 8.dp)) {
        items(images) { imageUrl ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(200.dp),
            ) {
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Movie Image",
                    contentScale = ContentScale.Crop,
                    loading = { CircularProgressIndicator() }
                )
            }
        }
    }
}

fun getMovieById(movieId: String?): Movie? {
    return getMovies().find { it.id == movieId }
}