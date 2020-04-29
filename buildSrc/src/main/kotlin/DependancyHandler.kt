import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.kotlinReact(reactVersion: String, version: String): Any =
    "org.jetbrains:kotlin-react:$reactVersion-$version"

fun DependencyHandler.kotlinReact(module: String, npmVersion: String, version: String): Any =
    "org.jetbrains:kotlin-react-$module:$npmVersion-$version"

fun DependencyHandler.kotlinx(module: String, version: String? = null): Any =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"

fun DependencyHandler.jetbrains(module: String, version: String): Any =
    "org.jetbrains:$module:$version"
