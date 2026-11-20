package com.oleksandrov.cmp.arch.playground.presentation.core.ui.component

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
    ) {
        Text(
            text = text,
            style = Theme.typography.ctaMedium03,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
@Preview
private fun PrimaryButtonPreviewEnabled() {
    AppTheme {
        PrimaryButton(
            modifier = Modifier,
            text = "Primary Button",
            onClick = {},
        )
    }
}

@Composable
@Preview
private fun PrimaryButtonPreviewDisabled() {
    AppTheme {
        PrimaryButton(
            modifier = Modifier,
            enabled = false,
            text = "Primary Button",
            onClick = {},
        )
    }
}
