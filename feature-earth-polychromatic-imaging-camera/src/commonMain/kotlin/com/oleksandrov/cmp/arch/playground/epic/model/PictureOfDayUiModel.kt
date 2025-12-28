package com.oleksandrov.cmp.arch.playground.epic.model

import androidx.compose.runtime.Immutable

@Immutable
//@Serializable
data class PictureOfDayUiModel(
    val date: String,
    val explanation: String,
    val hdurl: String,
    val mediaType: String,
    val title: String,
    val url: String
)
