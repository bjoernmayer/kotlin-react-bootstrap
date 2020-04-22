package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.h1
import react.bootstrap.content.typography.h2
import react.bootstrap.content.typography.h3
import react.bootstrap.content.typography.h4
import react.bootstrap.content.typography.h5
import react.bootstrap.content.typography.h6
import react.bootstrap.content.typography.muted
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.br
import react.dom.code
import react.dom.h3
import react.dom.p
import react.dom.small

fun RBuilder.headings() {
    contentTitle { +"Headings" }
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

    kotlinExample {
        for (x in 1..6) {
            +"h$x(RBuilder::p) { +\"h$x. Bootstrap heading\" }"; br { }
        }
    }
    contentTitle(RBuilder::h3) { +"Customizing headings" }
    p {
        +"You can recreate the small secondary heading text from Bootstrap 3."
    }
    example {
        h3 {
            +"Fancy display heading "
            muted(RBuilder::small) { +"With faded secondary text" }
        }
    }
    kotlinExample {
        +"h3 {"; br { }
        +"    +\"Fancy display heading \""; br { }
        +"    muted(RBuilder::small) { +\"With faded secondary text\" }"; br { }
        +"}"
    }
}
