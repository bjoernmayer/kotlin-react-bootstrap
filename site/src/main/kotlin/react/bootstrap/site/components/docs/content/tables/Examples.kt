@file:Suppress("NAME_SHADOWING", "DuplicatedCode", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.dom.tbody
import react.dom.thead
import react.dom.tr

internal class Examples : SectionComponent() {
    override val title: String = "Examples"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Due to the widespread use of tables across third-party widgets like calendars and date pickers, Bootstrap has designed
their tables to be __opt-in__. Just use the `table { }` extension function provided with this library with its various
arguments to modify the table.
            """
        }
        Markdown {
            //language=Markdown
            +"""
Using the most basic table markup, here’s how `table { }`-based tables look in Bootstrap. __All table styles are
inherited in Bootstrap 4__, meaning any nested tables will be styled in the same manner as the parent.
            """
        }
        liveExample {
            table {
                defaultExample()
            }
        }
        codeExample {
            import("content.tables.table")
            ln { }
            ktFun(RBuilder::table) {
                defaultExample()
            }
        }
        Markdown {
            //language=Markdown
            +"""
You can also invert the colors - with light text on dark background - by setting `table(dark = true)`.
            """
        }
        liveExample {
            table(dark = true) {
                defaultExample()
            }
        }
        codeExample {
            import("content.tables.table")
            ln { }
            ktFun(RBuilder::table, args = mapOf("dark" to true)) {
                defaultExample()
            }
        }
    }
}
