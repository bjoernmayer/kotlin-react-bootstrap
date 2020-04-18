package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.bootstrap.content.toTable
import react.bootstrap.content.typography.toDisplay1
import react.bootstrap.content.typography.toDisplay2
import react.bootstrap.content.typography.toDisplay3
import react.bootstrap.content.typography.toDisplay4
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.*

fun RBuilder.displayHeadings() {
    contentTitle { +"Display headings" }
    p {
        +"Traditional heading elements are designed to work best in the meat of your page content. When you need a "
        +"heading to stand out, consider using a "; strong { +"display heading" }; +"—a larger, slightly more "
        +"opinionated heading style. Keep in mind these headings are not responsive by default, but it’s possible to "
        +"enable responsive font sizes." // FIXME insert link here
    }
    example {
        table {
            toTable()
            tbody {
                tr {
                    td {
                        span {
                            +"Display 1"
                            toDisplay1()
                        }
                    }
                }
                tr {
                    td {
                        span {
                            +"Display 2"
                            toDisplay2()
                        }
                    }
                }
                tr {
                    td {
                        span {
                            +"Display 3"
                            toDisplay3()
                        }
                    }
                }
                tr {
                    td {
                        span {
                            +"Display 4"
                            toDisplay4()
                        }
                    }
                }
            }
        }
    }
    kotlinExample {
        for (x in 1..4) {
            +"h$x {"; br { }
            +"    +\"Display $x\""; br { }
            +"    ${RDOMBuilder<CommonAttributeGroupFacade>::toDisplay1.name.replace('1', x.toChar())}()"
            br { }
            +"}"; br { }
        }
    }
}
