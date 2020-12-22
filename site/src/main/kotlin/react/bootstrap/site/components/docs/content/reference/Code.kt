package react.bootstrap.site.components.docs.content.reference

import kotlinx.html.PRE
import react.RBuilder
import react.bootstrap.content.pre
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic

internal class Code : SectionComponent() {
    override val title: String = "Code"

    override fun RBuilder.render() {
        sectionTitle()
        subSectionTitle("pre")
        Markdown {
            //language=Markdown
            +"""
Creates a scrollable `pre` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::pre)
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter<Boolean>("scrollable")
                .addParameter("block", Generic.builder<RDOMHandler<*>, PRE>())
                .returns("ReactElement")
                .build()
        }
    }
}
