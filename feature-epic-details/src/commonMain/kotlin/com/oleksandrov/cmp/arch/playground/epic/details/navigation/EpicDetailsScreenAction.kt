package com.oleksandrov.cmp.arch.playground.epic.details.navigation

sealed class EpicDetailsScreenAction {

    /**
     * Represents an action to navigate to details screen.
     */
    data class GoToDetailsActionDetails(
        val id: String,
    ) : EpicDetailsScreenAction()
}
