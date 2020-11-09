package react.bootstrap.site.components.docs.gettingstarted.introduction

import react.RBuilder
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown

internal class Installation : SectionComponent() {
    override val title: String = "Installation"
    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
This library is in its early stages and therefore only available via
[GitHub Packages](https://github.com/features/packages). You **must** have a GitHub account to be able to download it.
            """
        }

        subSectionTitle("Generate a GitHub token")
        Markdown {
            //language=Markdown
            +"""
You need to authenticate in order to download from GitHub Packages.
[Generate a GitHub token here](https://github.com/settings/tokens/new) and select the `read:packages` scope.
Save the token for later.
            """
        }
        subSectionTitle("Add the repository to your build.gradle.kts")
        codeExample {
            //language=kotlin
            +"""
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
            """
        }
        subSectionTitle("Dependency")
        Markdown {
            //language=Markdown
            +"""
To start using `kotlin-react-bootstrap` in your Kotlin/JS project, add the following dependency to the `dependencies`
block inside your `build.gradle.kts` file:
            """
        }
        codeExample {
            //language=Kotlin
            +"""
// build.gradle.kts

dependencies {
    implementation("io.github.bjoernmayer:kotlin-react-bootstrap:<latest version>")
    // . . .
}
            """
        }
    }
}
