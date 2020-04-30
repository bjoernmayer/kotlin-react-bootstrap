package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.table
import react.bootstrap.content.typography.Display
import react.bootstrap.content.typography.display
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.dom.br
import react.dom.p
import react.dom.span
import react.dom.strong
import react.dom.tbody
import react.dom.td
import react.dom.tr

internal fun RBuilder.displayHeadings() {
    contentTitle("Display headings")
    p {
        +"Traditional heading elements are designed to work best in the meat of your page content. When you need a "
        +"heading to stand out, consider using a "; strong { +"display heading" }; +"—a larger, slightly more "
        +"opinionated heading style."
    }
    example {
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
    codeBox {
        ln { +"import react.bootstrap.content.typography.${Display::class.simpleName}" }
        ln { +"import react.bootstrap.content.typography.${RBuilder::display.name}" }
        for (x in 1..3) {
            ln { +"import react.bootstrap.content.typography.${RBuilder::display.name}$x" }
        }
        br { }

        for (x in 1..3) {
            ktBlock(0, "${RBuilder::display.name}$x") { il ->
                ln(il) { +"+\"Display $x\"" }
            }
        }
        ln { +"// Or you use a more generic way" }
        ktBlock(0, "${RBuilder::display.name}(${Display.Variants.DISPLAY_4.kt}, { span { } })") { il ->
            ln(il) { +"+\"Display 4\"" }
        }
    }
}
