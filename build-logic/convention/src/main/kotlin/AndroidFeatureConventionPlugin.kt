import com.android.build.api.variant.KotlinMultiplatformAndroidComponentsExtension
import extensions.getVersionAsInt
import extensions.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

/**
 * A plugin that configures an Android library module with common settings.
 *
 * This plugin applies necessary Android, Kotlin, and Parcelize configurations for
 * an Android library project. It sets up the project with default SDK versions,
 * Java and Kotlin compatibility, and includes required dependencies. It also
 * configures the Kotlin compiler for context receivers.  It sets up the project to use Jetpack Compose
 * by enabling Compose build features and configuring required dependencies.
 *
 * Usage:
 *
 * ```kotlin
 * plugins {
 *     alias(libs.plugins.convention.android.feature)
 * }
 * ```
 */
class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        plugins {
            apply("org.jetbrains.kotlin.plugin.compose")
        }

        extensions.getByType<KotlinMultiplatformAndroidComponentsExtension>().finalizeDsl { extension ->
            extension.compileSdk = getVersionAsInt("android-compileSdk")
            extension.minSdk = getVersionAsInt("android-minSdk")
        }
        
        dependencies {
        }
    }
}
