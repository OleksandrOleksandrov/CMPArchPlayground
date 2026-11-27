package com.oleksandrov.cmp.arch.playground.epic.screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oleksandrov.cmp.arch.playground.epic.model.EpicUiModel
import com.oleksandrov.cmp.arch.playground.epic.model.PictureOfDayUiModel
import com.oleksandrov.cmp.arch.playground.epic.screen.mockList
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview.AppPreviewAll

@Composable
internal fun EPICList(
    modifier: Modifier,
    paddingValues: PaddingValues,
    lazyState: LazyListState,
    pictureOfDayUiModel: PictureOfDayUiModel? = null,
    list: List<EpicUiModel>,
    onClick: (EpicUiModel) -> Unit,
) {
    LazyColumn(
        modifier = modifier.background(Theme.color.themeBnColor.bn100),
        contentPadding = paddingValues,
        state = lazyState,
        content = {
            item {
                pictureOfDayUiModel?.let {
                    PictureOfDay(
                        modifier = Modifier,
                        pictureOfDayUiModel = it,
                    )
                }
            }
            items(
                items = list,
                key = { it.identifier.orEmpty() }
            ) {
                EPICListItem(
                    modifier = Modifier
                        .clickable { onClick(it) },
                    item = it,
                )
            }
        }
    )
}

@Composable
@AppPreviewAll
private fun EPICList_Preview() {
    AppTheme {
        EPICList(
            modifier = Modifier,
            pictureOfDayUiModel = null,
            list = mockList,
            paddingValues = PaddingValues(0.dp),
            lazyState = LazyListState(0, 0),
            onClick = {},
        )
    }
}