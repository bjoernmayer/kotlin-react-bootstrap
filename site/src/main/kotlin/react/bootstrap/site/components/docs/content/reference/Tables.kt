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
                .nestedBy(RBuilder::class)
                .addParameter("dark", Boolean::class, false, "false")
                .addParameter("striped", Boolean::class, false, "false")
                .addParameter("borderStyle", BorderStyles::class, true, FunSpec.Parameter.NULL)
                .addParameter("hoverable", Boolean::class, false, "false")
                .addParameter("small", Boolean::class, false, "false")
                .addParameter("responsive", Breakpoints::class, true, FunSpec.Parameter.NULL)
                .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                .addParameter("block", Generic("RDOMHandler", TABLE::class))
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
                .nestedBy(RBuilder::class)
                .addParameter("style", THeadStyles::class, true, FunSpec.Parameter.NULL)
                .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                .addParameter("block", Generic("RDOMHandler", THEAD::class))
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
                .nestedBy(RBuilder::class)
                .addParameter("contextualStyle", ContextualStyle::class, true, FunSpec.Parameter.NULL)
                .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                .addParameter("block", Generic("RDOMHandler", TR::class))
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
                .nestedBy(RBuilder::class)
                .addParameter("contextualStyle", ContextualStyle::class, true, FunSpec.Parameter.NULL)
                .addParameter("scope", ThScope::class, true, FunSpec.Parameter.NULL)
                .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                .addParameter("block", Generic("RDOMHandler", TH::class))
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
                .nestedBy(RBuilder::class)
                .addParameter("contextualStyle", ContextualStyle::class, true, FunSpec.Parameter.NULL)
                .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                .addParameter("block", Generic("RDOMHandler", TD::class))
                .returns("ReactElement")
                .build()
        }
    }
}
