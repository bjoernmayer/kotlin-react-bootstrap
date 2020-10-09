plugins {
    kotlin("js")
}

dependencies {
    api(kotlinJsWrapper("react"))
    api(kotlinJsWrapper("react-dom"))
}
