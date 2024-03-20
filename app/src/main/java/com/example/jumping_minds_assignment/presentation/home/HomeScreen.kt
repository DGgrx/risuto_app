package com.example.jumping_minds_assignment.presentation.home

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
import com.example.jumping_minds_assignment.domain.models.Data
import com.example.jumping_minds_assignment.presentation.Dimens.MediumPadding1
import com.example.jumping_minds_assignment.presentation.common.AnimeList
import com.example.jumping_minds_assignment.presentation.common.SearchBar

@Composable
fun HomeScreen(
    animes: LazyPagingItems<Data>,
//    state: HomeState,
//    event: (HomeEvent) -> Unit,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Data) -> Unit
) {

//    val titles by remember {
//        derivedStateOf {
//            if (articles.itemCount > 10) {
//                articles.itemSnapshotList.items
//                    .slice(IntRange(start = 0, endInclusive = 9))
//                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
//            } else {
//                ""
//            }
//        }
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1/2)
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

        Spacer(modifier = Modifier.height(MediumPadding1/2))

//        val scrollState = rememberScrollState(initial = state.scrollValue)

//        Text(
//            text = titles, modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = MediumPadding1)
//                .horizontalScroll(scrollState, enabled = false),
//            fontSize = 12.sp,
//            color = colorResource(id = R.color.placeholder)
//        )

        // Update the maxScrollingValue
//        LaunchedEffect(key1 = scrollState.maxValue) {
//            event(HomeEvent.UpdateMaxScrollingValue(scrollState.maxValue))
//        }
//        // Save the state of the scrolling position
//        LaunchedEffect(key1 = scrollState.value) {
//            event(HomeEvent.UpdateScrollValue(scrollState.value))
//        }
//        // Animate the scrolling
//        LaunchedEffect(key1 = state.maxScrollingValue) {
//            delay(500)
//            if (state.maxScrollingValue > 0) {
//                scrollState.animateScrollTo(
//                    value = state.maxScrollingValue,
//                    animationSpec = infiniteRepeatable(
//                        tween(
//                            durationMillis = (state.maxScrollingValue - state.scrollValue) * 50_000 / state.maxScrollingValue,
//                            easing = LinearEasing,
//                            delayMillis = 1000
//                        )
//                    )
//                )
//            }
//        }

        Spacer(modifier = Modifier.height(MediumPadding1))

        AnimeList(
            modifier = Modifier.padding(horizontal = MediumPadding1/3),
            animes = animes,
            onClick = navigateToDetails
        )
    }
}