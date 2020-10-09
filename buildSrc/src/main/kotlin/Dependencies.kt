import org.gradle.api.Project

fun Project.kotlinJsWrapper(name: String): Any =
    "org.jetbrains:kotlin-$name:${version("kotlin-$name")}"

//
//fun Project.kotlinReact(reactVersion: String, version: String): Any =
//    "org.jetbrains:kotlin-react:$reactVersion-$version"
//
//fun Project.kotlinReact(module: String, npmVersion: String, version: String): Any =
//    "org.jetbrains:kotlin-react-$module:$npmVersion-$version"
//
//fun Project.kotlinx(module: String, version: String? = null): Any =
//    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"
//
//fun Project.jetbrains(module: String, version: String): Any =
//    "org.jetbrains:$module:$version"
//
//private fun Project.kotlinx(projectName: String, name: String): String =
//    "org.jetbrains.kotlinx:$projectName-$name:${version(projectName)}"


//Ausgabe org.jetbrains.kotlin-react:16.13.1-pre.124-kotlin-1.4.10
// implementation 'org.jetbrains:kotlin-react:16.13.1-pre.123-kotlin-1.4.10'
