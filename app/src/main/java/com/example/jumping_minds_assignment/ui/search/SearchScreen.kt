package com.example.jumping_minds_assignment.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.jumping_minds_assignment.ui.Dimens.MediumPadding1
import com.example.jumping_minds_assignment.ui.common.AnimeList
import com.example.jumping_minds_assignment.ui.common.SearchBar

@Composable
fun SearchScreen(
    searchState: SearchState,
    event: (SearchEvent)->Unit
) {
    Column(
        modifier = Modifier
            .padding(top = MediumPadding1, start = MediumPadding1, end = MediumPadding1)
            .statusBarsPadding()
    ) {
        SearchBar(
            text = searchState.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = {
                event(SearchEvent.SearchAnime)
            }
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        searchState.animes?.let {
            val animes = it.collectAsLazyPagingItems()
            AnimeList(
                animes = animes,
                onClick = {}
            )
        }
    }
}