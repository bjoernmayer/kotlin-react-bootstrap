package react.bootstrap.site.components.docs.content.images

import kotlinx.html.role
import kotlinx.html.unsafe
import react.RBuilder
import react.bootstrap.lib.ariaLabel
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.ln
import react.dom.svg

internal class ResponsiveImages : SectionComponent() {
    override val title: String = "Responsive images"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            "Images in Bootstrap are made responsive with <img(fluid = true)|code>."
        }
        example("bd-example-images") {
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
        codeBox {
            ln { +"import react.bootstrap.content.img" }
            ln { }
            ln { +"img(fluid = true, alt =\"Responsive image\", src = ...) { }" }
        }
    }
}
