package com.oleksandrov.cmp.arch.playground.loading.screen.contract

import com.oleksandrov.cmp.arch.playground.presentation.core.platform.base.mvi.MviIntent

internal sealed interface ViewIntent : MviIntent {

    /**
     * Represents the initial intent to load the data when init.
     */
    data object OnStartIntent : ViewIntent


    /**
     * Represents the intent to reload the data.
     */
    data object OnReloadIntent : ViewIntent
}
