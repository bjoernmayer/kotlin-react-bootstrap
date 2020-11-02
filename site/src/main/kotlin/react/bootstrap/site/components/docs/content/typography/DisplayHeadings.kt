package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.SPAN
import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.content.typography.Display
import react.bootstrap.content.typography.display
import react.bootstrap.content.typography.display1
import react.bootstrap.content.typography.display2
import react.bootstrap.content.typography.display3
import react.bootstrap.content.typography.display4
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.bootstrap.site.lib.codepoet.KlazzValue
import react.bootstrap.site.lib.codepoet.LineComment
import react.dom.tbody
import react.dom.td
import react.dom.tr

internal class DisplayHeadings : SectionComponent() {
    override val title: String = "Display headings"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Traditional heading elements are designed to work best in the meat of your page content. When you need a heading to
stand out, consider using a __display heading__ - a larger, slightly more opinionated heading style.
            """
        }
        liveExample {
            table {
                tbody {
                    listOf(
                        Display.Variants.DISPLAY_1,
                        Display.Variants.DISPLAY_2,
                        Display.Variants.DISPLAY_3,
                        Display.Variants.DISPLAY_4
                    ).forEachIndexed { index, variants ->
                        tr {
                            td {
                                display(variants, rendererTag = SPAN::class) {
                                    +"Display ${index + 1}"
                                }
                            }
                        }
                    }
                }
            }
        }
        codeExample {
            +Imports.builder()
                .addImport("content.typography.${Display::class.simpleName}")
                .addImport("content.typography.${RBuilder::display.name}")
                .apply {
                    for (x in 1..3) {
                        addImport("content.typography.${RBuilder::display.name}$x")
                    }
                }
                .build()

            listOf(
                RBuilder::display1,
                RBuilder::display2,
                RBuilder::display3
            ).forEachIndexed { index, kFunction3 ->
                +FunCall.builder(kFunction3)
                    .setLambdaArgument(
                        plusString("Display ${index + 1}")
                    )
                    .build()
            }
            +LineComment.builder("Or you use a more generic way").build()
            +FunCall.builder(RBuilder::display4)
                .addArgument("variant", Display.Variants.DISPLAY_4)
                .addArgument("rendererTag", KlazzValue(SPAN::class))
                .setLambdaArgument(plusString("Display 4"))
                .build()
        }
    }
}
