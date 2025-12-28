package com.oleksandrov.cmp.arch.playground.epic.screen.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oleksandrov.cmp.arch.playground.epic.model.EpicUiModel
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme

@Composable
internal fun EPICListItem(
    modifier: Modifier,
    item: EpicUiModel,
) {
    Box(
        modifier = modifier.padding(8.dp),
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier,
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
            ) {
                Text(
                    text = item.caption.orEmpty(),
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = item.date.orEmpty(),
                    textAlign = TextAlign.End,
                )
            }
        }
    }
}

@Composable
@Preview
private fun EPICListItemPreview() {
    AppTheme {
        EPICListItem(
            modifier = Modifier,
            item = EpicUiModel(
                identifier = "1",
                image = "https://example.com/image1.jpg",
                caption = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                        "\n",
                date = "2023-10-01"
            )
        )
    }
}