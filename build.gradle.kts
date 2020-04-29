import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackOutput.Target.COMMONJS

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

tasks.named("compileKotlinJs") {
    this as KotlinJsCompile

    kotlinOptions.moduleKind = COMMONJS
}

kotlin.target.browser {
    webpackTask {
        output.libraryTarget = COMMONJS
    }
}
