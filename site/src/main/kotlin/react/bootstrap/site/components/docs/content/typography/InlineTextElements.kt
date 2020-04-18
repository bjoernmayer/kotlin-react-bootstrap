package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.bootstrap.content.typography.toMark
import react.bootstrap.content.typography.toSmall
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.*

fun RBuilder.inlineTextElements() {
    contentTitle { +"Inline text elements" }
    p {
        +"Styling for common inline HTML5 elements."
    }
    example {
        p {
            +"You can use the mark tag to "; mark { +"highlight" }; +" text."
        }
        p {
            del { +"This line of text is meant to be treated as deleted text." }
        }
        p {
            ins { +"This line of text is meant to be treated as an addition to the document." }
        }
        p {
            small { +"This line of text is meant to be treated as fine print." }
        }
        p {
            strong { +"This line rendered as bold text." }
        }
        p {
            em { +"This line rendered as italicized text." }
        }
    }
    kotlinExample {
        +"p {"; br { }
        +"    +\"You can use the mark tag to \";  mark { +\"highlight\" }; +\" text.\""; br { }
        +"}"; br { }
        +"p {"; br { }
        +"    del { +\"This line of text is meant to be treated as deleted text.\" }"; br { }
        +"}"; br { }
        +"p {"; br { }
        +"    ins { +\"This line of text is meant to be treated as an addition to the document.\" }"; br { }
        +"}"; br { }
        +"p {"; br { }
        +"    small { +\"This line of text is meant to be treated as fine print.\" }"; br { }
        +"}"; br { }
        +"p {"; br { }
        +"    strong { +\"This line rendered as bold text.\" }"; br { }
        +"}"; br { }
        +"p {"; br { }
        +"    em { +\"This line rendered as italicized text.\" }"; br { }
        +"}"; br { }
    }
    p {
        code { +".${RDOMBuilder<CommonAttributeGroupFacade>::toMark.name}()" }; +" and "
        code { +".${RDOMBuilder<CommonAttributeGroupFacade>::toSmall.name}()" }; +" extensions functions are also "
        +" available to apply the same styles as mark { } and small { } while avoiding any unwanted semantic "
        +"implications that the tags would bring."
    }
}
