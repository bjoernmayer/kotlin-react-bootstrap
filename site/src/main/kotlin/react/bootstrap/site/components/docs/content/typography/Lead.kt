package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.P
import react.RBuilder
import react.bootstrap.content.typography.lead
import react.bootstrap.content.typography.toLead
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.RDOMBuilder
import react.dom.br
import react.dom.code
import react.dom.p

fun RBuilder.lead() {
    contentTitle { +"Lead" }
    p {
        +"Make a paragraph stand out by using "; code { +"${RBuilder::lead.name} { }" }; +" instead. Or use "
        code { +".${RDOMBuilder<P>::toLead.name}()" }; +"."
    }
    example {
        lead {
            +"Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo "
            +"luctus."
        }
    }
    kotlinExample {
        +"${RBuilder::lead.name} {"; br { }
        +"    +\"Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non "
        +"commodo luctus.\""; br { }
        +"}"
    }
}
