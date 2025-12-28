package com.oleksandrov.cmp.arch.playground.epic.details.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.oleksandrov.cmp.arch.playground.epic.details.screen.composable.EpicDetailsView
import com.oleksandrov.cmp.arch.playground.epic.details.screen.contract.ViewIntent
import com.oleksandrov.cmp.arch.playground.epic.details.screen.contract.ViewState

@Composable
internal fun EpicDetailsContent(
    modifier: Modifier,
    state: ViewState,
    onIntent: (ViewIntent) -> Unit = {},
) {

    with(state) {
        state.epicUiModel?.let {
            EpicDetailsView(
                modifier = modifier,
                model = state.epicUiModel,
            )
        }
    }
}
