package com.example.jumping_minds_assignment.ui.favourites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jumping_minds_assignment.domain.models.Anime
import com.example.jumping_minds_assignment.ui.common.AnimeList

@Composable
fun FavouritesScreen(
    state: FavouritesState,
    navigateToDetails: (Anime) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Text(
            modifier = Modifier.padding(32.dp),
            text = "Favourites",
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold)
        )

        AnimeList(animes = state.favAnimes, onClick = navigateToDetails)
    }
}