package react.bootstrap.site.components.docs.content.reference

import kotlinx.html.LI
import kotlinx.html.UL
import react.RBuilder
import react.bootstrap.content.typography.ListItemStyles
import react.bootstrap.content.typography.ListStyles
import react.bootstrap.content.typography.li
import react.bootstrap.content.typography.ul
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic

internal class Lists : SectionComponent() {
    override val title: String = "Lists"

    override fun RBuilder.render() {
        sectionTitle()
        subSectionTitle(RBuilder::ul.name)
        Markdown {
            //language=Markdown
            +"""
Creates an `ul` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::ul)
                .nestedBy<RBuilder>()
                .addParameter<ListStyles>("listStyles")
                .addParameter<String?>("classes", null)
                .addParameter("block", Generic("RDOMHandler", UL::class))
                .returns("ReactElement")
                .build()
        }

        subSectionTitle(RBuilder::li.name)
        Markdown {
            //language=Markdown
            +"""
Creates an `li` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::li)
                .nestedBy<RBuilder>()
                .addParameter<ListItemStyles>("listItemStyles")
                .addParameter<String?>("classes", null)
                .addParameter("block", Generic("RDOMHandler", LI::class))
                .returns("ReactElement")
                .build()
        }
    }
}
