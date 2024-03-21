package com.example.jumping_minds_assignment.ui.details

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jumping_minds_assignment.R
import com.example.jumping_minds_assignment.domain.models.Anime
import com.example.jumping_minds_assignment.ui.Dimens.AnimeTileWidth
import com.example.jumping_minds_assignment.ui.Dimens.ExtraSmallPadding3
import com.example.jumping_minds_assignment.ui.details.components.DetailsScreenAppBar
import com.example.jumping_minds_assignment.utils.UIComponent

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AnimeDetailsScreen(
    anime: Anime,
    event: (AnimeDetailsEvent) -> Unit,
    sideEffect: UIComponent?,
    navigateUp: () -> Unit
) {


    val context = LocalContext.current

    LaunchedEffect(key1 = sideEffect) {
        sideEffect?.let {
            when (sideEffect) {
                is UIComponent.Toast -> {
                    Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()
                    event(AnimeDetailsEvent.RemoveSideEffect)
                }

                else -> Unit
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailsScreenAppBar(
            onFavouriteClicked = {
                event(AnimeDetailsEvent.FavouriteAnime(anime))
            },
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(anime.url)
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            }, onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(
                        Intent.EXTRA_TEXT, anime.url
                    )
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onBackClick = navigateUp
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            item {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(anime.trailer?.images?.maximum_image_url).build(),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.height(ExtraSmallPadding3))

                anime.title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }

                anime.title_japanese?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {

                    anime.score.let {
                        Icon(
                            modifier = Modifier.padding(ExtraSmallPadding3),
                            painter = painterResource(id = R.drawable.ic_favourite_marked),
                            contentDescription = null
                        )

                        Text(text = it.toString())
                    }



                    anime.year.let {
                        Icon(
                            modifier = Modifier.padding(ExtraSmallPadding3),
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = null
                        )
                        Text(text = it.toString())
                    }


                }
                FlowRow() {
                    anime.status?.let {
                        AssistChip(
                            enabled = false,
                            onClick = {},
                            label = { Text(text = it) })
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    anime.rating?.let {
                        AssistChip(
                            enabled = false,
                            onClick = {},
                            label = { Text(text = it) })
                    }
                }


                Spacer(modifier = Modifier.height(ExtraSmallPadding3))


                anime?.episodes?.let { Text(text = "Number of episodes : ${it}") }

                Spacer(modifier = Modifier.height(ExtraSmallPadding3))


                Row(
                    modifier = Modifier
                        .height(210.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    anime.images?.webp?.large_image_url.let {
                        AsyncImage(
                            modifier = Modifier
                                .width(AnimeTileWidth)
                                .clip(RoundedCornerShape(10.dp)),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(it).build(),
                            contentDescription = null
                        )
                    }
                    FlowRow(
                        modifier = Modifier.height(210.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalArrangement = Arrangement.spacedBy(3.dp),
//                        verticalAlignment = Alignment.Top,
                        maxItemsInEachRow = 3

                    ) {

                        anime.genres?.map { genre ->
                            AssistChip(
                                modifier = Modifier.padding(horizontal = 2.dp),
                                onClick = {}, label = { genre.name?.let { Text(it) } })
                        }
                    }

                }
                Spacer(modifier = Modifier.height(ExtraSmallPadding3))

                Text(
                    text = "Details ",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )

                Spacer(modifier = Modifier.height(ExtraSmallPadding3))


                anime.synopsis?.let { Text(text = it) }
                Spacer(modifier = Modifier.height(ExtraSmallPadding3))

            }
        }
    }

}
