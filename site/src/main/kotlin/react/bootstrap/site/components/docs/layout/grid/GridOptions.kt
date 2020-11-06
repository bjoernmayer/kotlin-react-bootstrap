package react.bootstrap.site.components.docs.layout.grid

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.content.tables.BorderStyles
import react.bootstrap.content.tables.table
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.dom.br
import react.dom.code
import react.dom.col
import react.dom.p
import react.dom.small
import react.dom.tbody
import react.dom.td
import react.dom.th
import react.dom.thead
import react.dom.tr

internal class GridOptions : SectionComponent() {
    override val title: String = "Grid options"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
While Bootstrap uses *em*s or *rem*s for defining most sizes, `px`s are used for grid breakpoints and container widths.
This is because the viewport width is in pixels and does not change with the font size.
            """
        }
        p {
            +"See how aspects of the Bootstrap grid system work across multiple devices with a handy table."
        }
        table(borderStyle = BorderStyles.BORDERED, striped = true) {
            thead {
                tr {
                    th { }
                    th(classes = "${ClassNames.TEXT_CENTER}") {
                        +"Extra small"; br { }
                        small { +"<576px" }
                    }
                    th(classes = "${ClassNames.TEXT_CENTER}") {
                        +"Small"; br { }
                        small { +"≥576px" }
                    }
                    th(classes = "${ClassNames.TEXT_CENTER}") {
                        +"Medium"; br { }
                        small { +"≥768px" }
                    }
                    th(classes = "${ClassNames.TEXT_CENTER}") {
                        +"Large"; br { }
                        small { +"≥992px" }
                    }
                    th(classes = "${ClassNames.TEXT_CENTER}") {
                        +"Extra Large"; br { }
                        small { +"≥1200px" }
                    }
                }
            }
            tbody {
                tr {
                    th(scope = ThScope.row, classes = "${ClassNames.TEXT_NOWRAP}") { +"Max container width" }
                    td { +"None (auto)" }
                    td { +"540px" }
                    td { +"720px" }
                    td { +"960px" }
                    td { +"1140px" }
                }
                tr {
                    th(scope = ThScope.row, classes = "${ClassNames.TEXT_NOWRAP}") { +"Function Argument" }
                    listOf("all", "sm", "md", "lg", "xl").forEach {
                        td {
                            code {
                                +FunCall.builder(RBuilder::col, FunCall.Style.INLINE)
                                    .addArgument(it, FunCall.Argument.PureValue(""))
                                    .build()
                            }
                        }
                    }
                }
                tr {
                    th(scope = ThScope.row, classes = "${ClassNames.TEXT_NOWRAP}") { +"# of columns" }
                    td { attrs { colSpan = "5" }; +"12" }
                }
                tr {
                    th(scope = ThScope.row, classes = "${ClassNames.TEXT_NOWRAP}") { +"Gutter width" }
                    td { attrs { colSpan = "5" }; +"30px (15px on each side of a column" }
                }
                tr {
                    th(scope = ThScope.row, classes = "${ClassNames.TEXT_NOWRAP}") { +"Nestable" }
                    td { attrs { colSpan = "5" }; +"Yes" }
                }
                tr {
                    th(scope = ThScope.row, classes = "${ClassNames.TEXT_NOWRAP}") { +"Column ordering" }
                    td { attrs { colSpan = "5" }; +"Yes" }
                }
            }
        }
    }
}
