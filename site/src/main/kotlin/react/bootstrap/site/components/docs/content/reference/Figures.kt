package react.bootstrap.site.components.docs.content.reference

import kotlinx.html.FIGURE
import kotlinx.html.IMG
import react.RBuilder
import react.bootstrap.content.figures.figure
import react.bootstrap.content.img
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
import react.dom.RDOMBuilder

internal class Figures : SectionComponent() {
    override val title: String = "Figures"

    override fun RBuilder.render() {
        sectionTitle()

        subSectionTitle("figure")
        Markdown {
            //language=Markdown
            +"""
Creates a `figure` element and adds `${ClassNames.FIGURE.nestedName}` to it.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::figure)
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter("block", Generic("RDOMHandler", FIGURE::class))
                .returns("ReactElement")
                .build()
        }

        subSectionTitle("img")
        Markdown {
            //language=Markdown
            +"""
Creates an `img` element and adds `${ClassNames.FIGURE_IMG.nestedName}` to it.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::img)
                .nestedByGeneric<RDOMBuilder<*>, FIGURE>()
                .addParameter("fluid", false)
                .addParameter("isThumbnail", false)
                .addParameter<String?>("alt", null)
                .addParameter<String?>("src", null)
                .addParameter<String?>("classes", null)
                .addParameter("block", Generic("RDOMHandler", IMG::class))
                .returns("ReactElement")
                .build()
        }
    }
}
