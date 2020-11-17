package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.SPAN
import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.content.typography.display.Display
import react.bootstrap.content.typography.display.display
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.dom.tbody
import react.dom.td
import react.dom.tr

internal class DisplayHeadings : SectionComponent() {
    override val title: String = "Display headings"

    override fun RBuilder.render() {
        sectionTitle()
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
                                display<SPAN>(variants) {
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
                .addImport("content.typography.display.${Display::class.simpleName}")
                .apply {
                    for (x in 1..4) {
                        addImport("content.typography.display.display$x")
                    }
                }
                .build()

            repeat(4) {
                +FunCall.builder("display${it + 1}")
                    .addTypeParameter(SPAN::class)
                    .setLambdaArgument(
                        plusString("Display ${it + 1}")
                    )
                    .build()
            }
        }
    }
}
