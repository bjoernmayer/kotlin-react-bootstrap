package react.bootstrap.site.lib.codepoet

internal data class LambdaValue(val content: String, val style: Style = Style.BLOCK) : CodePoet {
    override fun build(): String = buildString {
        if (style == Style.INLINE) {
            append("{ ")
            append(content)

            if (content.isNotEmpty()) {
                append(" ")
            }

            append("}")
        }
        if (style == Style.BLOCK) {
            appendLine("{")
            appendLine(IndentTool.indentLines(content))
            appendLine("}")
        }

        if (style == Style.ARGUMENT_BLOCK) {
            appendLine("{")
            appendLine(IndentTool.indentLines(content, 2))
            append(IndentTool.getIndent(1))
            append("}")
        }
    }

    internal enum class Style {
        INLINE,
        BLOCK,
        ARGUMENT_BLOCK
    }
}
