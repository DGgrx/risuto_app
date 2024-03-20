package com.example.jumping_minds_assignment.presentation.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.jumping_minds_assignment.presentation.Dimens.HorizontalPadding2

@Composable
fun RisutoButton(
    modifier: Modifier = Modifier,
    icon: Int? = null,
    text: String,
    onclick: () -> Unit
) {
    Button(modifier = modifier,onClick = onclick) {


        Row(verticalAlignment = Alignment.CenterVertically) {
            if (icon != null) Icon(
                modifier = Modifier.size(HorizontalPadding2),
                painter = painterResource(id = icon),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(HorizontalPadding2/2))
            Text(text = text)
        }
    }

}

@Composable
fun RisotuTextButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(onClick = onClick) {
        Text(text = text)
    }
}
