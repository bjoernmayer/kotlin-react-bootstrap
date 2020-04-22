package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.mark
import react.bootstrap.content.typography.small
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.br
import react.dom.code
import react.dom.p
import react.dom.span

fun RBuilder.inlineTextElements() {
    contentTitle { +"Inline text elements" }
    p {
        +"Alternative implementations of "; code { +"mark { }" }; +" and "; code { +"small { }" }; +" are provided to"
        +" to apply the same styles while avoiding any unwanted semantic implications that the tags would bring."
    }
    example {
        p {
            +"You can use the alternative mark to "; mark(RBuilder::span) { +"highlight" }; +" text."
        }
        p {
            small(RBuilder::span) { +"This line of text is meant to be treated as fine print." }
        }
    }
    kotlinExample {
        +"p {"; br { }
        +"    +\"You can use the mark tag to \";  mark(RBuilder::span) { +\"highlight\" }; +\" text.\""; br { }
        +"}"; br { }
        +"p {"; br { }
        +"    small(RBuilder::span) { +\"This line of text is meant to be treated as fine print.\" }"; br { }
        +"}"; br { }
    }
}
