package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.content.typography.Display
import react.bootstrap.content.typography.display
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.formattedText
import react.dom.span
import react.dom.tbody
import react.dom.td
import react.dom.tr

internal class DisplayHeadings : SectionComponent() {
    override val title: String = "Display headings"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            """
                Traditional heading elements are designed to work best in the meat of your page content. When you need a
                heading to stand out, consider using a <display heading|strong> - a larger, slightly more opinionated
                heading style.
            """.trimIndent()
        }
        liveExample {
            table {
                tbody {
                    tr {
                        td {
                            display(Display.Variants.DISPLAY_1, { span { } }) {
                                +"Display 1"
                            }
                        }
                    }
                    tr {
                        td {
                            display(Display.Variants.DISPLAY_2, { span { } }) {
                                +"Display 2"
                            }
                        }
                    }
                    tr {
                        td {
                            display(Display.Variants.DISPLAY_3, { span { } }) {
                                +"Display 3"
                            }
                        }
                    }
                    tr {
                        td {
                            span {
                                display(Display.Variants.DISPLAY_4, { span { } }) {
                                    +"Display 4"
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

            for (x in 1..3) {
                ktB(0, "${RBuilder::display.name}$x") {
                    ln(it) { +"+\"Display $x\"" }
                }
            }
            ln { +"// Or you use a more generic way" }
            ktB(0, RBuilder::display.name, "variant" to Display.Variants.DISPLAY_4.kt, "renderAs" to "{ span { } }") {
                ln(it) { +"+\"Display 4\"" }
            }
        }
    }
}
