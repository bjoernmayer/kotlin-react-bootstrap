package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.lead
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.external.Markdown

internal class Lead : SectionComponent() {
    override val title: String = "Lead"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Make a paragraph stand out by using `lead { }` instead.
            """
        }
        liveExample {
            lead {
                +"""
Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus.
                """
            }
        }
        codeExample {
            import("content.typography.${RBuilder::lead.name}")
            ln { }
            ktB(0, RBuilder::lead.name) {
                ln(it) { +"+\"\"\"" }
                ln(it + 1) {
                    +"Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non "
                    +"commodo"
                }
                ln(it + 1) { +"luctus." }
                ln(it) { +"\"\"\".trimIndent()" }
            }
        }
    }
}
