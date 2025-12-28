package com.oleksandrov.cmp.arch.playground.epic.details.model

import androidx.compose.runtime.Immutable

@Immutable
//@Serializable
data class EpicUiModel(
    val identifier: String? = null,
    val caption: String? = null,
    val image: String? = null,
    val date: String? = null,
)

