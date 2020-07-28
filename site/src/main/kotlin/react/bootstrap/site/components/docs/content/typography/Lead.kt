package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.lead
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
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
            ktFun(RBuilder::lead) {
                multiline(
                    "Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non comm" +
                        "odo luctus."
                )
            }
        }
    }
}
