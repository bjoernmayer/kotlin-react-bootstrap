package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.lead
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.dom.code
import react.dom.p

internal fun RBuilder.lead() {
    contentTitle("Lead")
    p {
        +"Make a paragraph stand out by using "; code { +"${RBuilder::lead.name} { }" }; +" instead."
    }
    example {
        lead {
            +"Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo "
            +"luctus."
        }
    }
    codeBox {
        ln { +"import react.bootstrap.content.typography.${RBuilder::lead.name}" }
        ln { }
        ktBlock(0, RBuilder::lead.name) { il ->
            ln(il) {
                +"+\"Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non "
                +"commodo luctus.\""
            }
        }
    }
}
