package react.bootstrap.site.components.docs.content.reference

import react.RBuilder
import react.ReactElement
import react.bootstrap.content.typography.lead.Lead
import react.bootstrap.content.typography.lead.lead
import react.bootstrap.content.typography.mark.Mark
import react.bootstrap.content.typography.muted.Muted
import react.bootstrap.content.typography.small.Small
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
import kotlin.reflect.KFunction

internal class Other : SectionComponent() {
    override val title: String = "Other"

    override fun RBuilder.render() {
        sectionTitle()
        subSectionTitle(RBuilder::lead.name)
        Markdown {
            //language=Markdown
            +"""
Creates a `${Lead::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::lead)
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter("block", Generic("RHandler", Lead.Props::class))
                .returns("ReactElement")
                .build()
        }

        subSectionTitle("muted")
        Markdown {
            //language=Markdown
            +"""
Creates a generic `${Muted::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(
                object : KFunction<ReactElement> {
                    override val name: String = "muted"
                },
                inline = true
            )
                .nestedBy<RBuilder>()
                .addTypeParameter("T", DOMTag::class, true)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic(Muted.Props::class, "T").build()),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic(RDOMHandler::class, "T"))
                .returns("ReactElement")
                .build()
        }

        subSectionTitle("mark")
        Markdown {
            //language=Markdown
            +"""
Creates a generic `${Mark::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(
                object : KFunction<ReactElement> {
                    override val name: String = "mark"
                },
                inline = true
            )
                .nestedBy<RBuilder>()
                .addTypeParameter("T", DOMTag::class, true)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic(Mark.Props::class, "T").build()),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic(RDOMHandler::class, "T"))
                .returns("ReactElement")
                .build()
        }

        subSectionTitle("small")
        Markdown {
            //language=Markdown
            +"""
Creates a generic `${Small::class.simpleName!!}` element.
            """
        }
        codeExample {
            +FunSpec.builder(
                object : KFunction<ReactElement> {
                    override val name: String = "small"
                },
                inline = true
            )
                .nestedBy<RBuilder>()
                .addTypeParameter("T", DOMTag::class, true)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic(Small.Props::class, "T").build()),
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
