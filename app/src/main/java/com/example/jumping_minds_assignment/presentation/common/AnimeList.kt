package com.example.jumping_minds_assignment.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.jumping_minds_assignment.domain.models.Data
import com.example.jumping_minds_assignment.presentation.Dimens.ExtraSmallPadding2
import com.example.jumping_minds_assignment.presentation.Dimens.MediumPadding1

@Composable
fun AnimeList(
    modifier: Modifier = Modifier,
    animes: List<Data>,
    onClick: (Data) -> Unit
) {
    if (animes.isEmpty()) {
        EmptyScreen()
    }
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(MediumPadding1),
        contentPadding = PaddingValues(all = ExtraSmallPadding2)
    ) {
        items(
            count = animes.size,
        ) {
            animes[it]?.let { anime ->
                AnimeListTile(
                    animeData = anime,)
//                    onClick = { onClick(ainme) })
            }
        }
    }

}

@Composable
fun AnimeList(
    modifier: Modifier = Modifier,
    animes: LazyPagingItems<Data>,
    onClick: (Data) -> Unit
) {

    val handlePagingResult = handlePagingResult(animes)


    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallPadding2)
        ) {
            items(
                count = animes.itemCount,
            ) {
                animes[it]?.let { anime ->
                    AnimeListTile(
                        animeData = anime,
//                        onClick = { onClick(anime) }
                    )
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(animes: LazyPagingItems<Data>): Boolean {
    val loadState = animes.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen(error = error)
            false
        }

        else -> {
            true
        }
    }
}

@Composable
fun ShimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding1)) {
        repeat(10) {
            AnimeCardShimmerEffect(
                modifier = Modifier.padding(horizontal = MediumPadding1)
            )
        }
    }
}