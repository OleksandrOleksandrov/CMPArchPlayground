package com.oleksandrov.cmp.arch.playground.epic.screen.contract

import com.oleksandrov.cmp.arch.playground.epic.model.EpicUiModel
import com.oleksandrov.cmp.arch.playground.presentation.core.platform.base.mvi.MviIntent

internal sealed interface ViewIntent : MviIntent {

    /**
     * Represents the initial intent to load the data when init.
     */
    data object OnStartIntent : ViewIntent

    /**
     * Represents the intent to that the user has tapped on an epic item.
     */
    data class OnEpicItemTappedIntent(
        val model: EpicUiModel,
    ) : ViewIntent
}
