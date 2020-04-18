import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.kotlinReact(reactVersion: String, version: String): Any =
    "org.jetbrains:kotlin-react:$reactVersion-$version"

fun DependencyHandler.kotlinReact(module: String, reactVersion: String, version: String): Any =
    "org.jetbrains:kotlin-react-$module:$reactVersion-$version"

fun DependencyHandler.kotlinx(module: String, version: String? = null): Any =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"
