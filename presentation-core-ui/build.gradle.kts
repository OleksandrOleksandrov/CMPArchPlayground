plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.convention.android.feature)
    alias(libs.plugins.convention.koin)
    alias(libs.plugins.composeMultiplatform)
}

kotlin {
    android {
        namespace = "com.oleksandrov.cmp.arch.playground.template"

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
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.material3)

                //region Preview tools, etc.
                implementation(libs.jetbrains.compose.ui.tp)
                //endregion Preview tools, etc.

                implementation(project(":presentation-core-styling"))
                implementation(project(":presentation-core-platform"))
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
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.testExt.junit)
            }
        }

        iosMain {
            dependencies {
            }
        }
    }
}