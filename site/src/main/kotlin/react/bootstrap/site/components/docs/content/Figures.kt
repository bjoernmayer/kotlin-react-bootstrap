@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content

import kotlinx.html.role
import kotlinx.html.unsafe
import react.RBuilder
import react.bootstrap.content.figures.figcaption
import react.bootstrap.content.figures.figure
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.ariaLabel
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.PageComponent
import react.bootstrap.site.components.docs.fixings.Quoted
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.external.Markdown
import react.dom.img
import react.dom.svg

internal class Figures : PageComponent() {
    override fun RBuilder.render() {
        pageTitle("Figures")
        pageLead {
            +"Documentation and examples for displaying related images and text with the figure component in Bootstrap."
        }
        Markdown {
            //language=Markdown
            +"""
Anytime you need to display a piece of content—like an image with an optional caption, consider using a `figure { }`.
            """
        }
        Markdown {
            //language=Markdown
            +"""
Use the included `figure` , `img` and `figcaption` functions to provide some baseline styles for the HTML5 elements.
Images in figures have no explicit size, so be sure to add the `img(fluid)` to `true` to make it responsive.
            """
        }
        liveExample {
            figure {
                svg(
                    "bd-placeholder-img ${ClassNames.IMG_FLUID} ${ClassNames.FIGURE_IMG} ${ClassNames.ROUNDED}"
                ) {
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
        codeExample {
            import("content.figures.figure")
            import("content.figures.figcaption")
            import("content.figures.img")
            importClassNames()
            ln { }
            ktFun(RBuilder::figure) {
                ktFun(
                    RBuilder::img,
                    style = FunStyle.INLINE_BLOCK,
                    args = mapOf(
                        "fluid" to true,
                        "classes" to Quoted("\${${ClassNames.ROUNDED.kt}}"),
                        "src" to Quoted("..."),
                        "alt" to Quoted("...")
                    )
                ) { }
                ktFun(RBuilder::figcaption) {
                    ln("A caption for the above image.")
                }
            }
        }
    }
}
