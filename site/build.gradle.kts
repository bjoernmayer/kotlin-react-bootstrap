import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackOutput.Target.UMD

plugins {
    kotlin("js")
    id("org.jlleitschuh.gradle.ktlint")
}

repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(rootProject)

    implementation(kotlin("stdlib-js"))

    implementation(kotlinReact(Versions.REACT_VERSION, Versions.KOTLIN_JS_WRAPPERS))
    implementation(kotlinReact("dom", Versions.REACT_VERSION, Versions.KOTLIN_JS_WRAPPERS))
    implementation(kotlinReact("router-dom", "5.1.2", Versions.KOTLIN_JS_WRAPPERS))
    implementation(kotlinReact("redux", "5.0.7", Versions.KOTLIN_JS_WRAPPERS))

    implementation(jetbrains("kotlin-styled", "1.0.0-${Versions.KOTLIN_JS_WRAPPERS}"))
    implementation(jetbrains("kotlin-css", "1.0.0-${Versions.KOTLIN_JS_WRAPPERS}"))
    implementation(jetbrains("kotlin-extensions", "1.0.1-${Versions.KOTLIN_JS_WRAPPERS}"))

    implementation(npm("css-loader", "3.5.2"))
    implementation(npm("style-loader", "1.1.4"))
    implementation(npm("file-loader", "6.0.0"))
}

tasks.named("compileKotlinJs") {
    this as org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile

    kotlinOptions.moduleKind = UMD
}

kotlin.target.browser {
    webpackTask {
        output.libraryTarget = UMD
    }
    distribution {
        directory = File("$rootDir/docs/")
    }
}
