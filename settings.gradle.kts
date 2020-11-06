@file:Suppress("UnstableApiUsage")

rootProject.name = "kotlin_react_bootstrap"

pluginManagement {
    resolutionStrategy {
        plugins {
            infix fun PluginDependencySpec.extraVersion(target: String) =
                version(extra["$target.version"] as String)

            kotlin("js") extraVersion "kotlin"

            id("org.jlleitschuh.gradle.ktlint") extraVersion "ktlint-gradle"
        }
    }
}

// The actual lib
include(":kotlin-react-bootstrap")

// Site/Documentation
include(":site")
