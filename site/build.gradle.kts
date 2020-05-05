import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackOutput.Target.AMD

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

    implementation(kotlinReact("router-dom", "5.1.2", Versions.KOTLIN_JS_WRAPPERS))

    implementation(jetbrains("kotlin-extensions", "1.0.1-${Versions.KOTLIN_JS_WRAPPERS}"))

    implementation(npm("css-loader", "3.5.2"))
    implementation(npm("style-loader", "1.1.4"))
    implementation(npm("file-loader", "6.0.0"))

    implementation(npm("react-syntax-highlighter", "12.2.1"))
}

tasks.withType<KotlinJsCompile> {
    // See https://github.com/amdjs/amdjs-api/blob/master/AMD.md
    kotlinOptions.moduleKind = AMD
}

kotlin.target.browser {
    distribution {
        directory = File("$rootDir/docs/")
    }
}
