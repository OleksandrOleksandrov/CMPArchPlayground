package extensions

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.getByType

/**
 * Name libs instead of projectLibs can not be applied because of conflict.
 * If name is libs then this structure "implementation(libs.androidx.core.ktx)" will not work.
 */
val Project.projectLibs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

/**
 * Configures plugins for the project.
 *
 * This extension function provides a convenient way to configure plugins for a project
 * using a lambda expression. It allows you to add or configure plugins in a project context.
 *
 * Usage:
 *
 * ```kotlin
 * project.plugins {
 *     id("com.android.application")
 *     id("org.jetbrains.kotlin.android")
 * }
 * ```
 *
 * @param block A lambda expression that configures the [PluginManager] for the project.
 */
@Suppress("unused")
fun Project.plugins(block: PluginManager.() -> Unit) {
    this.pluginManager.block()
}

/**
 * Retrieves version as a [Int] from the project's extensions by the given name.
 *
 * This extension function simplifies the process of accessing specific version
 * from the version catalog.
 *
 * Usage:
 *
 * ```kotlin
 * val version: Int = project.getVersionAsInt("someVersion")
 * ```
 *
 * @param name The exact name of the version entry in the version catalog.
 *
 * @return The version as a [Int].
 */
fun Project.getVersionAsInt(name: String) = projectLibs.findVersion(name).get().toString().toInt()
