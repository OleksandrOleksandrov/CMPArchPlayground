package com.oleksandrov.cmp.arch.playground

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeUIViewController

@ExperimentalComposeUiApi
fun MainViewController() = ComposeUIViewController(
    configure = { parallelRendering = true } // Enable parallel rendering for better performance
) { App() }