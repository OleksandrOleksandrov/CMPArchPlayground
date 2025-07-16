import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "dev.yactt.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    implementation(libs.kotlin.mpp.plugin)
    implementation(libs.android.gradle.plugin)
    implementation(libs.android.gradle.api)
    implementation(libs.android.mpp.plugin)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.detekt.gradle.plugin)
    implementation(libs.compose.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidKoin") {
            id = "com.oleksandr.convention.koin"
            implementationClass = "KoinConventionPlugin"
        }
        register("androidFeature") {
            id = "com.oleksandr.android.feature"
            implementationClass =
                "AndroidFeatureConventionPlugin"
        }
    }
}