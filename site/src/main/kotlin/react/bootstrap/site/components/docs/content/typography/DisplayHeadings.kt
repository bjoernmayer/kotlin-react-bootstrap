package react.bootstrap.site.components.docs.content.typography

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
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.external.Markdown
import react.dom.span
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
                                display(variants, { span { } }) {
                                    +"Display ${index + 1}"
                                }
                            }
                        }
                    }
                }
            }
        }
        codeExample {
            import("content.typography.${Display::class.simpleName}")
            import("content.typography.${RBuilder::display.name}")
            for (x in 1..3) {
                import("content.typography.${RBuilder::display.name}$x")
            }
            ln { }

            listOf(
                RBuilder::display1,
                RBuilder::display2,
                RBuilder::display3
            ).forEachIndexed { index, kFunction3 ->
                ktFun(kFunction3) {
                    ln("Display ${index + 1}")
                }
            }
            ln { +"// Or you use a more generic way" }
            ktFun(
                RBuilder::display4,
                args = mapOf("variant" to Display.Variants.DISPLAY_4.kt, "renderAs" to "{ span { } }")
            ) {
                ln("Display 4")
            }
        }
    }
}
