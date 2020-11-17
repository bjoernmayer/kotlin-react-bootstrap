package react.bootstrap.site.components.docs.content.reference

import react.RBuilder
import react.bootstrap.content.typography.heading.Heading
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
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
This creates a `${function.name}` using the given type **`T`**.
                    """
                }
                codeExample {
                    +FunSpec.builder(function, inline = true)
                        .addTypeParameter("T", DOMTag::class, true)
                        .nestedBy<RBuilder>()
                        .addParameter<String?>("classes", null)
                        .addParameter(
                            "props",
                            Generic(PropHandler::class, Generic(Heading.Props::class, "T").build()),
                            default = FunCall.builder(
                                PropHandler::class.simpleName!!,
                                style = FunCall.Style.INLINE
                            ).setEmptyLambdaArgument().build()
                        )
                        .addParameter("block", Generic(RDOMHandler::class, "T"))
                        .returns("ReactElement")
                        .build()
                }
            }
    }
}
