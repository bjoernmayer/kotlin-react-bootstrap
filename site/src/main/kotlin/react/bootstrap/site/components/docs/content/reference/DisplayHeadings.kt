package react.bootstrap.site.components.docs.content.reference

import kotlinx.html.HtmlInlineTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.content.typography.display.Display
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
import kotlin.reflect.KFunction

internal class DisplayHeadings : SectionComponent() {
    override val title: String = "Display headings"

    override fun RBuilder.render() {
        sectionTitle()
        listOf(
            Display.Variants.DISPLAY_1,
            Display.Variants.DISPLAY_2,
            Display.Variants.DISPLAY_3,
            Display.Variants.DISPLAY_4,
        ).forEachIndexed { index, variant ->
            subSectionTitle("display${index + 1}")
            Markdown {
                //language=Markdown
                +"""
Creates a `${Display::class.simpleName!!}` element with variant set to `${variant.nestedName}`.
                """
            }
            codeExample {
                +FunSpec.builder(
                    object : KFunction<ReactElement> {
                        override val name: String = "display${index + 1}"
                    },
                    inline = true
                )
                    .nestedBy<RBuilder>()
                    .addTypeParameter("T", HtmlInlineTag::class, true)
                    .addParameter<String?>("classes", null)
                    .addParameter(
                        "props",
                        Generic(PropHandler::class, Generic(Display.Props::class, "T").build()),
                        default = FunCall.builder(
                            PropHandler::class.simpleName!!,
                            style = FunCall.Style.INLINE
                        ).setEmptyLambdaArgument().build()
                    )
                    .addParameter("block", Generic(RDOMHandler::class, "T"))
                    .returns("ReactElement")
                    .build()
            }
        }
    }
}
