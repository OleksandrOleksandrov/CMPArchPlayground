package com.oleksandrov.cmp.arch.playground.epic.screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.oleksandrov.cmp.arch.playground.epic.model.EpicUiModel
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.component.CommonBodyText
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview.AppPreview5Dot5Inch
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview.AppPreviewAll

@Composable
internal fun EPICListItem(
    modifier: Modifier,
    item: EpicUiModel,
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = Theme.spacing.space6
        ),
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .background(Theme.color.themeBnColor.bn50)
                .padding(Theme.spacing.space12),
        ) {
            CommonBodyText(
                text = item.caption.orEmpty(),
            )
            CommonBodyText(
                modifier = Modifier.fillMaxWidth(),
                text = item.date.orEmpty(),
                textAlign = TextAlign.End,
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
private fun EPICListItem_Preview() {
    AppTheme {
        Box(
            modifier = Modifier.padding(Theme.spacing.space8),
        ) {
            EPICListItem(
                modifier = Modifier,
                item = epicUiModelPreview,
            )
        }
    }
}

@AppPreview5Dot5Inch
@Composable
private fun ErrorViewDark_Preview() {
    AppTheme(
        useDarkTheme = true,
    ) {
        Box(
            modifier = Modifier.background(Color.Black),
        ) {
            EPICListItem(
                modifier = Modifier,
                item = epicUiModelPreview,
            )
        }
    }
}
