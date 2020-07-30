plugins {
    kotlin("js") version "1.3.72"
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
}

group = "react"
version = "0.9"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))

    api(kotlinReact(Versions.REACT_VERSION, Versions.KOTLIN_JS_WRAPPERS))
    api(kotlinReact("dom", Versions.REACT_VERSION, Versions.KOTLIN_JS_WRAPPERS))
}

kotlin.target {
    browser { }
    useCommonJs()
}
