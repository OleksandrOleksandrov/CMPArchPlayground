package com.oleksandrov.cmp.arch.playground.loading.screen.contract

import com.oleksandrov.cmp.arch.playground.loading.model.ErrorUiModel


internal sealed interface PartialStateChange {
    fun reduce(state: ViewState): ViewState

    sealed interface Navigation :
        PartialStateChange {
        override fun reduce(state: ViewState): ViewState = state

        data object NavigateToList : Navigation
    }

    sealed interface Data : PartialStateChange {
        data class SetError(val errorMessage: String) : Data
        data object Retry : Data

        override fun reduce(state: ViewState): ViewState {
            return when (this) {
                is SetError -> state.copy(isLoading = false, error = ErrorUiModel(errorMessage))
                Retry -> state.copy(isLoading = true, error = null)
            }
        }
    }
}
