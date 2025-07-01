package com.oleksandrov.cmp.arch.playground

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.UIKitViewController

@Composable
actual fun PrivacyText(modifier: Modifier, text: String) {
    val factory = LocalNativeViewFactory.current
    UIKitViewController(
        modifier = modifier.fillMaxWidth().height(200.dp).width(300.dp),// Must be sit size
        factory = {
            factory.createPrivacyTextUIView(text = text)
        }
    )
}