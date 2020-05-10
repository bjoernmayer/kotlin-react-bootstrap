package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.h1
import react.bootstrap.content.typography.h2
import react.bootstrap.content.typography.h3
import react.bootstrap.content.typography.h4
import react.bootstrap.content.typography.h5
import react.bootstrap.content.typography.h6
import react.bootstrap.content.typography.muted
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.external.Markdown
import react.dom.h3
import react.dom.p
import react.dom.small

internal class Headings : SectionComponent() {
    override val title: String = "Headings"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Alternative implementation for `h1 { }` through `h6 { }` are provided, for when you want to match the font styling of a
heading but cannot use the associated HTML element.
            """
        }
        liveExample {
            h1(RBuilder::p) { +"h1. Bootstrap heading" }
            h2(RBuilder::p) { +"h2. Bootstrap heading" }
            h3(RBuilder::p) { +"h3. Bootstrap heading" }
            h4(RBuilder::p) { +"h4. Bootstrap heading" }
            h5(RBuilder::p) { +"h5. Bootstrap heading" }
            h6(RBuilder::p) { +"h6. Bootstrap heading" }
        }

        codeExample {
            for (x in 1..6) {
                import("content.typography.h$x")
            }
            ln { }
            for (x in 1..6) {
                ktIB(0, "h$x", "RBuilder::p", "+\"h$x. Bootstrap heading\"")
            }
        }
        subSectionTitle("Customizing headings", section)
        p {
            +"You can recreate the small secondary heading text from Bootstrap 3."
        }
        liveExample {
            h3 {
                +"Fancy display heading "
                muted(RBuilder::small) { +"With faded secondary text" }
            }
        }
        codeExample {
            import("content.typography.muted")
            ln { }
            ktB(0, "h3") {
                ln(it) { +"+\"Fancy display heading \"" }
                ktIB(it, "muted", "RBuilder::small", "+\"With faded secondary text\"")
            }
        }
    }
}
