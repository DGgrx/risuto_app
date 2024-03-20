package com.example.jumping_minds_assignment.ui.details.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jumping_minds_assignment.R
import com.example.jumping_minds_assignment.ui.theme.Jumping_minds_assignmentTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreenAppBar(
    onBrowsingClick: () -> Unit,
    onShareClick: () -> Unit,
    onFavouriteClick: () -> Unit,
    onBackClick: () -> Unit,
) {

    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(id = R.color.body),
            navigationIconContentColor = colorResource(id = R.color.body),
        ),
        title = {},
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = null,
                )
            }
        },
        actions = {

            IconButton(onClick = onFavouriteClick) {
                Icon(

                    painter = painterResource(id = R.drawable.ic_favourite_marked),
                    contentDescription = null
                )
            }
            IconButton(onClick = onShareClick) {
                Icon(

                    imageVector = Icons.Default.Share,
                    contentDescription = null
                )
            }
            IconButton(onClick = onBrowsingClick) {
                Icon(

                    painter = painterResource(id = R.drawable.ic_browse),
                    contentDescription = null
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailsScreenAppBarPreview() {
    Jumping_minds_assignmentTheme() {
        DetailsScreenAppBar(
            onShareClick = { /*TODO*/ },
            onFavouriteClick = { /*TODO*/ },
            onBrowsingClick = {}) {

        }
    }
}