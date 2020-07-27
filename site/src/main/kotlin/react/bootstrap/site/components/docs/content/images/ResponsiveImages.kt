package react.bootstrap.site.components.docs.content.images

import kotlinx.html.role
import kotlinx.html.unsafe
import react.RBuilder
import react.bootstrap.content.img
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.ariaLabel
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.Quoted
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.dom.svg

internal class ResponsiveImages : SectionComponent() {
    override val title: String = "Responsive images"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Images in Bootstrap are made responsive with `img(fluid = true)`.
            """
        }
        liveExample("bd-example-images") {
            svg(classes = "bd-placeholder-img bd-placeholder-img-lg ${ClassNames.IMG_FLUID}") {
                attrs {
                    set("width", "100%")
                    set("height", "250")
                    set("preserveAspectRatio", "xMidYMid slice")
                    set("focusable", true)
                    role = "img"
                    ariaLabel = "Placeholder: Responsive image"
                    unsafe {
                        raw(
                            "<rect width=\"100%\" height=\"100%\" fill=\"#868e96\"></rect>" +
                                "<text x=\"50%\" y=\"50%\" fill=\"#dee2e6\" dy=\".3em\">Responsive image</text>"
                        )
                    }
                }
            }
        }
        codeExample {
            import("content.img")
            ln { }
            ktFun(
                RBuilder::img,
                style = FunStyle.INLINE,
                args = mapOf(
                    "fluid" to true,
                    "alt" to Quoted("Responsive image"),
                    "src" to Quoted("...")
                )
            ) { }
        }
    }
}
