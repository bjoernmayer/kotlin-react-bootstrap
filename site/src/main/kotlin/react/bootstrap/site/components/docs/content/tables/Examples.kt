@file:Suppress("NAME_SHADOWING", "DuplicatedCode", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.tables

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.external.Markdown
import react.dom.tbody
import react.dom.td
import react.dom.th
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
                thead {
                    tr {
                        th(ThScope.col) { +"#" }
                        th(ThScope.col) { +"First" }
                        th(ThScope.col) { +"Last" }
                        th(ThScope.col) { +"Handle" }
                    }
                }
                tbody {
                    tr {
                        th(ThScope.row) { +"1" }
                        td { +"Mark" }
                        td { +"Otto" }
                        td { +"@mdo" }
                    }
                    tr {
                        th(ThScope.row) { +"2" }
                        td { +"Jacob" }
                        td { +"Thornton" }
                        td { +"@fat" }
                    }
                    tr {
                        th(ThScope.row) { +"3" }
                        td { +"Larry" }
                        td { +"the Bird" }
                        td { +"@twitter" }
                    }
                }
            }
        }
        codeExample {
            import("content.tables.table")
            ln { }
            ktFun(RBuilder::table) {
                ktFun(RBuilder::thead) {
                    ktFun(RBuilder::tr) {
                        ktFun(
                            RBuilder::th,
                            style = FunStyle.INLINE_BLOCK,
                            args = mapOf(null to ThScope.col.kt)
                        ) { string("#") }
                        ktFun(
                            RBuilder::th,
                            style = FunStyle.INLINE_BLOCK,
                            args = mapOf(null to ThScope.col.kt)
                        ) { string("First") }
                        ktFun(
                            RBuilder::th,
                            style = FunStyle.INLINE_BLOCK,
                            args = mapOf(null to ThScope.col.kt)
                        ) { string("Last") }
                        ktFun(
                            RBuilder::th,
                            style = FunStyle.INLINE_BLOCK,
                            args = mapOf(null to ThScope.col.kt)
                        ) { string("Handle") }
                    }
                }
                ktFun(RBuilder::tbody) {
                    ktFun(RBuilder::tr) {
                        ktFun(
                            RBuilder::th,
                            style = FunStyle.INLINE_BLOCK,
                            args = mapOf(null to ThScope.row.kt)
                        ) { string("1") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("Mark") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("Otto") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("@mdo") }
                    }
                    ktFun(RBuilder::tr) {
                        ktFun(
                            RBuilder::th,
                            style = FunStyle.INLINE_BLOCK,
                            args = mapOf(null to ThScope.row.kt)
                        ) { string("2") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("Jacob") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("Thornton") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("@fat") }
                    }
                    ktFun(RBuilder::tr) {
                        ktFun(
                            RBuilder::th,
                            style = FunStyle.INLINE_BLOCK,
                            args = mapOf(null to ThScope.row.kt)
                        ) { string("3") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("Larry") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("the Bird") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("@twitter") }
                    }
                }
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
                thead {
                    tr {
                        th(ThScope.col) { +"#" }
                        th(ThScope.col) { +"First" }
                        th(ThScope.col) { +"Last" }
                        th(ThScope.col) { +"Handle" }
                    }
                }
                tbody {
                    tr {
                        th(ThScope.row) { +"1" }
                        td { +"Mark" }
                        td { +"Otto" }
                        td { +"@mdo" }
                    }
                    tr {
                        th(ThScope.row) { +"2" }
                        td { +"Jacob" }
                        td { +"Thornton" }
                        td { +"@fat" }
                    }
                    tr {
                        th(ThScope.row) { +"3" }
                        td { +"Larry" }
                        td { +"the Bird" }
                        td { +"@twitter" }
                    }
                }
            }
        }
        codeExample {
            import("content.tables.table")
            ln { }
            ktFun(RBuilder::table, args = mapOf("dark" to true)) {
                ktFun(RBuilder::thead) {
                    ktFun(RBuilder::tr) {
                        ktFun(
                            RBuilder::th,
                            style = FunStyle.INLINE_BLOCK,
                            args = mapOf(null to ThScope.col.kt)
                        ) { string("#") }
                        ktFun(
                            RBuilder::th,
                            style = FunStyle.INLINE_BLOCK,
                            args = mapOf(null to ThScope.col.kt)
                        ) { string("First") }
                        ktFun(
                            RBuilder::th,
                            style = FunStyle.INLINE_BLOCK,
                            args = mapOf(null to ThScope.col.kt)
                        ) { string("Last") }
                        ktFun(
                            RBuilder::th,
                            style = FunStyle.INLINE_BLOCK,
                            args = mapOf(null to ThScope.col.kt)
                        ) { string("Handle") }
                    }
                }
                ktFun(RBuilder::tbody) {
                    ktFun(RBuilder::tr) {
                        ktFun(RBuilder::th, args = mapOf(null to ThScope.row.kt)) { string("1") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("Mark") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("Otto") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("@mdo") }
                    }
                    ktFun(RBuilder::tr) {
                        ktFun(RBuilder::th, args = mapOf(null to ThScope.row.kt)) { string("2") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("Jacob") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("Thornton") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("@fat") }
                    }
                    ktFun(RBuilder::tr) {
                        ktFun(RBuilder::th, args = mapOf(null to ThScope.row.kt)) { string("3") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("Larry") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("the Bird") }
                        ktFun(RBuilder::td, style = FunStyle.INLINE_BLOCK) { string("@twitter") }
                    }
                }
            }
        }
    }
}
