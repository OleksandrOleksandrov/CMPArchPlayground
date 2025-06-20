package com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme

import androidx.compose.runtime.staticCompositionLocalOf
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.ThemeCorner
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.ThemeSpacing
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.ThemeTypography

internal val LocalThemeColor =
    staticCompositionLocalOf<ThemeColor> {
        error("No implementation")
    }

internal val LocalThemeCorner =
    staticCompositionLocalOf<ThemeCorner> {
        error("No implementation")
    }

internal val LocalThemeSpacing =
    staticCompositionLocalOf<ThemeSpacing> {
        error("No implementation")
    }

internal val LocalThemeTypography =
    staticCompositionLocalOf<ThemeTypography> {
        error("No implementation")
    }
