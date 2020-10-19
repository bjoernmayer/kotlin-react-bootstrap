@file:Suppress("DuplicatedCode", "NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports

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
            +Imports.builder()
                .addImport("content.tables.table")
                .build()

            +FunCall.builder(RBuilder::table)
                .addArgument("hoverable", true)
                .setLambdaArgument(defaultExample())
                .build()
            appendLine("")
            +FunCall.builder(RBuilder::table)
                .addArgument("hoverable", true)
                .addArgument("dark", true)
                .setLambdaArgument(defaultExample())
                .build()
        }
    }
}
