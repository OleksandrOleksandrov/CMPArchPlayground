package com.oleksandrov.cmp.arch.playground.loading.test

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.v2.runComposeUiTest

import com.oleksandrov.cmp.arch.playground.loading.model.ErrorUiModel
import com.oleksandrov.cmp.arch.playground.loading.screen.LoadingContent
import com.oleksandrov.cmp.arch.playground.loading.screen.contract.ViewState
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import kotlin.test.Test

@RunWith(AndroidJUnit4::class)
class LoadingContentInstrumentedTest {
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun verify_loading_state_is_visible() = runComposeUiTest {
        setContent {
            AppTheme {
                LoadingContent(
                    modifier = Modifier,
                    state = ViewState(
                        isLoading = true,
                        error = null,
                    ),
                )
            }
        }
        onNodeWithTag("tag_loading_view").assertExists()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun verify_error_state_is_visible() = runComposeUiTest {
        setContent {
            AppTheme {
                LoadingContent(
                    modifier = Modifier,
                    state = ViewState(
                        isLoading = false,
                        error = ErrorUiModel(
                            message = "error",
                        ),
                    )
                )
            }
        }
        onNodeWithTag("tag_error_view").assertExists()
    }
}
