package com.oleksandrov.cmp.arch.playground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val viewModel = koinViewModel<AppViewModel>()
    AppTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(Theme.corner.corner24))
                    .background(Theme.color.themeBColor.b1000),
                contentAlignment = Alignment.Center
            ) {}

            PrivacyText(modifier = Modifier, text = viewModel.getString())
        }

    }
}