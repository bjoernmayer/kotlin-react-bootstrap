# Kotlin-React-Bootstrap
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)
![Java CI with Gradle](https://github.com/bjoernmayer/kotlin-react-bootstrap/workflows/Java%20CI%20with%20Gradle/badge.svg)

> [Bootstrap 4][bootstrap] components built with [Kotlin React][kotlin-react].

[bootstrap]: https://getbootstrap.com/
[kotlin-react]: https://github.com/JetBrains/kotlin-wrappers/tree/master/kotlin-react

## No release yet!
This README might make you think otherwise, but `kotlin-react-bootstrap` was not released, yet. 
First release version will be `0.1.0`.

## Setup
The library **will** be released on Github packages.

You need to authenticate in order to download from GitHub Packages.  
For that [generate a GitHub token here](https://github.com/settings/tokens/new) and select the `read:packages` scope.

Then, you need to add this repository:

```kotlin
// build.gradle.kts

repositories {
    // . . .
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/bjoernmayer/kotlin-react-bootstrap")
        credentials {
            username = "<< PUT YOUR GITHUB USERNAME HERE >>"
            password = "<< PUT YOUR GITHUB TOKEN HERE>>"
        }
    }
    // . . .
}
```

To start using `kotlin-react-bootstrap` in your Kotlin/JS project, add the following dependency to the `dependencies`
block inside your `build.gradle.kts` file:

```kotlin
// build.gradle.kts

dependencies {
    implementation("io.github.bjoernmayer:kotlin-react-bootstrap:<latest version>")
    // . . .
}
```

## Roadmap (WIP)
You can find the roadmap in the [ROADMAP.md](ROADMAP.md).
