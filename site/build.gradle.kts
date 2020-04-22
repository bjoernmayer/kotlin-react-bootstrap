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

    implementation(kotlinx("html-js", "0.7.1"))

    implementation("org.jetbrains:kotlin-css:1.0.0-${Versions.KOTLIN_JS_WRAPPERS}")
    implementation("org.jetbrains:kotlin-extensions:1.0.1-${Versions.KOTLIN_JS_WRAPPERS}")

    implementation(kotlinReact("16.13.0", Versions.KOTLIN_JS_WRAPPERS))
    implementation(kotlinReact("dom", "16.13.0", Versions.KOTLIN_JS_WRAPPERS))
    implementation(kotlinReact("router-dom", "4.3.1", Versions.KOTLIN_JS_WRAPPERS))

    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))
    implementation(npm("react-router-dom", "5.1.2"))

    implementation("org.jetbrains:kotlin-styled:1.0.0-${Versions.KOTLIN_JS_WRAPPERS}")
    implementation(npm("styled-components", "5.1.0"))
    implementation(npm("inline-style-prefixer", "6.0.0"))

//    implementation(npm("bootstrap", "4.4.1"))

    implementation(npm("css-loader", "3.5.2"))
    implementation(npm("style-loader", "1.1.4"))
}

kotlin.target.browser {
    distribution {
        directory = File("$rootDir/docs/")
    }
}
