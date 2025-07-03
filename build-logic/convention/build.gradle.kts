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
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation("org.jetbrains.kotlin.multiplatform:org.jetbrains.kotlin.multiplatform.gradle.plugin:2.2.0")
    implementation("com.android.tools.build:gradle:8.7.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.20")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.8")
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.8.2")
}

gradlePlugin {
    plugins {
        register("androidKoin") {
            id = "com.oleksandr.android.koin"
            implementationClass = "KoinConventionPlugin"
        }
    }
}