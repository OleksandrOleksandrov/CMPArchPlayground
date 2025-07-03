import extensions.projectLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KoinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.getByType<KotlinMultiplatformExtension>().apply {
                sourceSets.apply {
                    commonMain.dependencies {
                        api(target.projectLibs.findLibrary("koin.core").get())
                        implementation(target.projectLibs.findLibrary("koin.compose").get())
                        implementation(target.projectLibs.findLibrary("koin-compose-viewmodel").get())
                    }
                    androidMain.dependencies {}
                    iosMain.dependencies {}
                    jvmMain.dependencies {}
                }
            }
        }
    }
}