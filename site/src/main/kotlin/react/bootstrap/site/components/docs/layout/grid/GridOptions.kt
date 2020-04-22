package react.bootstrap.site.components.docs.layout.grid

import kotlinx.html.ThScope
import react.RBuilder
import react.bootstrap.layout.grid.col
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.ColFun
import react.bootstrap.site.components.docs.contentTitle
import react.dom.br
import react.dom.code
import react.dom.p
import react.dom.small
import react.dom.table
import react.dom.tbody
import react.dom.td
import react.dom.th
import react.dom.thead
import react.dom.tr

fun RBuilder.gridOptions() {
    contentTitle { +"Grid options" }
    p {
        +"While Bootstrap uses "; code { +"em" }; +"s or "; code { +"rem" }; +"s for defining most sizes, "
        code { +"px" }; +"s are used for grid breakpoints and container widths. This is because the viewport width is "
        +"in pixels and does not change with the font size."
    }
    p {
        +"See how aspects of the Bootstrap grid system work across multiple devices with a handy table."
    }
    table("${ClassNames.TABLE} ${ClassNames.TABLE_BORDERED} ${ClassNames.TABLE_STRIPED}") {
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
            val colFun: ColFun = RBuilder::col
            tr {
                th(scope = ThScope.row, classes = "${ClassNames.TEXT_NOWRAP}") { +"Function Argument" }
                td { code { +"${colFun.name}(col = )" } }
                td { code { +"${colFun.name}(sm = )" } }
                td { code { +"${colFun.name}(md = )" } }
                td { code { +"${colFun.name}(lg = )" } }
                td { code { +"${colFun.name}(xl = )" } }
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
