package react.bootstrap.site.lib.codepoet

import react.bootstrap.lib.ClassNames

internal class Imports private constructor() {
    private val imports: MutableSet<String> = mutableSetOf()

    fun importClassNames() = addImport("lib.${ClassNames::class.simpleName}")

    fun addImport(import: String): Imports {
        imports.add(import)

        return this
    }

    fun addImport(parts: Collection<String>): Imports {
        imports.add(parts.joinToString("."))

        return this
    }

    fun addImport(part: String, vararg parts: String) =
        addImport(listOf(part, *parts))

    fun build() = buildString {
        appendLine(
            imports.sorted().joinToString("\n", postfix = "\n") {
                "import react.bootstrap.$it"
            }
        )
    }

    companion object {
        fun builder() = Imports()
    }
}
