package com.oleksandrov.cmp.arch.playground.loading.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.oleksandrov.cmp.arch.playground.domain.epic.usecase.UpdateEPICUseCase
import com.oleksandrov.cmp.arch.playground.loading.screen.contract.PartialStateChange
import com.oleksandrov.cmp.arch.playground.loading.screen.contract.ViewEvent
import com.oleksandrov.cmp.arch.playground.loading.screen.contract.ViewIntent
import com.oleksandrov.cmp.arch.playground.loading.screen.contract.ViewState
import com.oleksandrov.cmp.arch.playground.presentation.core.platform.base.viewmodel.BaseMviViewModel
import com.oleksandrov.cmp.arch.playground.presentation.core.platform.ext.stateWhileSubscribed
import com.oleksandrov.cmp.arch.playground.string.res.Res
import com.oleksandrov.cmp.arch.playground.string.res.error_no_internet_connection
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.transformLatest
import org.jetbrains.compose.resources.getString

internal class LoadingScreenViewModel(
    private val updateEPICUseCase: UpdateEPICUseCase,
    savedStateHandle: SavedStateHandle,
//    stateSaver: ViewState.StateSaver,
) : BaseMviViewModel<ViewIntent, ViewState, ViewEvent>() {
    override val viewState: StateFlow<ViewState>

    init {
        val initialState = ViewState()

        viewState = intentFlow
            .onStart {
                emit(ViewIntent.OnStartIntent)
            }
            .toPartialStateChange()
            .onEach {
                it.toSingleEventOrNull()?.also { event -> sendEvent(event) }
            }.scan(initialState) { state, change -> change.reduce(state) }
            .stateWhileSubscribed(viewModelScope, initialState)

//        savedStateHandle.setSavedStateProvider(VIEW_STATE_BUNDLE_KEY) {
//            stateSaver.run { viewState.value.toBundle() }
//        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun Flow<ViewIntent>.toPartialStateChange(): Flow<PartialStateChange> {
        val onStartFlow = filterIsInstance<ViewIntent.OnStartIntent>()
            .transformLatest { _ ->
                updateEPICUseCase()
                    .onSuccess { _ ->
                        emit(PartialStateChange.Navigation.NavigateToList)
                    }.onFailure { exception ->
                        emit(PartialStateChange.Data.SetError(getString(Res.string.error_no_internet_connection)))
                    }
            }

        val onReloadFlow = filterIsInstance<ViewIntent.OnReloadIntent>()
            .transformLatest { _ ->
                emit(PartialStateChange.Data.Retry)
                updateEPICUseCase()
                    .onSuccess { _ ->
                        emit(PartialStateChange.Navigation.NavigateToList)
                    }.onFailure { _ ->
                        emit(PartialStateChange.Data.SetError(getString(Res.string.error_no_internet_connection)))
                    }
            }

        return merge(
            onStartFlow,
            onReloadFlow,
        )
    }

    companion object {
        private const val VIEW_STATE_BUNDLE_KEY =
            "com.oleksandr.feature.loading.screen.screen.contract.view_state"

        private fun PartialStateChange.toSingleEventOrNull(): ViewEvent? = when (this) {
            is PartialStateChange.Navigation.NavigateToList -> ViewEvent.NavigateToList
            is PartialStateChange.Data.SetError -> ViewEvent.ShowError(errorMessage)
            else -> null
        }
    }
}