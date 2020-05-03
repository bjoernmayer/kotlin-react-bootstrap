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

    api(kotlinReact(Versions.REACT_VERSION, Versions.KOTLIN_JS_WRAPPERS))
    api(kotlinReact("dom", Versions.REACT_VERSION, Versions.KOTLIN_JS_WRAPPERS))
}

tasks.withType<KotlinJsCompile> {
    // Also used by kotlin-wrappers. See http://www.commonjs.org/specs/modules/1.0/
    kotlinOptions.moduleKind = COMMONJS
}

kotlin.target.browser()
