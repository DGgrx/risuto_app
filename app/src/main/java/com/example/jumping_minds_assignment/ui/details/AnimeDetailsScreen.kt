package com.example.jumping_minds_assignment.ui.details

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jumping_minds_assignment.R
import com.example.jumping_minds_assignment.ui.common.RisutoButton
import com.example.jumping_minds_assignment.ui.details.components.DetailsScreenAppBar
import com.example.jumping_minds_assignment.ui.theme.Jumping_minds_assignmentTheme

@Composable
fun AnimeDetailsScreen(
//    anime : Anime,
    event: (AnimeDetailsEvent) -> Unit, navigateUp: () -> Unit
) {

    val context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()) {
        DetailsScreenAppBar(onBrowsingClick = {
            Intent(Intent.ACTION_VIEW).also {
                //                    it.data = Uri.parse(anime.url)
                it.data = Uri.parse("https://myanimelist.net/anime/52299/Ore_dake_Level_Up_na_Ken")
                if (it.resolveActivity(context.packageManager) != null) {
                    context.startActivity(it)
                }
            }
        }, onShareClick = {
            Intent(Intent.ACTION_SEND).also {
                it.putExtra(
                    Intent.EXTRA_TEXT,
                    "https://myanimelist.net/anime/52299/Ore_dake_Level_Up_na_Ken"
                )
                it.type = "text/plain"
                if (it.resolveActivity(context.packageManager) != null) {
                    context.startActivity(it)
                }
            }
        },
            onFavouriteClick = { event(AnimeDetailsEvent.favouriteAnime) },
            onBackClick = navigateUp
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                //        AsyncImage(model = Image, contentDescription = )

                Image(
                    painter = painterResource(id = R.drawable.test_trailer_image),
                    contentDescription = null
                )

                Text(text = "title of the anime")
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favourite_marked),
                        contentDescription = null
                    )
                    Text(text = "ratings")
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null
                    )
                    Text(text = "year")
                    AssistChip(enabled = false, onClick = {}, label = { Text(text = "13+") })
                }

                RisutoButton(modifier = Modifier.fillMaxWidth(), text = "Add To favourites") {}
                Text(text = "lorem ipsum")
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun AnimeDetailsScreenPreview() {
    Jumping_minds_assignmentTheme {
        AnimeDetailsScreen(event = { AnimeDetailsEvent.favouriteAnime }, navigateUp = {})
    }
}