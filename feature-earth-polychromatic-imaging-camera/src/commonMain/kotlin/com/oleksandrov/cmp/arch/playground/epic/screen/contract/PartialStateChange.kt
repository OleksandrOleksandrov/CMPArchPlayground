package com.oleksandrov.cmp.arch.playground.epic.screen.contract

import com.oleksandrov.cmp.arch.playground.epic.model.EpicUiModel

internal sealed interface PartialStateChange {
    fun reduce(state: ViewState): ViewState

    sealed interface EpicList : PartialStateChange {
        data class SetData(
            val list: List<EpicUiModel>,
        ) : EpicList

        data object SetError: EpicList

        override fun reduce(state: ViewState): ViewState = when (this) {
            is SetData -> state.copy(
                isProcessing = false,
                epicList = list,
            )

            SetError -> state.copy(
                isProcessing = false,
                isListLoadingError = true,
            )
        }
    }

    sealed interface Navigation : PartialStateChange {
        override fun reduce(state: ViewState): ViewState = state

        data class NavigateToDetails(
            val model: EpicUiModel,
        ) : Navigation
    }
}
