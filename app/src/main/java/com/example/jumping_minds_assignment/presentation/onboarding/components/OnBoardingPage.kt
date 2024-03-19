package com.example.jumping_minds_assignment.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.jumping_minds_assignment.R
import com.example.jumping_minds_assignment.presentation.Dimens.HorizontalPadding1
import com.example.jumping_minds_assignment.presentation.Dimens.MediumPadding1
import com.example.jumping_minds_assignment.presentation.onboarding.Page

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(
        modifier = modifier
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.55f),
            painter = painterResource(id = page.image),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .padding(horizontal = HorizontalPadding1)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center,
            text = page.title,
            color = colorResource(id = R.color.display_small)
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            modifier = Modifier
                .padding(horizontal = HorizontalPadding1)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            text = page.description,
            color = colorResource(id = R.color.display_small)
        )
    }
}