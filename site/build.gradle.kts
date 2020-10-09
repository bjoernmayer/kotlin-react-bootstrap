plugins {
    kotlin("js")
}

dependencies {
    implementation(project(":kotlin-react-bootstrap"))

    implementation(kotlinJsWrapper("react-router-dom"))

//    implementation(jetbrains("kotlin-extensions", "1.0.1-${Versions.KOTLIN_JS_WRAPPERS}"))

//    implementation(npm("css-loader", "3.5.2"))
//    implementation(npm("style-loader", "1.1.4"))
    implementation(npm("file-loader", version("file-loader")))

    implementation(npm("react-syntax-highlighter", version("react-syntax-highlighter")))
    implementation(npm("markdown-to-jsx", version("markdown-to-jsx")))
    testImplementation(npm("karma", version("karma")))
}

kotlin.target {
    browser {
        distribution {
            directory = File("$rootDir/docs/")
        }
        webpackTask {
            cssSupport.enabled = true
//            cssSupport.mode = "import"
        }
        runTask {
            cssSupport.enabled = true
        }
    }
}
