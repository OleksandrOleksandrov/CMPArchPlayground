package com.oleksandrov.cmp.arch.playground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    AppTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                "Compose Multiplatform Playground",
                modifier = Modifier.fillMaxWidth().padding(Theme.spacing.space16),
                style = Theme.typography.bodyMedium03,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
            Box(
                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(Theme.corner.corner24))
                    .background(Theme.color.themeBColor.b1000),
                contentAlignment = Alignment.Center
            ) {
            }
        }

    }
}