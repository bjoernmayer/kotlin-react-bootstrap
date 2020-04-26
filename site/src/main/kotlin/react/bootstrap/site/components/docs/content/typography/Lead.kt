package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.lead
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.fixings.kotlinExample
import react.dom.br
import react.dom.code
import react.dom.p

fun RBuilder.lead() {
    contentTitle("Lead") { }
    p {
        +"Make a paragraph stand out by using "; code { +"${RBuilder::lead.name} { }" }; +" instead."
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
