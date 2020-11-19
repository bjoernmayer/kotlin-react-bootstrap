@file:Suppress("DuplicatedCode", "NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import react.RBuilder
import react.bootstrap.content.tables.BorderStyles
import react.bootstrap.content.tables.table
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports

internal class BorderStyles : SectionComponent() {
    override val title: String = "Border styles"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
Use the `table(borderStyle)`-argument with the value `${BorderStyles.BORDERED.nestedName}` to get borders on all sides of the
table and cells. Or set the value to `${BorderStyles.BORDERLESS.nestedName}` for a table without borders.
            """
        }
        liveExample {
            table(borderStyle = BorderStyles.BORDERED) {
                defaultExample()
            }

            table(dark = true, borderStyle = BorderStyles.BORDERED) {
                defaultExample()
            }

            table(borderStyle = BorderStyles.BORDERLESS) {
                defaultExample()
            }

            table(dark = true, borderStyle = BorderStyles.BORDERLESS) {
                defaultExample()
            }
        }
        codeExample {
            +Imports.builder()
                .addImport("content.tables.${BorderStyles::class.simpleName}")
                .addImport("content.tables.table")
                .build()

            +FunCall.builder(RBuilder::table)
                .addArgument("borderStyle", BorderStyles.BORDERED)
                .setLambdaArgument(defaultExample())
                .build()
            appendLine("")
            +FunCall.builder(RBuilder::table)
                .addArgument("borderStyle", BorderStyles.BORDERED)
                .addArgument("dark", true)
                .setLambdaArgument(defaultExample())
                .build()
            appendLine("")
            +FunCall.builder(RBuilder::table)
                .addArgument("borderStyle", BorderStyles.BORDERLESS)
                .setLambdaArgument(defaultExample())
                .build()
            appendLine("")
            +FunCall.builder(RBuilder::table)
                .addArgument("borderStyle", BorderStyles.BORDERLESS)
                .addArgument("dark", true)
                .setLambdaArgument(defaultExample())
                .build()
        }
    }
}
