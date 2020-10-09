import org.gradle.api.Project

fun Project.version(target: String): String =
    prop("${target}.version")
