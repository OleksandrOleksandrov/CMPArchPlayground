package com.oleksandrov.cmp.arch.playground

import androidx.compose.runtime.Composable
import com.oleksandrov.cmp.arch.playground.epic.screen.EPICScreen
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val viewModel = koinViewModel<AppViewModel>()
    AppTheme {
        EPICScreen(
            onAction = { epicUiModel ->
            }
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