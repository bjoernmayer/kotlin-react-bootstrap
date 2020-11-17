package react.bootstrap.site.components.docs.layout.reference

import kotlinx.html.DIV
import react.RBuilder
import react.bootstrap.layout.grid.col.Col
import react.bootstrap.layout.grid.col.ColAttributes
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.row.Row
import react.bootstrap.layout.grid.row.RowAttributes
import react.bootstrap.layout.grid.row.row
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic

internal class RowCol : SectionComponent() {
    override val title: String = "Row & Col"

    override fun RBuilder.render() {
        sectionTitle()
        subSectionTitle(RBuilder::row.name)
        Markdown {
            //language=Markdown
            +"""
Creates a `${Row::class.nestedName}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::row)
                .nestedBy<RBuilder>()
                .addParameter<RowAttributes?>("all", null)
                .addParameter<RowAttributes?>("sm", null)
                .addParameter<RowAttributes?>("md", null)
                .addParameter<RowAttributes?>("lg", null)
                .addParameter<RowAttributes?>("xl", null)
                .addParameter("gutters", true)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic.builder<Row.Props<*>, DIV>().build()),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic.builder<RDOMHandler<*>, DIV>())
                .returns("ReactElement")
                .build()
        }
        Markdown {
            //language=Markdown
            +"""
Creates a generic `${Row::class.nestedName}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::row, inline = true)
                .nestedBy<RBuilder>()
                .addTypeParameter("T", DOMTag::class, true)
                .addParameter<RowAttributes?>("all", null)
                .addParameter<RowAttributes?>("sm", null)
                .addParameter<RowAttributes?>("md", null)
                .addParameter<RowAttributes?>("lg", null)
                .addParameter<RowAttributes?>("xl", null)
                .addParameter("gutters", true)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic(Row.Props::class, "T").build()),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic(RDOMHandler::class, "T"))
                .returns("ReactElement")
                .build()
        }

        subSectionTitle(RBuilder::col.name)
        Markdown {
            //language=Markdown
            +"""
Creates a `${Col::class.nestedName}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::col)
                .nestedBy<RBuilder>()
                .addParameter<ColAttributes?>("all", null)
                .addParameter<ColAttributes?>("sm", null)
                .addParameter<ColAttributes?>("md", null)
                .addParameter<ColAttributes?>("lg", null)
                .addParameter<ColAttributes?>("xl", null)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic.builder<Col.Props<*>, DIV>().build()),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic.builder<RDOMHandler<*>, DIV>())
                .returns("ReactElement")
                .build()
        }
        Markdown {
            //language=Markdown
            +"""
Creates a generic `${Col::class.nestedName}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::col, inline = true)
                .nestedBy<RBuilder>()
                .addTypeParameter("T", DOMTag::class, true)
                .addParameter<ColAttributes?>("all", null)
                .addParameter<ColAttributes?>("sm", null)
                .addParameter<ColAttributes?>("md", null)
                .addParameter<ColAttributes?>("lg", null)
                .addParameter<ColAttributes?>("xl", null)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic(Col.Props::class, "T").build()),
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
