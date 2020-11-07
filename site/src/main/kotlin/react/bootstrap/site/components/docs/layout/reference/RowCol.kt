package react.bootstrap.site.components.docs.layout.reference

import kotlinx.html.CommonAttributeGroupFacade
import react.RBuilder
import react.bootstrap.layout.grid.col.Col
import react.bootstrap.layout.grid.col.ColAttributes
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.row.Row
import react.bootstrap.layout.grid.row.RowAttributes
import react.bootstrap.layout.grid.row.row
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
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
                .addParameter(
                    "rendererTag",
                    Generic("KClass", CommonAttributeGroupFacade::class).apply { setVariance(Generic.Variance.OUT) },
                    true,
                    FunSpec.Parameter.NULL
                )
                .addParameter<String?>("classes", null)
                .addParameter("block", Generic("RHandler", Row.Props::class))
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
                .addParameter(
                    "rendererTag",
                    Generic("KClass", CommonAttributeGroupFacade::class).apply { setVariance(Generic.Variance.OUT) },
                    true,
                    FunSpec.Parameter.NULL
                )
                .addParameter<String?>("classes", null)
                .addParameter("block", Generic("RHandler", Col.Props::class))
                .returns("ReactElement")
                .build()
        }
    }
}
