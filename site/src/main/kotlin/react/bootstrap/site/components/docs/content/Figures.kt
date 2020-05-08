@file:Suppress("NAME_SHADOWING")

package react.bootstrap.site.components.docs.content

import kotlinx.html.role
import kotlinx.html.unsafe
import react.RBuilder
import react.bootstrap.lib.ariaLabel
import react.bootstrap.content.figures.figcaption
import react.bootstrap.content.figures.figure
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.fixings.PageComponent
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.dom.svg

internal class Figures : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Figures")
        pageLead {
            +"Documentation and examples for displaying related images and text with the figure component in Bootstrap."
        }
        formattedText {
            """
            Anytime you need to display a piece of content—like an image with an optional caption, consider using a
            <figure { }|code>.
        """.trimIndent()
        }
        formattedText {
            """
            Use the included <figure|code> , <img|code> and <figcaption|code> functions to provide some baseline styles
            for the HTML5 elements. Images in figures have no explicit size, so be sure to add the <img(fluid)|code> to
            <true|code> to make it responsive.
        """.trimIndent()
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
}
