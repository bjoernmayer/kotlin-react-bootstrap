package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.ABBR
import kotlinx.html.title
import react.RBuilder
import react.bootstrap.content.typography.toInitialism
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.RDOMBuilder
import react.dom.abbr
import react.dom.br
import react.dom.code
import react.dom.p

fun RBuilder.abbreviations() {
    contentTitle { +"Abbreviations" }
    p {
        +"Stylized implementation of HTML’s <abbr> element for abbreviations and acronyms to show the expanded version "
        +"on hover. Abbreviations have a default underline and gain a help cursor to provide additional context on "
        +"hover and to users of assistive technologies."
    }
    p {
        +"Use "; code { +".${RDOMBuilder<ABBR>::toInitialism.name}" }; +" on an abbreviation  for a slightly smaller "
        +"font-size."
    }
    example {
        p {
            abbr { attrs { title = "attribute" }; +"attr" }
        }
        p {
            abbr { attrs { title = "HyperText Markup Language" }; +"HTML"; toInitialism() }
        }
    }
    kotlinExample {
        +"p {"; br { }
        +"    abbr { attrs { title = \"attribute\" }; +\"attr\" }"; br { }
        +"}"; br { }
        +"p {"; br { }
        +"    abbr { attrs { title = \"HyperText Markup Language\" }; +\"HTML\"; "
        +"${RDOMBuilder<ABBR>::toInitialism.name}() }"; br { }
        +"}"
    }
}
