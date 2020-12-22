package react.bootstrap.site.components.docs.content.reference

import kotlinx.html.TABLE
import kotlinx.html.TD
import kotlinx.html.TH
import kotlinx.html.THEAD
import kotlinx.html.TR
import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.BorderStyles
import react.bootstrap.content.tables.ContextualStyle
import react.bootstrap.content.tables.THeadStyles
import react.bootstrap.content.tables.table
import react.bootstrap.content.tables.td
import react.bootstrap.content.tables.th
import react.bootstrap.content.tables.thead
import react.bootstrap.content.tables.tr
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic

internal class Tables : SectionComponent() {
    override val title: String = "Tables"

    override fun RBuilder.render() {
        sectionTitle()
        subSectionTitle("table")
        Markdown {
            //language=Markdown
            +"""
Creates a `table` element and adds Bootstrap classes to it.
            """
        }
        codeExample {
            +FunSpec.builder(RBuilder::table)
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter("dark", false)
                .addParameter("striped", false)
                .addParameter<BorderStyles>("borderStyle", null)
                .addParameter("hoverable", false)
                .addParameter("small", false)
                .addParameter<Breakpoints>("responsive", null)
                .addParameter("block", Generic.builder<RDOMHandler<*>, TABLE>())
                .returns("ReactElement")
                .build()
        }

        subSectionTitle("thead")
        Markdown {
            //language=Markdown
            +"""
Creates a `thead` element.
            """.trimIndent()
        }
        codeExample {
            +FunSpec.builder(RBuilder::thead)
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter<THeadStyles>("style", null)
                .addParameter("block", Generic.builder<RDOMHandler<*>, THEAD>())
                .returns("ReactElement")
                .build()
        }

        subSectionTitle("tr")
        Markdown {
            //language=Markdown
            +"""
Creates a `tr` element.
            """.trimIndent()
        }
        codeExample {
            +FunSpec.builder(RBuilder::tr)
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter<ContextualStyle>("contextualStyle", null)
                .addParameter("block", Generic.builder<RDOMHandler<*>, TR>())
                .returns("ReactElement")
                .build()
        }

        subSectionTitle("th")
        Markdown {
            //language=Markdown
            +"""
Creates a `th` element.
            """.trimIndent()
        }
        codeExample {
            +FunSpec.builder(RBuilder::th)
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter<ContextualStyle>("contextualStyle", null)
                .addParameter<ThScope>("scope", null)
                .addParameter("block", Generic.builder<RDOMHandler<*>, TH>())
                .returns("ReactElement")
                .build()
        }

        subSectionTitle("td")
        Markdown {
            //language=Markdown
            +"""
Creates a `td` element.
            """.trimIndent()
        }
        codeExample {
            +FunSpec.builder(RBuilder::td)
                .nestedBy<RBuilder>()
                .addParameter<String?>("classes", null)
                .addParameter<ContextualStyle>("contextualStyle", null)
                .addParameter("block", Generic.builder<RDOMHandler<*>, TD>())
                .returns("ReactElement")
                .build()
        }
    }
}
