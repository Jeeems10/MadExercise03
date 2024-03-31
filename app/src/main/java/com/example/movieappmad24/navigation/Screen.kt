import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String = "", val icon: ImageVector? = null) {
    object HomeScreen : Screen(route = "homescreen", label = "Home", icon = Icons.Default.Home)
    object WatchlistScreen : Screen(route = "watchlistscreen", label = "Watchlist", icon = Icons.Default.Star)

    object DetailScreen : Screen(route = "detailscreen/{movieId}") {
        fun createRoute(movieId: String) = "detailscreen/$movieId"
    }
}
