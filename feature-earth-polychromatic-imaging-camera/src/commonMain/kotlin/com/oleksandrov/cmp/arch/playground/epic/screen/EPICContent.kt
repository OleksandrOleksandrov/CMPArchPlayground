package com.oleksandrov.cmp.arch.playground.epic.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.oleksandrov.cmp.arch.playground.epic.model.EpicUiModel
import com.oleksandrov.cmp.arch.playground.epic.model.PictureOfDayUiModel
import com.oleksandrov.cmp.arch.playground.epic.screen.composable.EPICList
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme

@Composable
fun EPICContent(
    modifier: Modifier,
    pictureOfDayUiModel: PictureOfDayUiModel?,
    list: List<EpicUiModel>,
    navigateToDetails: (EpicUiModel) -> Unit,
) {

    val selected = rememberSaveable { mutableStateOf<EpicUiModel?>(null) }
    val listState = rememberSaveable(saver = LazyListState.Saver) { LazyListState(0, 0) }
    val smallWeight = 0.7f
    val bigWeight = 1f

    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = Color.DarkGray,
    ) { scaffoldPaddingValues ->
        Box(
            modifier = Modifier
        ) {
            EPICList(
                modifier = Modifier,
                paddingValues = scaffoldPaddingValues,
                lazyState = listState,
                pictureOfDayUiModel = pictureOfDayUiModel,
                list = list,
                onClick = {
                    selected.value = it
                    navigateToDetails(it)
                }
            )
        }
    }
}

@Composable
@Preview
private fun EPICContentMediumWindowSizePreview() {
    AppTheme {
        EPICContent(
            modifier = Modifier,
            pictureOfDayUiModel = pictureOfDayUiModel,
            list = mockList,
            navigateToDetails = {},
        )
    }
}

@Composable
@Preview
private fun EPICContentCompactWindowSizePreview() {
    AppTheme {
        EPICContent(
            modifier = Modifier,
            pictureOfDayUiModel = pictureOfDayUiModel,
            list = mockList,
            navigateToDetails = {},
        )
    }
}

private val pictureOfDayUiModel = PictureOfDayUiModel(
    date = "2023-10-01",
    explanation = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
            "\n",
    hdurl = "",
    mediaType = "image",
    title = "Picture of the Day",
    url = "",
)
private val mockList = listOf(
    EpicUiModel(
        identifier = "1",
        image = "https://example.com/image1.jpg",
        caption = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "\n",
        date = "2023-10-01"
    ),
    EpicUiModel(
        identifier = "2",
        image = "https://example.com/image2.jpg",
        caption = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
                "\n",
        date = "2023-10-02"
    )
)