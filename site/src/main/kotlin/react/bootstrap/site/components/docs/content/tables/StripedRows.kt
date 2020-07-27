@file:Suppress("DuplicatedCode", "NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown

internal class StripedRows : SectionComponent() {
    override val title: String = "Striped rows"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Use the `table(striped)`-argument to add zebra-striping to any table row within the tbody.
            """
        }
        liveExample {
            table(striped = true) {
                defaultExample()
            }
        }
        codeExample {
            import("content.tables.table")
            ln { }
            ktFun(RBuilder::table, args = mapOf("striped" to true)) {
                defaultExample()
            }
        }
    }
}
