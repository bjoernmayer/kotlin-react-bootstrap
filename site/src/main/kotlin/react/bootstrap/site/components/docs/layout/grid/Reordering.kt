package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.Offsets
import react.bootstrap.layout.grid.Orderings
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.ColFun
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.exampleRow
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.a
import react.dom.br
import react.dom.code
import react.dom.h3
import react.dom.h4
import react.dom.p
import react.dom.strong

fun RBuilder.reordering() {
    val colFun: ColFun = RBuilder::col
    val sizesName = Sizes::class.simpleName
    val offsetsName = Offsets::class.simpleName
    val orderingsName = Orderings::class.simpleName
    contentTitle { +"Reordering" }
    contentTitle(RBuilder::h3) {
        +"$orderingsName enum"
    }
    p {
        +"Use "; code { +"$orderingsName" }; +" values for controlling the "; strong { +"visual order" }
        +" of your content. The classes are responsive, so you can set the "; code { +"order" }; +" by breakpoint "
        +"(e.g., "; "" +
        code {
            +"all = $orderingsName.${Orderings.ORD_1.name}, md = $orderingsName.${Orderings.ORD_2.name}"
        }; +"). Includes support for 1 through 12 across all five grid tiers."
    }
    exampleRow {
        example {
            container {
                row {
                    col { +"First in DOM, no order applied" }
                    col(all = Orderings.ORD_12) { +" Second in DOM, with a larger order" }
                    col(all = Orderings.ORD_1) { +"Third in DOM, with an order of 1" }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${RBuilder::row.name} {"; br { }
            +"        ${colFun.name} { +\"First in DOM, no order applied\" }"; br { }
            +"        ${colFun.name}(all = $orderingsName.${Orderings.ORD_12.name}) { +\" Second in DOM, with a larger "
            +"order\" }"; br { }
            +"        ${colFun.name}(all = $orderingsName.${Orderings.ORD_1.name}) { +\"Third in DOM, with an order of "
            +"1\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3) {
        +"Offsetting columns"
    }
    p {
        +"You can offset grid columns in two ways: our "; code { +"$offsetsName" }; +" values and Bootstrap's "
        a("https://getbootstrap.com/docs/4.4/utilities/spacing/") { +"margin utilities" }; +". Grid classes are "
        +"sized to match columns while margins are more useful for quick layouts where the width of the offset is "
        +"variable."
    }
    contentTitle(RBuilder::h4) {
        +"$offsetsName enum"
    }
    p {
        +"Move columns to the right by setting "; code { +"$offsetsName" }; +" enum values. These increase the left "
        +"margin of a column by "; code { +"*" }; +" columns. For example, "
        code {
            +"md = $sizesName.${Sizes.SZ_4.name} off $offsetsName.${Offsets.OFF_4.name}"
        }
        +" moves "; code { +"${colFun.name}(md = $sizesName.${Sizes.SZ_4.name}) { }" }; +" over four columns."
    }
    exampleRow {
        example {
            container {
                row {
                    col(md = Sizes.SZ_4) { +"md = $sizesName.${Sizes.SZ_4.name}" }
                    col(md = Sizes.SZ_4 off Offsets.OFF_4) {
                        +"md = $sizesName.${Sizes.SZ_4.name} off $offsetsName.${Offsets.OFF_4.name}"
                    }
                }
                row {
                    for (x in 1..2) {
                        col(md = Sizes.SZ_3 off Offsets.OFF_3) {
                            +"md = $sizesName.${Sizes.SZ_3.name} off $offsetsName.${Offsets.OFF_3.name}"
                        }
                    }
                }
                row {
                    col(md = Sizes.SZ_6 off Offsets.OFF_3) {
                        +"md = $sizesName.${Sizes.SZ_6.name} off $offsetsName.${Offsets.OFF_3.name}"
                    }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${RBuilder::row.name} {"; br { }
            +"        ${colFun.name}(md = $sizesName.${Sizes.SZ_4.name}) { +\"md = $sizesName.${Sizes.SZ_4.name}\" }"
            br { }

            +"        ${colFun.name}(md = $sizesName.${Sizes.SZ_4.name} off $offsetsName.${Offsets.OFF_4.name}) { +\"md"
            +" = $sizesName.${Sizes.SZ_4.name} off $offsetsName.${Offsets.OFF_4.name}\" } "; br { }
            +"    }"; br { }

            +"    ${RBuilder::row.name} {"; br { }
            for (x in 1..2) {
                +"        ${colFun.name}(md = $sizesName.${Sizes.SZ_3.name} off $offsetsName.${Offsets.OFF_3.name}) { +"
                +"\"md = $sizesName.${Sizes.SZ_3.name} off $offsetsName.${Offsets.OFF_3.name}\" } "; br { }
            }
            +"    }"; br { }

            +"    ${RBuilder::row.name} {"; br { }
            +"        ${colFun.name}(md = $sizesName.${Sizes.SZ_6.name} off $offsetsName.${Offsets.OFF_3.name}) { +\""
            +"md = $sizesName.${Sizes.SZ_6.name} off $offsetsName.${Offsets.OFF_3.name}\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
}
