package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.mark
import react.bootstrap.content.typography.small
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ktIF
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.external.Markdown
import react.dom.p
import react.dom.span

internal class InlineTextElements : SectionComponent() {
    override val title: String = "Inline text elements"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Alternative implementations of `mark { }` and `small { }` are provided to apply the same styles while avoiding any
unwanted semantic implications that the tags would bring.
            """
        }
        liveExample {
            p {
                +"You can use the alternative mark to "; mark(RBuilder::span) { +"highlight" }; +" text."
            }
            p {
                small(RBuilder::span) { +"This line of text is meant to be treated as fine print." }
            }
        }
        codeExample {
            import("content.typography.mark")
            import("content.typography.small")
            ln { }
            ktB(0, "p") {
                ln(it) { +"+\"You can use the mark tag to \";  mark(RBuilder::span) { +\"highlight\" }; +\" text.\"" }
            }
            ktB(0, "p") {
                ktIF(it, "small", "RBuilder::span", "+\"This line of text is meant to be treated as fine print.\"")
            }
        }
    }
}
