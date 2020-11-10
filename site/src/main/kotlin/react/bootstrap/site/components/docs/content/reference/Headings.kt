package react.bootstrap.site.components.docs.content.reference

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
import react.dom.h1
import react.dom.h2
import react.dom.h3
import react.dom.h4
import react.dom.h5
import react.dom.h6

internal class Headings : SectionComponent() {
    override val title: String = "Headings"

    override fun RBuilder.render() {
        sectionTitle()
        // Yes, those are the wrong headline funs. But as long as Kotlin does not support references to generic funs,
        // there is just no other way
        listOf(RBuilder::h1, RBuilder::h2, RBuilder::h3, RBuilder::h4, RBuilder::h5, RBuilder::h6)
            .forEach { function ->
                subSectionTitle(function.name)
                Markdown {
                    //language=Markdown
                    +"""
This creates a `${function.name}` using the given type **`TT`**.
                    """
                }
                codeExample {
                    +FunSpec.builder(function, inline = true)
                        .addTypeParameter("TT", CommonAttributeGroupFacade::class, true)
                        .nestedBy<RBuilder>()
                        .addParameter<String?>("classes", null)
                        .addParameter(
                            "block",
                            Generic("RDOMHandler", "TT"),
                            modifier = FunSpec.Parameter.Modifier.NOINLINE
                        )
                        .returns("ReactElement")
                        .build()
                }
            }
    }
}
