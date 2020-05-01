package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.h1
import react.bootstrap.content.typography.h2
import react.bootstrap.content.typography.h3
import react.bootstrap.content.typography.h4
import react.bootstrap.content.typography.h5
import react.bootstrap.content.typography.h6
import react.bootstrap.content.typography.muted
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.dom.br
import react.dom.code
import react.dom.h3
import react.dom.p
import react.dom.small

internal fun RBuilder.headings() {
    contentTitle("Headings")
    p {
        +"Alternative implementations for "; code { +"h1 { }" }; +" through "; code { +"h6 { }" }; +" are provided,"
        +" for when you want to match the font styling of a heading but cannot use the associated HTML element."
    }
    example {
        h1(RBuilder::p) { +"h1. Bootstrap heading" }
        h2(RBuilder::p) { +"h2. Bootstrap heading" }
        h3(RBuilder::p) { +"h3. Bootstrap heading" }
        h4(RBuilder::p) { +"h4. Bootstrap heading" }
        h5(RBuilder::p) { +"h5. Bootstrap heading" }
        h6(RBuilder::p) { +"h6. Bootstrap heading" }
    }

    codeBox {
        for (x in 1..6) {
            ln { +"import react.bootstrap.content.typography.h$x" }
        }
        br { }
        for (x in 1..6) {
            ln { +"h$x(RBuilder::p) { +\"h$x. Bootstrap heading\" }" }
        }
    }
    contentTitle(RBuilder::h3, "Customizing headings")
    p {
        +"You can recreate the small secondary heading text from Bootstrap 3."
    }
    example {
        h3 {
            +"Fancy display heading "
            muted(RBuilder::small) { +"With faded secondary text" }
        }
    }
    codeBox {
        ln { +"import react.bootstrap.content.typography.muted" }
        br { }
        ktBlock(0, "h3") { il ->
            ln(il) { +"+\"Fancy display heading \"" }
            ln(il) { +"muted(RBuilder::small) { +\"With faded secondary text\" }" }
        }
    }
}
