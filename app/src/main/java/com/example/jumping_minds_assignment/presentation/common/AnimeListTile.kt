package com.example.jumping_minds_assignment.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jumping_minds_assignment.R
import com.example.jumping_minds_assignment.domain.models.Anime
import com.example.jumping_minds_assignment.presentation.Dimens.MediumPadding1
import com.example.jumping_minds_assignment.ui.theme.Jumping_minds_assignmentTheme

@Composable
fun AnimeListTile(
    modifier: Modifier = Modifier,
    animeData: Anime,
    onClick: (() -> Unit)? = null
) {

    val title = animeData.title ?: ""
    val year = animeData.year?.toString() ?: ""
    val region = animeData.broadcast?.timezone?.split('/')?.get(1) ?: ""
    val genres = animeData.genres?.joinToString(separator = ",") { it.name } ?: ""
    val imageUrl = animeData.images?.webp?.large_image_url ?: ""


    Row(modifier = modifier.clickable {
        if (onClick != null) {
            onClick()
        }
    }) {
        AsyncImage(
            modifier = Modifier
                .width(140.dp)
//                .border(
//                    border = BorderStroke(width = 0.dp, color = Color.Transparent),
//                    shape = RoundedCornerShape(10.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(MediumPadding1 / 2))
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                maxLines = 2,
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(9.dp))

            Text(
                maxLines = 1,
                text = "$year | $region",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(9.dp))
            Text(
                modifier = Modifier,
                maxLines = 2,
                softWrap = true,
                overflow = TextOverflow.Clip,
                text = "Genre: $genres",
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = Modifier.height(5.dp))

            RisutoButton(
                icon = R.drawable.favourite_marked,
                text = "My List"
            ) {

            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun AnimeListTilePreview() {
    Jumping_minds_assignmentTheme {
//        AnimeListTile() {}
    }
}