package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.mark
import react.bootstrap.content.typography.small
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.dom.p
import react.dom.span

internal class InlineTextElements : SectionComponent() {
    override val title: String = "Inline text elements"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            """
            Alternative implementations of <mark { }|code> and <small { }|code> are provided to apply the same styles
            while avoiding any unwanted semantic implications that the tags would bring.
        """.trimIndent()
        }
        example {
            p {
                +"You can use the alternative mark to "; mark(RBuilder::span) { +"highlight" }; +" text."
            }
            p {
                small(RBuilder::span) { +"This line of text is meant to be treated as fine print." }
            }
        }
        codeBox {
            ln { +"import react.bootstrap.content.typography.mark" }
            ln { +"import react.bootstrap.content.typography.small" }
            ln { }
            ktBlock(0, "p") { il ->
                ln(il) { +"+\"You can use the mark tag to \";  mark(RBuilder::span) { +\"highlight\" }; +\" text.\"" }
            }
            ktBlock(0, "p") { il ->
                ln(il) { +"small(RBuilder::span) { +\"This line of text is meant to be treated as fine print.\" }" }
            }
        }
    }
}
