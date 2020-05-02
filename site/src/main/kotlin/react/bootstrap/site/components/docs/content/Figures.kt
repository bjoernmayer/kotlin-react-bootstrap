@file:Suppress("NAME_SHADOWING")

package react.bootstrap.site.components.docs.content

import kotlinx.html.role
import kotlinx.html.unsafe
import react.RBuilder
import react.bootstrap.ariaLabel
import react.bootstrap.content.figures.figcaption
import react.bootstrap.content.figures.figure
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.contentPageLead
import react.bootstrap.site.components.docs.fixings.contentPageTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.bootstrap.site.external.Fragment
import react.dom.code
import react.dom.p
import react.dom.svg

internal fun RBuilder.figures() = Fragment {
    contentPageTitle("Figures")
    contentPageLead {
        +"Documentation and examples for displaying related images and text with the figure component in Bootstrap."
    }
    p {
        +"Anytime you need to display a piece of content—like an image with an optional caption, consider using a "
        code { +"figure { }" }; +"."
    }
    p {
        +"Use the included "; code { +"figure" }; +", "; code { +"img" }; +" and "; code { +"figcaption" }
        +" functions to provide some baseline styles for the HTML5 "; code { +"<figure>" }; +"and "
        code { +"<figcaption>" }; +" elements. Images in figures have no explicit size, so be sure to add set "
        code { +"img(fluid)" }; +" to "; code { +"true" }; +" to make it responsive."
    }
    example {
        figure {
            svg(classes = "bd-placeholder-img ${ClassNames.IMG_FLUID} ${ClassNames.FIGURE_IMG}") {
                attrs {
                    set("width", "400")
                    set("height", "300")
                    set("preserveAspectRatio", "xMidYMid slice")
                    set("focusable", true)
                    role = "img"
                    ariaLabel = "Placeholder: Responsive image"
                    unsafe {
                        raw(
                            "<rect width=\"100%\" height=\"100%\" fill=\"#868e96\"></rect>" +
                                "<text x=\"50%\" y=\"50%\" fill=\"#dee2e6\" dy=\".3em\">400x300</text>"
                        )
                    }
                }
            }
            figcaption {
                +"A caption for the above image."
            }
        }
    }
    codeBox {
        ln { +"import react.bootstrap.content.figures.figure" }
        ln { +"import react.bootstrap.content.figures.figcaption" }
        ln { +"import react.bootstrap.content.figures.img" }
        ln { }
        ktBlock(0, "figure") { il ->
            ln(il) {
                +"img(fluid = true, classes = \"\${${ClassNames.ROUNDED.kt}}\", src = \"...\", alt = \"...\") { }"
            }
            ktBlock(il, "figcaption") { il ->
                ln(il) { +"+\"A caption for the above image.\"" }
            }
        }
    }
}
