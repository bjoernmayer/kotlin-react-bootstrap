import org.gradle.api.Project

fun Project.kotlinJsWrapper(name: String): Any =
    "org.jetbrains:kotlin-$name:${version("kotlin-$name")}"
