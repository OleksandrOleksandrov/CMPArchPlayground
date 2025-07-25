package com.oleksandrov.cmp.arch.playground.presentation.core.platform.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.Flow

/**
 * Remembers the result of [flowWithLifecycle]. Updates the value if the [flow]
 * or [lifecycleOwner] changes. Cancels collection in onStop() and start it in onStart()
 *
 * @param flow The [Flow] that is going to be collected.
 * @param lifecycleOwner The [LifecycleOwner] to validate the [Lifecycle.State] from
 *
 * @return [Flow] with the remembered value of type [T]
 */
@Composable
fun <T> rememberFlowWithLifecycle(
    flow: Flow<T>,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
): Flow<T> = remember(flow, lifecycleOwner) {
    flow.flowWithLifecycle(
        lifecycleOwner.lifecycle,
        Lifecycle.State.STARTED,
    )
}
