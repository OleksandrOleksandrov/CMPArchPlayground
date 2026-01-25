package com.oleksandrov.cmp.arch.playground

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.oleksandrov.cmp.arch.playground.core.navigation.BaseNavigationDirection
import com.oleksandrov.cmp.arch.playground.epic.details.screen.EpicDetailsScreen
import com.oleksandrov.cmp.arch.playground.epic.navigation.EpicScreenAction
import com.oleksandrov.cmp.arch.playground.epic.screen.EPICScreen
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val viewModel = koinViewModel<AppViewModel>()
    val navHostController = rememberNavController()
    AppTheme {
        NavHost(
            navController = navHostController,
            startDestination = BaseNavigationDirection.EPIC,
        ) {
            composable<BaseNavigationDirection.EPIC> {
                EPICScreen(
                    onAction = { epicUiModel ->
                        navHostController.navigate(BaseNavigationDirection.EpicDetails((epicUiModel as EpicScreenAction.GoToDetailsAction).id))
                    }
                )
            }
            composable<BaseNavigationDirection.EpicDetails> {
                (it.toRoute() as BaseNavigationDirection.EpicDetails).identifier?.let { identifier ->
                    EpicDetailsScreen(
                        modifier = Modifier,
                        identifier = identifier,
                    )
                }
            }
        }
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