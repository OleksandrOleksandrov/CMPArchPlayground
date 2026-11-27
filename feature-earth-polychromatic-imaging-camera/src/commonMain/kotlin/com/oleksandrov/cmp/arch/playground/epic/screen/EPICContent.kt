package com.oleksandrov.cmp.arch.playground.epic.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oleksandrov.cmp.arch.playground.epic.model.EpicUiModel
import com.oleksandrov.cmp.arch.playground.epic.model.PictureOfDayUiModel
import com.oleksandrov.cmp.arch.playground.epic.screen.composable.EPICList
import com.oleksandrov.cmp.arch.playground.epic.screen.contract.ViewIntent
import com.oleksandrov.cmp.arch.playground.epic.screen.contract.ViewState
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview.AppPreview5Dot5Inch
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview.AppPreviewAll

@Composable
internal fun EPICContent(
    modifier: Modifier,
    state: ViewState,
    onIntent: (ViewIntent) -> Unit = {},
) {

    val listState = rememberSaveable(saver = LazyListState.Saver) { LazyListState(0, 0) }

    with(state) {
        Scaffold(
            modifier = modifier,
            contentWindowInsets = WindowInsets.safeDrawing,
            containerColor = Theme.color.themeNColor.n50,
        ) { scaffoldPaddingValues ->
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                if (isLoading) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier,
                            color = Theme.color.themeEColor.e1000,
                            strokeWidth = 2.dp
                        )
                    }
                } else {
                    EPICList(
                        modifier = Modifier,
                        paddingValues = scaffoldPaddingValues,
                        lazyState = listState,
                        list = epicList,
                        onClick = {
                            onIntent(ViewIntent.OnEpicItemTappedIntent(it))
                        }
                    )
                }
            }
        }
    }
}

@Composable
@AppPreviewAll
private fun EPICContent_Preview() {
    AppTheme {
        EPICContent(
            modifier = Modifier,
            state = ViewState(
                isLoading = false,
                epicList = mockList,
                isLoadingError = false,
            ),
        )
    }
}

@Composable
@AppPreview5Dot5Inch
private fun EPICContentDark_Preview() {
    AppTheme(
        useDarkTheme = true,
    ) {
        EPICContent(
            modifier = Modifier,
            state = ViewState(
                isLoading = false,
                epicList = mockList,
                isLoadingError = false,
            ),
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
val mockList = listOf(
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