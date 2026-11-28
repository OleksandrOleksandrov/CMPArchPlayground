plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.convention.android.feature)
    alias(libs.plugins.convention.koin)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.org.jetbrains.kotlin.serialization)
}


kotlin {
    android {
        namespace = "com.oleksandrov.cmp.arch.playground.epic.details"

        withHostTest {
        }

        withDeviceTest {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        androidResources {
            enable = true
        }
    }
    val xcfName = "templateKit"

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = xcfName
            isStatic = true
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                implementation(libs.kotlinx.serialization.core)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(libs.jetbrains.compose.res)
                implementation(libs.androidx.core.ktx)
                implementation(libs.androidx.lifecycle.runtimeCompose)//TODO check if this is needed

                //region Preview tools, etc.
                implementation(libs.jetbrains.compose.ui.tp)
                //endregion Preview tools, etc.

                //regoin Coil
                implementation(libs.coil.compose)
                implementation(libs.coil.network.ktor)
                //endregoin Coil

                implementation(project(":common-kotlin"))
                implementation(project(":common-mapper"))
                implementation(project(":domain-epic"))
                implementation(project(":data-epic")) // TODO remove when extansions are moved to another module
                implementation(project(":presentation-core-platform"))
                implementation(project(":presentation-core-styling"))
                implementation(project(":presentation-core-ui"))
                implementation(project(":string-res"))
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
                //region Preview tools, etc.
                implementation(libs.androidx.compose.ui.tooling)
                //endregion Preview tools, etc.
                implementation(libs.androidx.material3)

                //regoin Ktor client dependency required for Coil
                implementation(libs.ktor.client.android)
                //endregoin Ktor client dependency required for Coil
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.testExt.junit)

                //region Adaptive layout
                implementation(libs.androidx.adaptive)
                implementation(libs.androidx.material3.window.sizeclass)
                implementation(libs.androidx.adaptive.layout)
                implementation(libs.androidx.adaptive.navigation)
                implementation(libs.androidx.material3.adaptive.navigation.suite)
                //endregion Adaptive layout
            }
        }

        iosMain {
            dependencies {
                //regoin Ktor client dependency required for iOS
                implementation(libs.ktor.client.darwin)
                //endregoinregoin Ktor client dependency required for iOS
            }
        }
    }
}