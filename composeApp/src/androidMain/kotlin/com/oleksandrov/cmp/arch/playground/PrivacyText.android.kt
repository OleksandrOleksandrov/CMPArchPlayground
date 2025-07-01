package com.oleksandrov.cmp.arch.playground

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.PrivacyEffect
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.privacySensitive

@Composable
actual fun PrivacyText(modifier: Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier
            .fillMaxWidth()
            .padding(Theme.spacing.space16)
            .privacySensitive(
                PrivacyEffect.Blur(15.dp)
            ),
        style = Theme.typography.bodyMedium03,
        textAlign = androidx.compose.ui.text.style.TextAlign.Center
    )
}