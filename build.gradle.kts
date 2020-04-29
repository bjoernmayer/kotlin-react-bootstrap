plugins {
    kotlin("js") version "1.3.71"
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
}

group = "react"
version = "0.9"

repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))

    implementation(kotlinReact(Versions.REACT_VERSION, Versions.KOTLIN_JS_WRAPPERS))
    implementation(kotlinReact("dom", Versions.REACT_VERSION, Versions.KOTLIN_JS_WRAPPERS))
}

kotlin.target.browser { }
