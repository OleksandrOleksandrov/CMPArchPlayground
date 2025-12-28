package com.oleksandrov.cmp.arch.playground.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class BaseNavigationDirection : NavKey {

    @Serializable
    data object Main : BaseNavigationDirection()

    /**
     * Earth Polychromatic Imaging Camera (EPIC)
     */
    @Serializable
    data object Epic : BaseNavigationDirection()

    /**
     * Earth Polychromatic Imaging Camera (EPIC) Details
     */
    @Serializable
    data class EpicDetails(
        val identifier: String? = null,
        val caption: String? = null,
        val image: String? = null,
        val date: String? = null,
    ) : BaseNavigationDirection()

    /**
     * Empty Epic Details
     */
    @Serializable
    data object EpicEmptyDetails : BaseNavigationDirection()
}
