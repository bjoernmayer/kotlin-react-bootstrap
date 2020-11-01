package react.bootstrap.site.lib.codepoet

class When private constructor(
    private val argument: String?
) : CodePoet {
    val branches = mutableMapOf<String, String>()

    fun addBranch(condition: String, content: String): When {
        branches[condition] = content

        return this
    }

    fun addElse(content: String): When {
        branches["else"] = content

        return this
    }

    override fun build(): String = buildString {
        append("when ")

        argument?.let {
            append("($argument) ")
        }

        appendLine("{")

        append(
            IndentTool.indentLines(
                buildString {
                    branches.forEach { (condition, content) ->
                        append(condition)
                        append(" -> ")
                        appendLine(content)
                    }
                }
            )
        )
        appendLine("\n}")
    }

    companion object {
        fun builder(argument: String? = null) = When(argument)
    }
}
