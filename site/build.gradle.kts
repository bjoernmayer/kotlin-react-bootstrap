plugins {
    kotlin("js")
    id("org.jlleitschuh.gradle.ktlint")
}

repositories {
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
    implementation(npm("markdown-to-jsx", "6.11.4"))
    testImplementation(npm("karma", "5.1.1"))
}

kotlin.target {
    browser {
        distribution {
            directory = File("$rootDir/docs/")
        }
    }
    useCommonJs()
}
