package react.bootstrap.site.components.docs.content.reference

import kotlinx.html.IMG
import react.RBuilder
import react.bootstrap.content.img
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic

internal class Images : SectionComponent() {
    override val title: String = "Images"

    override fun RBuilder.render() {
        sectionTitle()

        subSectionTitle("img")
        Markdown {
            //language=Markdown
            +"""
Creates an `img` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::img)
                .nestedBy<RBuilder>()
                .addParameter<String?>("alt", null)
                .addParameter<String?>("src", null)
                .addParameter<String?>("classes", null)
                .addParameter("fluid", false)
                .addParameter("isThumbnail", false)
                .addParameter("block", Generic.builder<RDOMHandler<*>, IMG>())
                .returns("ReactElement")
                .build()
        }
    }
}
