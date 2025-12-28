package com.oleksandrov.cmp.arch.playground.epic.details.screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme

@Composable
fun EmptyEpicDetails(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Empty.Empty?.let {
            Image(
                imageVector = it,
                modifier = Modifier,
                contentDescription = "Empty icon" // TODO replace with res
            )
        }

        Text(
            text = "Noting  selected", // TODO replace with res
            style = Theme.typography.titleBold03,
        )
    }
}

@Composable
@Preview
private fun EmptyEpicDetailsPreview() {
    AppTheme {
        Box(
            modifier = Modifier.background(Color.White)
        ) {
            EmptyEpicDetails()
        }
    }
}
