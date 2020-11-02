package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.lead.lead
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports

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
            +Imports.builder()
                .addImport("content.typography.lead.${RBuilder::lead.name}")
                .build()

            +FunCall.builder(RBuilder::lead)
                .setLambdaArgument(
                    plusString(
                        "Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non" +
                            " comm odo "
                    ),
                    "\n",
                    plusString("luctus.")

                )
                .build()
        }
    }
}
