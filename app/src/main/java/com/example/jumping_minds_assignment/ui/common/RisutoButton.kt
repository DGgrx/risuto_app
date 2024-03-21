package com.example.jumping_minds_assignment.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jumping_minds_assignment.ui.Dimens.HorizontalPadding2
import com.example.jumping_minds_assignment.ui.theme.Jumping_minds_assignmentTheme

@Composable
fun RisutoButton(
    modifier: Modifier = Modifier,
    icon: Int? = null,
    text: String,
    onclick: () -> Unit
) {
    Button(modifier = modifier,onClick = onclick) {


        Row(verticalAlignment = Alignment.CenterVertically) {
            if (icon != null) {
                Icon(
                    modifier = Modifier.size(HorizontalPadding2),
                    painter = painterResource(id = icon),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(HorizontalPadding2/2))
            }

            Text(text = text)
        }
    }

}

@Composable
fun RisutoButtonUnselected(
    modifier: Modifier = Modifier,
    icon: Int? = null,
    text: String,
    onclick: () -> Unit
) {
    OutlinedButton(modifier = modifier,onClick = onclick) {


        Row(verticalAlignment = Alignment.CenterVertically) {
            if (icon != null) {
                Icon(
                    modifier = Modifier.size(HorizontalPadding2),
                    painter = painterResource(id = icon),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(HorizontalPadding2/2))
            }

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

@Preview
@Composable
fun RisutoButtonPreview() {
    Jumping_minds_assignmentTheme {
        Column(){
            RisutoButton(text = "My List") {

            }
            RisutoButtonUnselected(text = "Remove From List") {

            }
        }
    }
}
