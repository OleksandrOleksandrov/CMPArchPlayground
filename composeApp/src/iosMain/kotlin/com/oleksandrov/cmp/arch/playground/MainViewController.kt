package com.oleksandrov.cmp.arch.playground

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeUIViewController
import com.oleksandrov.cmp.arch.playground.di.initKoin

val LocalNativeViewFactory = staticCompositionLocalOf<NativeViewFactory> {
    error("No view factory provided.")
}

@ExperimentalComposeUiApi
fun MainViewController(
    nativeViewFactory: NativeViewFactory,
) = ComposeUIViewController(
    configure = {
        initKoin()
        parallelRendering = true // Enable parallel rendering for better performance
    }
) {
    CompositionLocalProvider(LocalNativeViewFactory provides nativeViewFactory) {
        App()
    }
}