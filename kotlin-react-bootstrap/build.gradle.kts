plugins {
    kotlin("js")
    id("maven-publish")
}

dependencies {
    api(kotlinJsWrapper("react"))
    api(kotlinJsWrapper("react-dom"))
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(kotlin.sourceSets.main.get().kotlin)
}

publishing {
    publications {
        create<MavenPublication>("kotlin") {
            from(components["kotlin"])
            artifact(tasks["sourcesJar"])
            pom {
                name.set("kotlin-react-bootstrap")
                description.set("Bootstrap components built with Kotlin React.")
                url.set("https://github.com/bjoernmayer/kotlin-react-bootstrap")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("bjoernmayer")
                        name.set("Björn Mayer")
                    }
                }
                scm {
                    url.set("https://github.com/bjoernmayer/kotlin-react-bootstrap.git")
                    connection.set("scm:git:git://github.com/bjoernmayer/kotlin-react-bootstrap.git")
                    developerConnection.set("scm:git:git://github.com/bjoernmayer/kotlin-react-bootstrap.git")
                }
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/bjoernmayer/kotlin-react-bootstrap")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
