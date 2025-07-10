package config

import org.gradle.api.JavaVersion

/**
 * Project configuration object that holds various constants and settings
 * for the Android project.
 */
object ProjectConfig {

    /**
     * The application ID for the project.
     */
    const val APPLICATION_ID = "com.oleksandrov.cmp.arch.playground"


    /**
     * The Java version used in the project.
     */
    val JAVA_VERSION = JavaVersion.VERSION_21

    /**
     * The Kotlin version used in the project.
     */
    const val KOTLIN_VERSION = "21"
}
