@file:Suppress("UnstableApiUsage")

rootProject.name = "kotlin_react_bootstrap"

pluginManagement {
    resolutionStrategy {
        plugins {
            val kotlinVersion = extra["kotlin.version"] as String
            kotlin("js") version kotlinVersion

            val ktlintGradleVersion = extra["ktlint-gradle.version"] as String
            id("org.jlleitschuh.gradle.ktlint") version ktlintGradleVersion
        }
    }
}

// The actual lib
include(":kotlin-react-bootstrap")

// Site/Documentation
include(":site")
