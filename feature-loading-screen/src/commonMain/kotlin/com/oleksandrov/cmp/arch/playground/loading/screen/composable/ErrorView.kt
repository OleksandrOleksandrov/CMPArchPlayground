package com.oleksandrov.cmp.arch.playground.loading.screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.oleksandrov.cmp.arch.playground.loading.model.ErrorUiModel
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.component.CommonBodyText
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.component.PrimaryButton
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview.AppPreview5Dot5Inch
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview.AppPreviewAll
import com.oleksandrov.cmp.arch.playground.string.res.Res
import com.oleksandrov.cmp.arch.playground.string.res.content_description
import com.oleksandrov.cmp.arch.playground.string.res.retry
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun ErrorView(
    modifier: Modifier = Modifier,
    errorUiModel: ErrorUiModel,
    onRetry: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Theme.color.themeBnColor.bn50)
            .padding(horizontal = Theme.spacing.space48),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = Modifier.height(Theme.spacing.space48))
        Image(
            imageVector = Empty.EmptyImage,
            modifier = Modifier.weight(1.0f),
            contentDescription = stringResource(Res.string.content_description),
        )
        Spacer(modifier = Modifier.height(Theme.spacing.space16))
        CommonBodyText(
            text = errorUiModel.message,
            modifier = Modifier,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(Theme.spacing.space16))
        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(Res.string.retry),
            onClick = onRetry,
        )
        Spacer(modifier = Modifier.height(Theme.spacing.space48))
    }
}

val errorUiModelForPreview = ErrorUiModel(
    message = "The error happened, check your internet connection and try again.",
)

@AppPreviewAll
@Composable
private fun ErrorView_AppPreviewAll() {
    AppTheme {
        ErrorView(
            modifier = Modifier,
            errorUiModel = errorUiModelForPreview,
            onRetry = {},
        )
    }
}

@AppPreview5Dot5Inch
@Composable
private fun ErrorView_DarkPreview() {
    AppTheme(
        useDarkTheme = true,
    ) {
        ErrorView(
            modifier = Modifier,
            errorUiModel = errorUiModelForPreview,
            onRetry = {},
        )
    }
}
