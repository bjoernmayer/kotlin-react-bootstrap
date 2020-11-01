package react.bootstrap.site.lib.codepoet

internal class LineComment private constructor(private val content: String) : CodePoet {
    override fun build() = "// $content\n"

    companion object {
        fun builder(comment: String) = LineComment(comment)
    }
}
