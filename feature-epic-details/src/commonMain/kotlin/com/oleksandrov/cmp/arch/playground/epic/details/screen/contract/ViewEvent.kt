package com.oleksandrov.cmp.arch.playground.epic.details.screen.contract

import com.oleksandrov.cmp.arch.playground.presentation.core.platform.base.mvi.MviSingleEvent


internal sealed interface ViewEvent : MviSingleEvent {

    /**
     * Represents the event that the data has not been loaded successfully.
     */
    data class ShowError(
        val message: String?,
    ) : ViewEvent
}
