package com.oleksandrov.cmp.arch.playground.epic.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.oleksandrov.cmp.arch.playground.epic.navigation.EpicScreenAction
import com.oleksandrov.cmp.arch.playground.epic.screen.contract.ViewEvent
import com.oleksandrov.cmp.arch.playground.presentation.core.platform.composable.rememberFlowWithLifecycle
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EPICScreen(
    onAction: (EpicScreenAction) -> Unit
) {

    val scope = rememberCoroutineScope()
    val viewModel: EPICViewModel = koinViewModel()
    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val eventFlow = rememberFlowWithLifecycle(viewModel.singleEvent)

    LaunchedEffect(eventFlow) {
        eventFlow.collect { event ->
            when (event) {
                is ViewEvent.ShowError -> {
                    // Handle error, e.g., show a snackbar or dialog
                }

                is ViewEvent.NavigateToEpicDetails -> onAction(EpicScreenAction.GoToDetailsAction)
            }
        }
    }

    EPICContent(
        modifier = Modifier,
        state = state,
        onIntent = {
            scope.launch {
                viewModel.processIntent(it)
            }
        }
    )
}