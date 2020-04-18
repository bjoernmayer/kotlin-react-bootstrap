package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.bootstrap.content.typography.*
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.*

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
        code { +".${RDOMBuilder<CommonAttributeGroupFacade>::toH1.name}()" }; +" through "
        code { +".${RDOMBuilder<CommonAttributeGroupFacade>::toH6.name}()" }
        +" extension functions are also available, for when you want to match the font styling of a heading but "
        +"cannot use the associated HTML element."
    }
    example {
        p {
            +"h1. Bootstrap heading"
            toH1()
        }
        p {
            +"h2. Bootstrap heading"
            toH2()
        }
        p {
            +"h3. Bootstrap heading"
            toH3()
        }
        p {
            +"h4. Bootstrap heading"
            toH4()
        }
        p {
            +"h5. Bootstrap heading"
            toH5()
        }
        p {
            +"h6. Bootstrap heading"
            toH6()
        }
    }
    kotlinExample {
        for (x in 1..6) {
            +"p {"; br { }
            +"    +\"h$x. Bootstrap heading\""; br { }
            +"    ${RDOMBuilder<CommonAttributeGroupFacade>::toH1.name.replace('1', x.toChar())}()"; br { }
            +"}"; br { }
        }
    }
    contentTitle { +"Customizing headings"; toH3() }
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
