plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.convention.android.feature)
    alias(libs.plugins.convention.koin)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    android {
        namespace = "com.oleksandrov.cmp.arch.playground.string.res"

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
                implementation(compose.components.resources)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
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
compose.resources {
    publicResClass = true
    packageOfResClass = "com.oleksandrov.cmp.arch.playground.string.res"
    generateResClass = auto
}