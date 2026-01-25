package com.oleksandrov.cmp.arch.playground.epic.details.screen

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.oleksandrov.cmp.arch.playground.epic.details.screen.contract.ViewIntent
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EpicDetailsScreen(
    modifier: Modifier = Modifier,
    identifier: String,
) {

    val viewModel: EpicDetailsViewModel = koinViewModel()
    val state = viewModel.viewState.collectAsStateWithLifecycle()

    val scope = rememberCoroutineScope()

    LaunchedEffect(identifier) {
        scope.launch { 
            viewModel.processIntent(ViewIntent.OnStartIntent(identifier))
        }
    }

    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = Theme.color.themeNColor.n50,
    ) { scaffoldPaddingValues ->
        EpicDetailsContent(
            modifier = Modifier.padding(scaffoldPaddingValues),
            state = state.value,
        )
    }
}