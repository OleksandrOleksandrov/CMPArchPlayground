package com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core

import androidx.compose.runtime.Composable
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.LocalThemeColor
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.LocalThemeCorner
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.LocalThemeSpacing
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.LocalThemeTypography
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.ThemeColor
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme.color

/**
 * Provides access to the Theme theme properties, allowing for consistent styling across the application.
 *
 * @property color The color palette used in the Theme theme.
 * @property corner The corner radii used in the Theme theme.
 * @property spacing The spacing values used in the Theme theme.
 * @property typography The typography styles used in the Theme theme.
 */
object Theme {
    val color: ThemeColor
        @Composable
        get() = LocalThemeColor.current
    val corner: ThemeCorner
        @Composable
        get() = LocalThemeCorner.current
    val spacing: ThemeSpacing
        @Composable
        get() = LocalThemeSpacing.current
    val typography: ThemeTypography
        @Composable
        get() = LocalThemeTypography.current
}
