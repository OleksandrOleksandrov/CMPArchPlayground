package com.oleksandrov.cmp.arch.playground.epic.details.screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import coil3.toUri
import com.oleksandrov.cmp.arch.playground.epic.details.model.EpicUiModel
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.component.CommonBodyText
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview.AppPreview5Dot5Inch
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview.AppPreviewAll

@Composable
internal fun EpicDetailsView(
    modifier: Modifier,
    model: EpicUiModel? = null,
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = Theme.spacing.space6,
        ),
        modifier = modifier
            .padding(Theme.spacing.space16),
    ) {
        Column(
            modifier = Modifier
                .background(Theme.color.themeBnColor.bn50)
                .padding(Theme.spacing.space16),
        ) {
            CommonBodyText(
                text = model?.caption.orEmpty() + model?.date,
                modifier = Modifier,
            )
            Spacer(modifier = Modifier.size(Theme.spacing.space16))
            AsyncImage(
                model = model?.image?.toUri(),
                contentScale = ContentScale.FillWidth,
                contentDescription = model?.caption.orEmpty(),
                modifier = Modifier
                    .fillMaxWidth()

                    .clip(RoundedCornerShape(Theme.corner.corner16)),
                alignment = Alignment.CenterStart,
                placeholder = Empty.Empty?.let { rememberVectorPainter(it) },
                onError = { state ->
                    println("Coil Error EpicDetailsView: ${state.result.throwable.message}")
                    state.result.throwable.printStackTrace()
                }
            )
        }
    }
}

val epicUiModelPreview = EpicUiModel(
    identifier = "1",
    image = "",
    caption = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    date = "2023-10-01"
)

@Composable
@AppPreviewAll
private fun EpicDetailsView_Preview() {
    AppTheme {
        EpicDetailsView(
            modifier = Modifier,
            model = epicUiModelPreview,
        )
    }
}

@Composable
@AppPreview5Dot5Inch
private fun EpicDetailsViewDark_Preview() {
    AppTheme(
        useDarkTheme = true,
    ) {
        EpicDetailsView(
            modifier = Modifier,
            model = epicUiModelPreview,
        )
    }
}