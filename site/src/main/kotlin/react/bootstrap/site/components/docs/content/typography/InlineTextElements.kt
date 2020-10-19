package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.SMALL
import react.RBuilder
import react.ReactElement
import react.bootstrap.content.typography.mark
import react.bootstrap.content.typography.small
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
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
            +Imports.builder()
                .addImport("content.typography.mark")
                .addImport("content.typography.small")
                .build()

            +FunCall.builder(RBuilder::p)
                .setLambdaArgument(
                    plusString("You can use the alternative mark to "),
                    "; ",
                    FunCall.builder("mark", FunCall.Style.INLINE, appendSemicolon = true)
                        .addArgument(FunCall.Argument.PureValue("RBuilder::span"))
                        .setLambdaArgument(plusString("highlight"))
                        .build(),
                    " ",
                    plusString(" text.")
                )
                .build()
            val smallFun: KFunction3<RBuilder, String?, (RDOMBuilder<SMALL>.() -> Unit), ReactElement> = RBuilder::small
            +FunCall.builder(RBuilder::p)
                .setLambdaArgument(
                    FunCall.builder(smallFun, FunCall.Style.INLINE)
                        .addArgument(FunCall.Argument.PureValue("RBuilder::span"))
                        .setLambdaArgument(
                            plusString("This line of text is meant to be treated as fine print.")
                        )
                        .build()
                )
                .build()
        }
    }
}
