package com.oleksandrov.cmp.arch.playground.loading.screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.oleksandrov.cmp.arch.playground.loading.screen.contract.ViewEvent
import com.oleksandrov.cmp.arch.playground.presentation.core.platform.composable.rememberFlowWithLifecycle
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
    onAction: () -> Unit,
) {

    val scope = rememberCoroutineScope()
    val viewModel: LoadingScreenViewModel = koinViewModel()
    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val eventFlow = rememberFlowWithLifecycle(viewModel.singleEvent)

    LaunchedEffect(eventFlow) {
        eventFlow.collect { event ->
            when (event) {
                is ViewEvent.ShowError -> {
                    // Handle error, e.g., show a snackbar or dialog
                }
                is ViewEvent.NavigateToList -> onAction()
            }
        }
    }

    Scaffold(
        modifier = modifier,
        containerColor = Theme.color.themeNColor.n50,
        contentWindowInsets = WindowInsets(0),
    ) { scaffoldPaddingValues ->
        LoadingContent(
            modifier = Modifier.padding(scaffoldPaddingValues),
            state = state,
            onIntent = { scope.launch { viewModel.processIntent(it) } },
        )
    }
}