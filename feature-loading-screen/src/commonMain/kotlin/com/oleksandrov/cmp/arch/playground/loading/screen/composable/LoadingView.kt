package com.oleksandrov.cmp.arch.playground.loading.screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cmparchitectureplayground.feature_loading_screen.generated.resources.Res as LocalRes
import com.oleksandrov.cmp.arch.playground.string.res.Res
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.AppTheme
import com.oleksandrov.cmp.arch.playground.presentation.core.styling.theme.core.Theme
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview.AppPreview5Dot5Inch
import com.oleksandrov.cmp.arch.playground.presentation.core.ui.preview.AppPreviewAll
import com.oleksandrov.cmp.arch.playground.string.res.content_description
import io.github.alexzhirkevich.compottie.Compottie
import io.github.alexzhirkevich.compottie.LottieCompositionSpec.Companion.JsonString
import io.github.alexzhirkevich.compottie.animateLottieCompositionAsState
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun LoadingView(
    modifier: Modifier = Modifier,
) {
    val composition by rememberLottieComposition {
        JsonString(
            LocalRes.readBytes("files/rocket_thruster_ignition.json").decodeToString()
        )
    }
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = Compottie.IterateForever,
    )

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = rememberLottiePainter(
                composition = composition,
                progress = { progress },
            ),
            contentDescription = stringResource(Res.string.content_description),
            modifier = Modifier.size(Theme.size.size160),
        )
    }
}

@AppPreviewAll
@Composable
private fun LoadingView_AppPreviewAll() {
    AppTheme {
        LoadingView(
            modifier = Modifier,
        )
    }
}

@AppPreview5Dot5Inch
@Composable
private fun LoadingView_DarkPreview() {
    AppTheme(
        useDarkTheme = true,
    ) {
        LoadingView(
            modifier = Modifier,
        )
    }
}
