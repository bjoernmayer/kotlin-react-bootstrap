@file:Suppress("EXPERIMENTAL_API_USAGE")

plugins {
    kotlin("js")
    id("com.palantir.git-version").version("0.12.3")
    id("com.github.gmazzo.buildconfig")
}

dependencies {
    implementation(project(":kotlin-react-bootstrap"))

    implementation(kotlinJsWrapper("react"))
    implementation(kotlinJsWrapper("react-dom"))
    implementation(kotlinJsWrapper("react-router-dom"))

    implementation(npm("file-loader", version("file-loader")))
    implementation(npm("react-syntax-highlighter", version("react-syntax-highlighter")))
    implementation(npm("markdown-to-jsx", version("markdown-to-jsx")))
}

kotlin.js {
    browser {
        distribution {
            directory = File("$rootDir/docs/")
        }
        commonWebpackConfig {
            cssSupport.enabled = true
            cssSupport.mode = "inline"
        }
    }
}

val gitVersion: groovy.lang.Closure<*> by extra

// FIXME: The task for this needs to run before build
buildConfig {
    packageName("react.bootstrap.site")
    useKotlinOutput()

    buildConfigField("String", "VERSION", "\"${gitVersion() as String}\"")
}

kotlin {
    sourceSets.main {
        kotlin.srcDir(file("$buildDir/generated/source"))
    }
}
