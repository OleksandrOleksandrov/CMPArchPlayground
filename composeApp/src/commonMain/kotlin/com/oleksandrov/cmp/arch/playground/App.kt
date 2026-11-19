package com.oleksandrov.cmp.arch.playground

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme

@Composable
fun App() {
    AppTheme(
        useDarkTheme = isSystemInDarkTheme(),
    ) {
        NavigationRoot(
            modifier = Modifier,
        )
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//        ) {
//            Box(
//                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(Theme.corner.corner24))
//                    .background(Theme.color.themeBColor.b1000),
//                contentAlignment = Alignment.Center
//            ) {}
//
//            PrivacyText(modifier = Modifier, text = viewModel.getString())
//        }
    }
}