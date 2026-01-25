package com.oleksandrov.cmp.arch.playground.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class BaseNavigationDirection {

    /**
     * Earth Polychromatic Imaging Camera (EPIC)
     */
    @Serializable
    data object EPIC : BaseNavigationDirection()

    /**
     * Earth Polychromatic Imaging Camera (EPIC) Details
     */
    @Serializable
    data class EpicDetails(
        val identifier: String? = null,
    ) : BaseNavigationDirection()
}