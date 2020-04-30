package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.toTable
import react.bootstrap.content.typography.DisplayHeadings
import react.bootstrap.content.typography.display
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.fixings.kotlinExample
import react.bootstrap.site.components.docs.kt
import react.dom.br
import react.dom.p
import react.dom.span
import react.dom.strong
import react.dom.table
import react.dom.tbody
import react.dom.td
import react.dom.tr

fun RBuilder.displayHeadings() {
    contentTitle("Display headings") { }
    p {
        +"Traditional heading elements are designed to work best in the meat of your page content. When you need a "
        +"heading to stand out, consider using a "; strong { +"display heading" }; +"—a larger, slightly more "
        +"opinionated heading style."
    }
    example {
        table {
            toTable()
            tbody {
                tr {
                    td {
                        display(DisplayHeadings.DISPLAY_1, { span { } }) {
                            +"Display 1"
                        }
                    }
                }
                tr {
                    td {
                        display(DisplayHeadings.DISPLAY_2, { span { } }) {
                            +"Display 2"
                        }
                    }
                }
                tr {
                    td {
                        display(DisplayHeadings.DISPLAY_3, { span { } }) {
                            +"Display 3"
                        }
                    }
                }
                tr {
                    td {
                        span {
                            display(DisplayHeadings.DISPLAY_4, { span { } }) {
                                +"Display 4"
                            }
                        }
                    }
                }
            }
        }
    }
    kotlinExample {
        for (x in 1..3) {
            +"${RBuilder::display.name}$x {"; br { }
            +"    +\"Display $x\""; br { }
            +"}"; br { }
        }
        +"// Or you use a more generic way"; br { }
        +"${RBuilder::display.name}(${DisplayHeadings.DISPLAY_4.kt}, { span { } }) {"; br { }
        +"    +\"Display 4\""; br { }
        +"}"; br { }
    }
}
