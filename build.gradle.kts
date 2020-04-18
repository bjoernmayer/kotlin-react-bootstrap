plugins {
    kotlin("js") version "1.3.71"
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

    implementation(kotlinx("html-js", "0.7.1"))

    implementation(kotlinReact("16.13.0", Versions.KOTLIN_JS_WRAPPERS))
    implementation(kotlinReact("dom", "16.13.0", Versions.KOTLIN_JS_WRAPPERS))
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))
}

kotlin.target.browser { }
