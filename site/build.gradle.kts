@file:Suppress("EXPERIMENTAL_API_USAGE")

plugins {
    kotlin("js")
}

dependencies {
    implementation(project(":kotlin-react-bootstrap"))

    implementation(kotlinJsWrapper("react-router-dom"))

    implementation(npm("file-loader", version("file-loader")))
    implementation(npm("react-syntax-highlighter", version("react-syntax-highlighter")))
    implementation(npm("markdown-to-jsx", version("markdown-to-jsx")))
    implementation(npm("karma", version("karma")))
}

kotlin.js {
    browser {
        distribution {
            directory = File("$rootDir/docs/")
        }
    }
}
