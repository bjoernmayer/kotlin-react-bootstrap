package react.bootstrap.site.components.docs.content

import kotlinx.html.role
import kotlinx.html.unsafe
import react.RBuilder
import react.bootstrap.ariaLabel
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.contentPageLead
import react.bootstrap.site.components.docs.fixings.contentPageTitle
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.ln
import react.bootstrap.site.external.Fragment
import react.dom.br
import react.dom.code
import react.dom.p
import react.dom.svg

internal fun RBuilder.images() = Fragment {
    contentPageTitle("Images")
    contentPageLead {
        +"Documentation and examples for opting images into responsive behavior (so they never become larger than their"
        +" parent elements) and add lightweight styles to them"
    }
    contentTitle("Responsive images")
    p {
        +"Images in Bootstrap are made responsive with "; code { +"img(fluid = true)" }; +"."
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
        br { }
        ln { +"img(fluid = true, alt =\"Responsive image\", src = ...) { }" }
    }
    contentTitle("Image thumbnails")
    p {
        +"You can set the "; code { +"img(thumbnail)" }; +"-argument to true to give an image a rounded 1px border "
        +"appearance."
    }
    example("bd-example-images") {
        svg(classes = "bd-placeholder-img bd-placeholder-img-lg ${ClassNames.IMG_THUMBNAIL}") {
            attrs {
                set("width", "200")
                set("height", "200")
                set("preserveAspectRatio", "xMidYMid slice")
                set("focusable", true)
                role = "img"
                ariaLabel = "A generic square placeholder image with a white border around it, making it resemble a " +
                    "photograph taken with an old instant camera: 200x200"
                unsafe {
                    raw(
                        "<rect width=\"100%\" height=\"100%\" fill=\"#868e96\"></rect>" +
                            "<text x=\"50%\" y=\"50%\" fill=\"#dee2e6\" dy=\".3em\">200x200</text>"
                    )
                }
            }
        }
    }
    codeBox {
        ln { +"import react.bootstrap.content.img" }
        br { }
        ln { +"img(thumbnail = true, alt =\"Responsive image\", src = ...) { }" }
    }
}
