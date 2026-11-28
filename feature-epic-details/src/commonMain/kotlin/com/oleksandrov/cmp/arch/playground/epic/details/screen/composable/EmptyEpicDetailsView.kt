package com.oleksandrov.cmp.arch.playground.epic.details.screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.component.CommonBodyText
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview.AppPreview5Dot5Inch
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview.AppPreviewAll
import com.oleksandrov.cmp.arch.playground.string.res.Res
import com.oleksandrov.cmp.arch.playground.string.res.content_description
import com.oleksandrov.cmp.arch.playground.string.res.epic_details_nothing_selected
import org.jetbrains.compose.resources.stringResource

@Composable
fun EmptyEpicDetails(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Empty.Empty?.let {
            Image(
                imageVector = it,
                modifier = Modifier,
                contentDescription = stringResource(Res.string.content_description),
            )
        }
        Spacer(modifier = Modifier.size(Theme.size.size16))
        CommonBodyText(
            text = stringResource(Res.string.epic_details_nothing_selected),
            style = Theme.typography.titleBold03,
        )
    }
}

@Composable
@AppPreviewAll
private fun EmptyEpicDetails_Preview() {
    AppTheme {
        Box(
            modifier = Modifier.background(Color.White),
        ) {
            EmptyEpicDetails()
        }
    }
}

@Composable
@AppPreview5Dot5Inch
private fun EmptyEpicDetailsDark_Preview() {
    AppTheme(
        useDarkTheme = true,
    ) {
        Box(
            modifier = Modifier.background(Color.Black),
        ) {
            EmptyEpicDetails()
        }
    }
}
