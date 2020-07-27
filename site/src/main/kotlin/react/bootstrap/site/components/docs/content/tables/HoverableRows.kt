@file:Suppress("DuplicatedCode", "NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown

internal class HoverableRows : SectionComponent() {
    override val title: String = "Hoverable Rows"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Set the `table(hoverable)`-argument to `true` to enable a hover state on table rows within a tbody.
            """
        }
        liveExample {
            table(hoverable = true) {
                defaultExample()
            }

            table(hoverable = true, dark = true) {
                defaultExample()
            }
        }
        codeExample {
            import("content.tables.table")
            ln { }
            ktFun(RBuilder::table, args = mapOf("hoverable" to true)) {
                defaultExample()
            }
            ln { }
            ktFun(RBuilder::table, args = mapOf("hoverable" to true, "dark" to true)) {
                defaultExample()
            }
        }
    }
}
