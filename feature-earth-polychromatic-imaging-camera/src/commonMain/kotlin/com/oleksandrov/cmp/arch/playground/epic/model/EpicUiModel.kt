package com.oleksandrov.cmp.arch.playground.epic.model

import androidx.compose.runtime.Immutable

@Immutable
//@Parcelize
data class EpicUiModel(
    val identifier: String? = null,
    val caption: String? = null,
    val image: String? = null,
    val date: String? = null,
) //: Parcelable

