plugins {
    kotlin("js")
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
    implementation(npm("styled-components"))
    implementation(npm("inline-style-prefixer"))

    implementation(npm("bootstrap"))

    implementation(npm("css-loader"))
    implementation(npm("style-loader"))
}

kotlin.target.browser {
    distribution {
        directory = File("$rootDir/docs/")
    }
}
