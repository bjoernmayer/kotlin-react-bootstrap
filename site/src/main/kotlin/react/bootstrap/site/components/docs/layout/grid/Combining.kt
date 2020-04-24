package react.bootstrap.site.components.docs.layout.grid

import react.RBuilder
import react.bootstrap.layout.container
import react.bootstrap.layout.grid.Offsets
import react.bootstrap.layout.grid.Orderings
import react.bootstrap.layout.grid.Sizes
import react.bootstrap.layout.grid.col
import react.bootstrap.layout.grid.row
import react.bootstrap.site.components.docs.ColFun
import react.bootstrap.site.components.docs.RowFun
import react.bootstrap.site.components.docs.contentTitle
import react.bootstrap.site.components.docs.example
import react.bootstrap.site.components.docs.exampleRow
import react.bootstrap.site.components.docs.kotlinExample
import react.dom.br
import react.dom.code
import react.dom.h3
import react.dom.p

fun RBuilder.combining() {
    val colFun: ColFun = RBuilder::col
    val rowFun: RowFun = RBuilder::row
    val sizes = Sizes::class.simpleName
    val sz4 = Sizes.SZ_4.name
    val szOrd = Sizes::ord.name
    val szOff = Sizes::off.name

    val offsets = Offsets::class.simpleName
    val off1 = Offsets.OFF_1.name
    val offSz = Offsets::sz.name
    val offOrd = Offsets::ord.name

    val orderings = Orderings::class.simpleName
    val ord3 = Orderings.ORD_3
    val ordSz = Orderings::sz.name
    val ordOff = Orderings::off.name

    contentTitle { +"$sizes, $offsets, $orderings" }
    p {
        +"As you can see in the examples above, all three values are set using the same arguments. Custom pairing "
        +"functions are used to combine the values."
    }
    contentTitle(RBuilder::h3) { +"$sizes <-> $offsets" }
    p {
        +"Combine "; code { +"$sizes" }; +" and "; code { +"$offsets" }; +" by using "; code { +szOff }; +", if"
        +" you want to combine a "; code { +"$sizes" }; +" and an "; code { +"$offsets" }; +". Use "
        code { +offSz }; +", if you want to combine an "; code { +"$offsets" }; +" and a "; code { +"$sizes" }
    }
    exampleRow {
        example {
            container {
                row {
                    col(all = Sizes.SZ_4 off Offsets.OFF_1) { +"all = $sizes.$sz4 $szOff $offsets.$off1" }
                    col(all = Offsets.OFF_1 sz Sizes.SZ_4) { +"all = $offsets.$off1 $offSz $sizes.$sz4" }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name} {"; br { }
            +"        ${colFun.name}(all = $sizes.$sz4 $szOff $offsets.$off1) { +\"all = $sizes.$sz4 $szOff "
            +"$offsets.$off1\" }"; br { }
            +"        ${colFun.name}(all = $offsets.$off1 $offSz $sizes.$sz4) { +\"all = $offsets.$off1 $offSz "
            +"$sizes.$sz4\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }

    contentTitle(RBuilder::h3) { +"$sizes <-> $orderings" }
    p {
        +"Combine "; code { +"$sizes" }; +" and "; code { +"$orderings" }; +" by using "; code { +szOrd }; +", "
        +"if you want to combine a "; code { +"$sizes" }; +" and an "; code { +"$orderings" }; +". Use "
        code { +ordSz }; +", if you want to combine an "; code { +"$orderings" }; +" and a "; code { +"$sizes" }
    }
    exampleRow {
        example {
            container {
                row {
                    col(all = Sizes.SZ_4 ord Orderings.ORD_3) { +"all = $sizes.$sz4 $szOrd $orderings.$off1" }
                    col(all = Orderings.ORD_3 sz Sizes.SZ_4) { +"all = $orderings.$off1 $ordSz $sizes.$sz4" }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    ${rowFun.name} {"; br { }
            +"        ${colFun.name}(all = $sizes.$sz4 $szOrd $orderings.$ord3) { +\"all = $sizes.$sz4 $szOrd "
            +"$orderings.$ord3\" }"; br { }
            +"        ${colFun.name}(all = $orderings.$ord3 $ordSz $sizes.$sz4) { +\"all = $orderings.$ord3 $ordSz "
            +"$sizes.$sz4\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }

    contentTitle(RBuilder::h3) { +"$offsets <-> $orderings" }
    p {
        +"Combine "; code { +"$offsets" }; +" and "; code { +"$orderings" }; +" by using "; code { +offOrd }
        +", if you want to combine an "; code { +"$offsets" }; +" and an "; code { +"$orderings" }; +". Use "
        code { +ordOff }; +", if you want to combine an "; code { +"$orderings" }; +" and an "
        code { +"$offsets" }
    }
    exampleRow {
        example {
            container {
                row {
                    col(all = Offsets.OFF_1 ord Orderings.ORD_3) {
                        +"all = $offsets.$off1 $offOrd $orderings.$off1"
                    }
                    col(all = Orderings.ORD_3 off Offsets.OFF_1) {
                        +"all = $orderings.$ord3 $ordOff $offsets.$off1"
                    }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} {"; br { }
            +"    row {"; br { }
            +"        ${colFun.name}(all = $offsets.$off1 $offOrd $orderings.$ord3) { +\"all = $offsets.$off1 $offOrd "
            +"$orderings.$ord3\" }"; br { }
            +"        ${colFun.name}(all = $orderings.$ord3 $ordOff $offsets.$off1) { +\"all = $orderings.$ord3 "
            +"$ordOff $offsets.$off1\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3) { +"$sizes <-> $offsets <-> $orderings" }
    p {
        +"Use the same pairing functions to combine all three in all different orders."
    }
    exampleRow {
        example {
            container {
                row {
                    col(all = Sizes.SZ_4 off Offsets.OFF_1 ord Orderings.ORD_3) {
                        +"all = $sizes.$sz4 $szOff $offsets.$off1 $offOrd $orderings.$ord3"
                    }
                }
                row {
                    col(all = Sizes.SZ_4 ord Orderings.ORD_3 off Offsets.OFF_1) {
                        +"all = $sizes.$sz4 $szOrd $orderings.$ord3 $ordOff $offsets.$off1"
                    }
                }
                row {
                    col(all = Offsets.OFF_1 sz Sizes.SZ_4 ord Orderings.ORD_3) {
                        +"all = $offsets.$off1 $offSz $sizes.$sz4 $szOrd $orderings.$ord3"
                    }
                }
                row {
                    col(all = Offsets.OFF_1 ord Orderings.ORD_3 sz Sizes.SZ_4) {
                        +"all = $offsets.$off1 $offOrd $orderings.$ord3 $ordSz $sizes.$sz4"
                    }
                }
                row {
                    col(all = Orderings.ORD_3 sz Sizes.SZ_4 off Offsets.OFF_1) {
                        +"all = $orderings.$ord3 $ordSz $sizes.$sz4 $szOff $offsets.$off1"
                    }
                }
                row {
                    col(all = Orderings.ORD_3 off Offsets.OFF_1 sz Sizes.SZ_4) {
                        +"all = $orderings.$ord3 $ordOff $offsets.$off1 $offSz $sizes.$sz4"
                    }
                }
            }
        }
        kotlinExample {
            +"${RBuilder::container.name} { "; br { }
            +"    ${rowFun.name} { "; br { }
            +"        ${colFun.name}(all = $sizes.$sz4 $szOff $offsets.$off1 $offOrd $orderings.$ord3) { "; br { }
            +"            +\"all = $sizes.$sz4 $szOff $offsets.$off1 $offOrd $orderings.$ord3\""; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"    ${rowFun.name} { "; br { }
            +"        ${colFun.name}(all = $sizes.$sz4 $szOrd $orderings.$ord3 $ordOff $offsets.$off1) {"; br { }
            +"            +\"all = $sizes.$sz4 $szOrd $orderings.$ord3 $ordOff $offsets.$off1\""; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"    ${rowFun.name} {"; br { }
            +"        ${colFun.name}($offsets.$off1 $offSz $sizes.$sz4 $szOrd $orderings.$ord3) {"; br { }
            +"            +\"all = $offsets.$off1 $offSz $sizes.$sz4 $szOrd $orderings.$ord3\""; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"    ${rowFun.name} {"; br { }
            +"        ${colFun.name}($offsets.$off1 $offOrd $orderings.$ord3 $ordSz $sizes.$sz4) {"; br { }
            +"            +\"all = $offsets.$off1 $offOrd $orderings.$ord3 $ordSz $sizes.$sz4\""; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"    ${rowFun.name} {"; br { }
            +"        ${colFun.name}(all = $orderings.$ord3 $ordSz $sizes.$sz4 $szOff $offsets.$off1) {"; br { }
            +"            +\"all = $orderings.$ord3 $ordSz $sizes.$sz4 $szOff $offsets.$off1\""; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"    ${rowFun.name} {"; br { }
            +"        ${colFun.name}(all = $orderings.$ord3 $ordOff $offsets.$off1 $offSz $sizes.$sz4) {"; br { }
            +"            +\"all = $orderings.$ord3 $ordOff $offsets.$off1 $offSz $sizes.$sz4\""; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
}
