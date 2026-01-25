package com.oleksandrov.cmp.arch.playground.epic.details.screen

import androidx.lifecycle.viewModelScope
import com.oleksandrov.cmp.arch.playground.epic.details.screen.contract.PartialStateChange
import com.oleksandrov.cmp.arch.playground.domain.epic.mapper.EPICDomainUiModelMapper
import com.oleksandrov.cmp.arch.playground.domain.epic.usecase.GetEPICItemByIdUseCase
import com.oleksandrov.cmp.arch.playground.epic.details.screen.contract.ViewEvent
import com.oleksandrov.cmp.arch.playground.epic.details.screen.contract.ViewIntent
import com.oleksandrov.cmp.arch.playground.epic.details.screen.contract.ViewState
import com.oleksandrov.cmp.arch.playground.presentation.core.platform.base.viewmodel.BaseMviViewModel
import com.oleksandrov.cmp.arch.playground.presentation.core.platform.ext.stateWhileSubscribed
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.transformLatest

internal class EpicDetailsViewModel(
    private val getEPICItemByIdUseCase: GetEPICItemByIdUseCase,
//    savedStateHandle: SavedStateHandle,
) : BaseMviViewModel<ViewIntent, ViewState, ViewEvent>() {

    override val viewState: StateFlow<ViewState>

    init {
        val initialState = ViewState()

        viewState = intentFlow
            .toPartialStateChange()
            .onEach {
                it.toSingleEventOrNull()?.also { event -> sendEvent(event) }
            }
            .scan(initialState) { state, change -> change.reduce(state) }
            .stateWhileSubscribed(viewModelScope, initialState)

//        savedStateHandle.setSavedStateProvider(VIEW_STATE_BUNDLE_KEY) {
//            stateSaver.run { viewState.value.toBundle() }
//        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun Flow<ViewIntent>.toPartialStateChange(): Flow<PartialStateChange> {
        val onStartFlow = filterIsInstance<ViewIntent.OnStartIntent>()
            .transformLatest { start ->
                getEPICItemByIdUseCase(start.id).onSuccess { item ->
                    emit(PartialStateChange.EpicData.SetData(item?.let {
                        EPICDomainUiModelMapper.mapTo(
                            it
                        )
                    }))
                }
            }

        return merge(
            onStartFlow,
        )
    }

    companion object {
        private const val VIEW_STATE_BUNDLE_KEY =
            "com.oleksandr.epic.details.screen.contract.view_state"

        private fun PartialStateChange.toSingleEventOrNull(): ViewEvent? = null
    }
}