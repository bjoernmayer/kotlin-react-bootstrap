package react.bootstrap.site.components.docs.content.images

import kotlinx.html.role
import kotlinx.html.unsafe
import react.RBuilder
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.ariaLabel
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.formattedText
import react.dom.svg

internal class ImageThumbnails : SectionComponent() {
    override val title: String = "Image thumbnails"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            """
            You can set the <img(thumbnail)|code>-argument to <true|code> to give an image a rounded 1px border
            appearance.
        """.trimIndent()
        }
        liveExample("bd-example-images") {
            svg(classes = "bd-placeholder-img bd-placeholder-img-lg ${ClassNames.IMG_THUMBNAIL}") {
                attrs {
                    set("width", "200")
                    set("height", "200")
                    set("preserveAspectRatio", "xMidYMid slice")
                    set("focusable", true)
                    role = "img"
                    ariaLabel =
                        "A generic square placeholder image with a white border around it, making it resemble a " +
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
        codeExample {
            import("content.img")
            ln { }
            ktIB(0, "img", "thumbnail" to "true", "alt" to "Responsive image", "src" to "...") { "" }
        }
    }
}
