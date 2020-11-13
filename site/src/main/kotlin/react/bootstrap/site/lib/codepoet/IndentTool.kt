package react.bootstrap.site.lib.codepoet

internal object IndentTool {
    private const val indent = "    "

    fun indentLines(context: String, level: Int = 1) =
        context
            .split("\n")
            .joinToString("\n") {
                if (it.isNotEmpty()) {
                    "${getIndent(level)}$it"
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
