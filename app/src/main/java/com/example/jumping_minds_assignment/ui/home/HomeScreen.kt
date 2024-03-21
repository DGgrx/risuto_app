package com.example.jumping_minds_assignment.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.jumping_minds_assignment.R
import com.example.jumping_minds_assignment.domain.models.Anime
import com.example.jumping_minds_assignment.ui.Dimens.MediumPadding1
import com.example.jumping_minds_assignment.ui.common.AnimeList
import com.example.jumping_minds_assignment.ui.common.SearchBar

@Composable
fun HomeScreen(
    animes: LazyPagingItems<Anime>,
    state: HomeState,
    event: (HomeEvent) -> Unit,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Anime) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1 / 2)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_icon),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = MediumPadding1)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        SearchBar(
            modifier = Modifier
                .padding(horizontal = MediumPadding1)
                .fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = navigateToSearch
        )

        Spacer(modifier = Modifier.height(MediumPadding1 / 2))

        Spacer(modifier = Modifier.height(MediumPadding1))

        AnimeList(
            modifier = Modifier.padding(horizontal = MediumPadding1 / 3),
            animes = animes,
            onClick = navigateToDetails
        )
    }
}