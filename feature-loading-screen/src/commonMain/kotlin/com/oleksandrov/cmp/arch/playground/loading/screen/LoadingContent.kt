package com.oleksandrov.cmp.arch.playground.loading.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.oleksandrov.cmp.arch.playground.loading.screen.composable.ErrorView
import com.oleksandrov.cmp.arch.playground.loading.screen.composable.LoadingView
import com.oleksandrov.cmp.arch.playground.loading.screen.contract.ViewIntent
import com.oleksandrov.cmp.arch.playground.loading.screen.contract.ViewState

@Composable
internal fun LoadingContent(
    modifier: Modifier,
    state: ViewState,
    onIntent: (ViewIntent) -> Unit = {},
) {

    with(state) {
        if (error != null) {
            ErrorView(
                modifier = modifier.testTag("tag_error_view"),
                errorUiModel = error,
                onRetry = {
                    onIntent(ViewIntent.OnReloadIntent)
                },
            )
        } else {
            LoadingView(modifier = modifier.testTag("tag_loading_view"))
        }
    }
}
