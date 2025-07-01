package com.oleksandrov.cmp.arch.playground

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun PrivacyBox(modifier: Modifier, text: String, content: @Composable () -> Unit) //TODO: Change for view group.