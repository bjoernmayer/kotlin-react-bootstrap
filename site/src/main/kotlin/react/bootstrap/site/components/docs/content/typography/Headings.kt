package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.bootstrap.content.typography.h1
import react.bootstrap.content.typography.h2
import react.bootstrap.content.typography.h3
import react.bootstrap.content.typography.h4
import react.bootstrap.content.typography.h5
import react.bootstrap.content.typography.h6
import react.bootstrap.content.typography.toTextMuted
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.RDOMBuilder
import react.dom.br
import react.dom.code
import react.dom.h1
import react.dom.h2
import react.dom.h3
import react.dom.h4
import react.dom.h5
import react.dom.h6
import react.dom.p
import react.dom.small
import react.dom.table
import react.dom.tbody
import react.dom.td
import react.dom.th
import react.dom.thead
import react.dom.tr

fun RBuilder.headings() {
    contentTitle { +"Headings" }
    p {
        +"All HTML headings, "; code { +"h1 { }" }; +" through "; code { +"h6 { }" }; +", are available."
    }
    table {
        thead {
            tr {
                th { +"Heading" }
                th { +"Example" }
            }
        }
        tbody {
            tr {
                td { code { +"h1 { }" } }
                td { h1 { +"h1. Bootstrap heading" } }
            }
            tr {
                td { code { +"h2 { }" } }
                td { h2 { +"h2. Bootstrap heading" } }
            }
            tr {
                td { code { +"h3 { }" } }
                td { h3 { +"h3. Bootstrap heading" } }
            }
            tr {
                td { code { +"h4 { }" } }
                td { h4 { +"h4. Bootstrap heading" } }
            }
            tr {
                td { code { +"h5 { }" } }
                td { h5 { +"h5. Bootstrap heading" } }
            }
            tr {
                td { code { +"h6 { }" } }
                td { h6 { +"h6. Bootstrap heading" } }
            }
        }
    }
    kotlinExample {
        for (x in 1..6) {
            +"h$x { +\"h$x. Bootstrap heading\" }"; br { }
        }
    }
    p {
        +"Alternative implementations for "; code { +"h1 { }" }; +" through "; code { +"h6 { }" }; +" are also"
        +"available, for when you want to match the font styling of a heading but cannot use the associated HTML "
        +"element."
    }
    example {
        h1(RBuilder::p) { +"h1. Bootstrap heading" }
        h2(RBuilder::p) { +"h2. Bootstrap heading" }
        h3(RBuilder::p) { +"h3. Bootstrap heading" }
        h4(RBuilder::p) { +"h4. Bootstrap heading" }
        h5(RBuilder::p) { +"h5. Bootstrap heading" }
        h6(RBuilder::p) { +"h6. Bootstrap heading" }
    }

    kotlinExample {
        for (x in 1..6) {
            +"h$x(RBuilder::p) { +\"h$x. Bootstrap heading\" }"; br { }
        }
    }
    contentTitle(RBuilder::h3) { +"Customizing headings" }
    p {
        +"Use the included utility classes to recreate the small secondary heading text from Bootstrap 3."
    }
    example {
        h3 {
            +"Fancy display heading "
            small {
                +"With faded secondary text"
                toTextMuted()
            }
        }
    }
    kotlinExample {
        +"h3 {"; br { }
        +"    +\"Fancy display heading \""; br { }
        +"    small {"; br { }
        +"        +\"With faded secondary text\""; br { }
        +"        ${RDOMBuilder<CommonAttributeGroupFacade>::toTextMuted.name}()"; br { }
        +"    }"; br { }
        +"}"
    }
}
