package react.bootstrap.site.lib.codepoet

import react.bootstrap.site.lib.codepoet.IndentTool.indentLines

class If private constructor(
    private val condition: String
) {
    private lateinit var content: String
    private var elseContent: String? = null

    fun setContent(content: String): If {
        this.content = content
        return this
    }

    fun setElseContent(content: String): If {
        elseContent = content
        return this
    }

    fun build() = buildString {
        appendLine("if ($condition) {")
        appendLine(indentLines(content))

        if (elseContent !== null) {
            appendLine("} else {")
            appendLine(indentLines(elseContent!!))
        }

        appendLine("}")
    }

    companion object {
        fun builder(condition: String) = If(condition)
    }
}
