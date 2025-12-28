package com.oleksandrov.cmp.arch.playground.epic.details.screen.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.toUri
import com.oleksandrov.cmp.arch.playground.epic.details.model.EpicUiModel

@Composable
internal fun EpicDetailsView(
    modifier: Modifier,
    model: EpicUiModel? = null,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            model?.caption.orEmpty() + model?.date,
        )

        AsyncImage(
            model = model?.image?.toUri(),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
            alignment = Alignment.CenterStart,
            modifier = Modifier
                .fillMaxWidth(),
            onError = { state ->
                println("Coil Error on iOS: ${state.result.throwable.message}")
                state.result.throwable.printStackTrace()
            }
        )
    }
}