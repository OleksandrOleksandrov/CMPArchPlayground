package com.oleksandrov.cmp.arch.playground

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.scene.SceneStrategy
import androidx.navigation3.ui.NavDisplay
import com.oleksandrov.cmp.arch.playground.epic.screen.EPICScreen
import kotlinx.serialization.Serializable


@Serializable
private data object ListScreen : NavKey

@Serializable
private data class Details(val identifier: String? = null) : NavKey

@Composable
fun NavigationRoot(
    modifier: Modifier,
) {
//    val backStack = rememberNavBackStack(config, RouteA)
    val topLevelBackStack = remember { TopLevelBackStack<Any>(ListScreen) }
    val twoPaneStrategy = rememberTwoPaneSceneStrategy<NavKey>()

    NavDisplay(
        backStack = topLevelBackStack.backStack,
        modifier = modifier,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
        ),
        sceneStrategy = twoPaneStrategy as SceneStrategy<Any>,
        entryProvider = entryProvider {
            entry<ListScreen>(
                metadata = TwoPaneScene.twoPane()
            ) {
                EPICScreen { model ->
                    topLevelBackStack.addDetails(
                        Details(model.id)
                    )
                }
            }
            entry<Details>(
                metadata = TwoPaneScene.twoPane()
            ) { key ->
                EpicDetailsScreen(
                    modifier = Modifier,
                    identifier = key.identifier,
                )
            }
        },
        transitionSpec = { slideInFromRight() },
        popTransitionSpec = { slideInFromLeft() },
        predictivePopTransitionSpec = { slideInFromLeft() },
    )
}

@Composable
fun EpicDetailsScreen(
    modifier: Modifier = Modifier,
    identifier: String?,
) {

    val scope = rememberCoroutineScope()


    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets.safeDrawing,
    ) { scaffoldPaddingValues ->
        EpicDetailsContent(
            modifier = Modifier.padding(scaffoldPaddingValues),
            state = identifier,
        )
    }
}

@Composable
internal fun EpicDetailsContent(
    modifier: Modifier,
    state: String?,
) {

    Text(state.orEmpty())
}

/**
 * Slide in from the left when navigating back.
 */
private fun slideInFromLeft(): ContentTransform =
    slideInHorizontally(initialOffsetX = { -it }) togetherWith
        slideOutHorizontally(targetOffsetX = { it })

/**
 * Slide in from right when navigation forward.
 */
private fun slideInFromRight(): ContentTransform =
    slideInHorizontally(initialOffsetX = { it }) togetherWith
        slideOutHorizontally(targetOffsetX = { -it })

class TopLevelBackStack<T : Any>(startKey: T) {

    // Maintain a stack for each top level route
    private var topLevelStacks: LinkedHashMap<T, SnapshotStateList<T>> = linkedMapOf(
        startKey to mutableStateListOf(startKey)
    )

    // Expose the current top level route for consumers
    var topLevelKey by mutableStateOf(startKey)
        private set

    // Expose the back stack so it can be rendered by the NavDisplay
    val backStack = mutableStateListOf(startKey)

    private fun updateBackStack() =
        backStack.apply {
            clear()
            addAll(topLevelStacks.flatMap { it.value })
        }

    fun addTopLevel(key: T) {

        // If the top level doesn't exist, add it
        if (topLevelStacks[key] == null) {
            topLevelStacks.put(key, mutableStateListOf(key))
        } else {
            // Otherwise just move it to the end of the stacks
            topLevelStacks.apply {
                remove(key)?.let {
                    put(key, it)
                }
            }
        }
        topLevelKey = key
        updateBackStack()
    }

    fun add(key: T) {
        topLevelStacks[topLevelKey]?.add(key)
        updateBackStack()
    }

    fun removeLast() {
        val removedKey = topLevelStacks[topLevelKey]?.removeLastOrNull()
        // If the removed key was a top level key, remove the associated top level stack
        topLevelStacks.remove(removedKey)
        topLevelKey = topLevelStacks.keys.last()
        updateBackStack()
    }

    fun addDetails(key: T) {
        // Remove any existing detail routes, then add the new detail route
        if (topLevelStacks[topLevelKey]?.last() is Details) {
            removeLast()
        }
        add(key)
    }
}
