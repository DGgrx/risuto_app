package com.example.jumping_minds_assignment.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jumping_minds_assignment.domain.models.Anime
import com.example.jumping_minds_assignment.ui.Dimens.AnimeTileWidth
import com.example.jumping_minds_assignment.ui.Dimens.ExtraSmallPadding
import com.example.jumping_minds_assignment.ui.Dimens.MediumPadding1

@Composable
fun AnimeListTile(
    modifier: Modifier = Modifier,
    animeData: Anime,
    onClick: (() -> Unit)? = null
) {

    val title = animeData.title ?: ""
    val year = animeData.year?.toString() ?: ""
//    val region = animeData.broadcast?.timezone?.split('/')?.get(1) ?: ""
    val genres = animeData.genres?.joinToString(separator = ",") { it.name ?: "" } ?: ""
    val imageUrl = animeData.images?.webp?.large_image_url ?: ""


    Row(modifier = modifier.clickable {
        if (onClick != null) {
            onClick()
        }
    }) {
        Box {
            AsyncImage(
                modifier = Modifier
                    .width(AnimeTileWidth)
                    .clip(RoundedCornerShape(10.dp)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            animeData.score?.let {
                AssistChip(
                    modifier = Modifier.padding(horizontal = 5.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        labelColor = MaterialTheme.colorScheme.inversePrimary
                    ),
                    border = AssistChipDefaults.assistChipBorder(
                        borderWidth = 0.dp
                    ),
                    enabled = true,
                    onClick = { },
                    label = { Text(it.toString(), style = MaterialTheme.typography.labelSmall) })
            }

        }
        Spacer(modifier = Modifier.width(MediumPadding1 / 2))
        Column(
            modifier = Modifier.height(210.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                maxLines = 2,
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(9.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                if (year.isNotEmpty()) {
                    Text(
                        maxLines = 1,
                        text = "$year ",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
//                if (region.isNotEmpty()) {
//                    Text(
//                        maxLines = 1,
//                        text = "| $region",
//                        style = MaterialTheme.typography.bodyLarge
//                    )
//                }
            }

            Spacer(modifier = Modifier.height(9.dp))
            Text(
                modifier = Modifier,
                maxLines = 2,
                softWrap = true,
                overflow = TextOverflow.Clip,
                text = "Genre: $genres",
                style = MaterialTheme.typography.labelMedium
            )

            animeData.duration?.let { Text(text = it) }
            Spacer(modifier = Modifier.height(ExtraSmallPadding))
            animeData.status?.let { AssistChip(onClick = { }, label = { Text(text = it) }) }
        }
    }

}