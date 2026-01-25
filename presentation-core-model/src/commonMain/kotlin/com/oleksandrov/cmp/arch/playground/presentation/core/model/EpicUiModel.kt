package com.oleksandrov.cmp.arch.playground.presentation.core.model

import androidx.compose.runtime.Immutable

@Immutable
data class EpicUiModel(
    val identifier: String? = null,
    val caption: String? = null,
    val image: String? = null,
    val date: String? = null,
)
