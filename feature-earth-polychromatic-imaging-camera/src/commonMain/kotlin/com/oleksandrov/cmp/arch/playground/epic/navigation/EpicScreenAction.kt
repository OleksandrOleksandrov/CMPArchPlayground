package com.oleksandrov.cmp.arch.playground.epic.navigation

sealed class EpicScreenAction {

    /**
     * Represents an action to navigate to details screen.
     */
    data object GoToDetailsAction : EpicScreenAction()
}
