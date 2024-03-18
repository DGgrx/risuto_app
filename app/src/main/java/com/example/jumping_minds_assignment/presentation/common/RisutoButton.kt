package com.example.jumping_minds_assignment.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jumping_minds_assignment.ui.theme.Jumping_minds_assignmentTheme

@Composable
fun RisutoButton(
    text: String,
    onclick: () -> Unit
) {
    Button(onClick = onclick) {
        Text(text = text)
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
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RisutoButtonPreview() {
    Jumping_minds_assignmentTheme {
        Row(){
            RisutoButton(text = "Next") {

            }
            RisotuTextButton(text = "Back") {}
        }
    }
}