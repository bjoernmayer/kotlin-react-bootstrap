package react.bootstrap.site.lib.codepoet

internal object IndentTool {
    private const val indent = "    "

    fun indentLines(context: String) =
        context
            .split("\n")
            .joinToString("\n") {
                if (it.isNotEmpty()) {
                    "${getIndent(1)}$it"
                } else {
                    it
                }
            }.run {
                if (endsWith("\n")) {
                    substringBeforeLast("\n")
                } else {
                    this
                }
            }

    fun getIndent(level: Int): String =
        buildString {
            for (x in 1..level) {
                append(indent)
            }
        }
}
