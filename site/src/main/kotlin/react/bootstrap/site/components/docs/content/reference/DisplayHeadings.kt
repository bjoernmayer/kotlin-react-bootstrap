package react.bootstrap.site.components.docs.content.reference

import kotlinx.html.HtmlInlineTag
import react.RBuilder
import react.ReactElement
import react.bootstrap.content.typography.display.Display
import react.bootstrap.content.typography.display.display1
import react.bootstrap.content.typography.display.display2
import react.bootstrap.content.typography.display.display3
import react.bootstrap.content.typography.display.display4
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
import kotlin.reflect.KFunction

internal class DisplayHeadings : SectionComponent() {
    override val title: String = "Display headings"

    override fun RBuilder.render() {
        sectionTitle(section)
        listOf(
            RBuilder::display1 to Display.Variants.DISPLAY_1,
            RBuilder::display2 to Display.Variants.DISPLAY_2,
            RBuilder::display3 to Display.Variants.DISPLAY_3,
            RBuilder::display4 to Display.Variants.DISPLAY_4,
        ).forEach { (function, variant) ->
            subSectionTitle(function.name, section)
            Markdown {
                //language=Markdown
                +"""
Creates a `${Display::class.simpleName!!}` element with variant set to `${variant.nestedName}`.
                """
            }
            codeExample {
                +FunSpec.builder(function, false)
                    .nestedBy(RBuilder::class)
                    .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                    .addParameter("block", Generic("RHandler", Display.Props::class))
                    .returns("ReactElement")
                    .build()
            }
        }

        subSectionTitle("display", section)
        Markdown {
            //language=Markdown
            +"""
Creates a `${Display::class.simpleName!!}` element using the given type `TT`.
            """
        }
        codeExample {
            +FunSpec.builder(
                object : KFunction<ReactElement> {
                    override val name: String = "display"
                },
                inline = true
            )
                .addTypeParameter("TT", HtmlInlineTag::class, true)
                .nestedBy(RBuilder::class)
                .addParameter("variant", Display.Variants::class)
                .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                .addParameter(
                    "block",
                    Generic("RHandler", Display.Props::class),
                    modifier = FunSpec.Parameter.Modifier.CROSSINLINE
                )
                .returns("ReactElement")
                .build()
        }
    }
}
