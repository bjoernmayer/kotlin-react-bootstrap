@file:Suppress("DuplicatedCode", "NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import react.RBuilder
import react.bootstrap.content.tables.BorderStyles
import react.bootstrap.content.tables.table
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall

internal class BorderStyles : SectionComponent() {
    override val title: String = "Border styles"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Use the `table(borderStyle)`-argument with the value `${BorderStyles.BORDERED.kt}` to get borders on all sides of the
table and cells. Or set the value to `${BorderStyles.BORDERLESS.kt}` for a table without borders.
            """
        }
        liveExample {
            table(borderStyle = BorderStyles.BORDERED) {
                defaultExample()
            }

            table(borderStyle = BorderStyles.BORDERED, dark = true) {
                defaultExample()
            }

            table(borderStyle = BorderStyles.BORDERLESS) {
                defaultExample()
            }

            table(borderStyle = BorderStyles.BORDERLESS, dark = true) {
                defaultExample()
            }
        }
        codeExample {
            import("content.tables.${BorderStyles::class.simpleName}")
            import("content.tables.table")
            ln { }
            +FunCall.builder(RBuilder::table)
                .addArgument("borderStyle", BorderStyles.BORDERED)
                .setLambdaArgument(defaultExample())
                .build()
            ln { }
            +FunCall.builder(RBuilder::table)
                .addArgument("borderStyle", BorderStyles.BORDERED)
                .addArgument("dark", true)
                .setLambdaArgument(defaultExample())
                .build()
            ln { }
            +FunCall.builder(RBuilder::table)
                .addArgument("borderStyle", BorderStyles.BORDERLESS)
                .setLambdaArgument(defaultExample())
                .build()
            ln { }
            +FunCall.builder(RBuilder::table)
                .addArgument("borderStyle", BorderStyles.BORDERLESS)
                .addArgument("dark", true)
                .setLambdaArgument(defaultExample())
                .build()
        }
    }
}
