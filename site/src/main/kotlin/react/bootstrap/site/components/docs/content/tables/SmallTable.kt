@file:Suppress("DuplicatedCode", "NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown

internal class SmallTable : SectionComponent() {
    override val title: String = "Small table"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Set the `table(hoverable)`-argument to `true` to make tables more compact by cutting cell padding in half.
            """
        }
        liveExample {
            table(small = true) {
                defaultExample()
            }

            table(small = true, dark = true) {
                defaultExample()
            }
        }
        codeExample {
            import("content.tables.table")
            ln { }
            ktFun(RBuilder::table, args = mapOf("small" to true)) {
                defaultExample()
            }
            ln { }
            ktFun(RBuilder::table, args = mapOf("small" to true, "dark" to true)) {
                defaultExample()
            }
        }
    }
}
