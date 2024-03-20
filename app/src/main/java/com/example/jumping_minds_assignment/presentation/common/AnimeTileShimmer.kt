package com.example.jumping_minds_assignment.presentation.common

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.jumping_minds_assignment.R
import com.example.jumping_minds_assignment.presentation.Dimens.MediumPadding1


fun Modifier.shimmerEffect(cornerRadius: CornerRadius = CornerRadius(x = 12f, y = 12f)) = composed {
    val transition = rememberInfiniteTransition(label = "shimmer effect")
    val alpha = transition.animateFloat(
        initialValue = 0.2f, targetValue = 0.9f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000), repeatMode = RepeatMode.Reverse
        ), label = "transparency of the background color"
    ).value
    val color = colorResource(id = R.color.shimmer).copy(alpha = alpha)
    drawBehind {
        drawRoundRect(
            color = color, cornerRadius = cornerRadius
        )
    }
}

@Composable
fun AnimeCardShimmerEffect(modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .height(120.dp)
                .width(100.dp)
                .shimmerEffect(),
        )
        Column() {
            Box(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(horizontal = MediumPadding1)
                    .shimmerEffect(),

                )
            Spacer(modifier = Modifier.height(9.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(15.dp)
                    .padding(horizontal = MediumPadding1)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(9.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(30.dp)
                    .padding(horizontal = MediumPadding1)
                    .shimmerEffect(),
            )
            Spacer(modifier = Modifier.height(5.dp))

        }
    }
}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true, showSystemUi = true)
//@Composable
//fun AnimeCardShimmerEffectPreview() {
//    Jumping_minds_assignmentTheme {
//        AnimeCardShimmerEffect()
//    }
//}