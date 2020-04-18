package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.title
import react.RBuilder
import react.bootstrap.site.components.docs.contentTitle
import react.dom.abbr
import react.dom.p

fun RBuilder.blockquotes() {
    contentTitle { +"Blockquotes" }
    p {
        +"For quoting blocks of content from another source within your document. Wrap "
        +"around any "; abbr { attrs { title = "HyperText Markup Language" }; +"HTML" }; +" as the quote."
    }
}
