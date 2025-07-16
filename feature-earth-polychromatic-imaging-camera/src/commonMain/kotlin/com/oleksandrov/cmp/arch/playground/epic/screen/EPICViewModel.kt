package com.oleksandrov.cmp.arch.playground.epic.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.oleksandrov.cmp.arch.playground.domain.epic.usecase.UpdateEPICUseCase
import com.oleksandrov.cmp.arch.playground.epic.mapper.EPICDomainUiModelMapper
import com.oleksandrov.cmp.arch.playground.epic.screen.contract.PartialStateChange
import com.oleksandrov.cmp.arch.playground.epic.screen.contract.ViewEvent
import com.oleksandrov.cmp.arch.playground.epic.screen.contract.ViewIntent
import com.oleksandrov.cmp.arch.playground.epic.screen.contract.ViewState
import com.oleksandrov.cmp.arch.playground.presentation.core.platform.base.viewmodel.BaseMviViewModel
import com.oleksandrov.cmp.arch.playground.presentation.core.platform.ext.stateWhileSubscribed
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.transformLatest

internal class EPICViewModel(
    private val updateEPICUseCase: UpdateEPICUseCase,
//    savedStateHandle: SavedStateHandle,
) : BaseMviViewModel<ViewIntent, ViewState, ViewEvent>() {

    override val viewState: StateFlow<ViewState>

    val state = MutableStateFlow("State.New")

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
        val initFlow = filterIsInstance<ViewIntent.OnStartIntent>()
            .transformLatest { intent ->
                updateEPICUseCase()
                    .onSuccess { list ->
                        val uiList = list?.let(EPICDomainUiModelMapper::mapListTo) ?: emptyList()
                        emit(PartialStateChange.EpicList.SetData(uiList))
                    }.onFailure { exception ->
                        emit(PartialStateChange.EpicList.SetError)
                    }
            }.catch { exception ->
                emit(PartialStateChange.EpicList.SetError)
            }

        val onEpicTappedFlow = filterIsInstance<ViewIntent.OnEpicItemTappedIntent>()
            .mapLatest { intent ->
                PartialStateChange.Navigation.NavigateToDetails(intent.model)
            }

        return merge(
            initFlow,
            onEpicTappedFlow,
        )
    }

    companion object {
        private const val VIEW_STATE_BUNDLE_KEY =
            "com.oleksandrov.cmp.arch.playground.epic.screen.view_state"

        private fun PartialStateChange.toSingleEventOrNull(): ViewEvent? = when (this) {
            is PartialStateChange.Navigation.NavigateToDetails -> ViewEvent.NavigateToEpicDetails(
                model
            )
            else -> null
        }
    }
}