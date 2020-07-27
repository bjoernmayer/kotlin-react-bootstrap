package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.SMALL
import react.RBuilder
import react.ReactElement
import react.bootstrap.content.typography.mark
import react.bootstrap.content.typography.small
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.dom.RDOMBuilder
import react.dom.p
import react.dom.small
import react.dom.span
import kotlin.reflect.KFunction3

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
            ktBlock("p") {
                ln { +"+\"You can use the mark tag to \";  mark(RBuilder::span) { +\"highlight\" }; +\" text.\"" }
            }
            val smallFun: KFunction3<RBuilder,  String?,  (RDOMBuilder<SMALL>.() -> Unit), ReactElement>
                = RBuilder::small
            ktBlock("p") {
                ktFun(smallFun, style = FunStyle.INLINE, args = mapOf(null to "RBuilder::span")) {
                    string("This line of text is meant to be treated as fine print.")
                }
            }
        }
    }
}
