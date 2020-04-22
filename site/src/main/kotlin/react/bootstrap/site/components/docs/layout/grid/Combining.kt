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
import react.dom.br
import react.dom.code
import react.dom.h3
import react.dom.p

fun RBuilder.combining() {
    val colFun: ColFun = RBuilder::col
    val sizesName = Sizes::class.simpleName
    val sz4 = Sizes.SZ_4.name
    val szOrd = Sizes::ord.name
    val szOff = Sizes::off.name

    val offsetsName = Offsets::class.simpleName
    val off1 = Offsets.OFF_1.name
    val offSz = Offsets::sz.name
    val offOrd = Offsets::ord.name

    val orderingsName = Orderings::class.simpleName
    val ord3 = Orderings.ORD_3
    val ordSz = Orderings::sz.name
    val ordOff = Orderings::off.name

    contentTitle { +"$sizesName, $offsetsName, $orderingsName" }
    p {
        +"As you can see in the examples above, all three values are set using the same arguments. Custom pairing "
        +"functions are used to combine the values."
    }
    contentTitle(RBuilder::h3) { +"$sizesName <-> $offsetsName" }
    p {
        +"Combine "; code { +"$sizesName" }; +" and "; code { +"$offsetsName" }; +" by using "; code { +szOff }; +", if"
        +" you want to combine a "; code { +"$sizesName" }; +" and an "; code { +"$offsetsName" }; +". Use "
        code { +offSz }; +", if you want to combine an "; code { +"$offsetsName" }; +" and a "; code { +"$sizesName" }
    }
    exampleRow {
        example {
            container {
                row {
                    col(all = Sizes.SZ_4 off Offsets.OFF_1) { +"all = $sizesName.$sz4 $szOff $offsetsName.$off1" }
                    col(all = Offsets.OFF_1 sz Sizes.SZ_4) { +"all = $offsetsName.$off1 $offSz $sizesName.$sz4" }
                }
            }
        }
        kotlinExample {
            +"container {"; br { }
            +"    row {"; br { }
            +"        col(all = $sizesName.$sz4 $szOff $offsetsName.$off1) { +\"all = $sizesName.$sz4 $szOff "
            +"$offsetsName.$off1\" }"; br { }
            +"        col(all = $offsetsName.$off1 $offSz $sizesName.$sz4) { +\"all = $offsetsName.$off1 $offSz "
            +"$sizesName.$sz4\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }

    contentTitle(RBuilder::h3) { +"$sizesName <-> $orderingsName" }
    p {
        +"Combine "; code { +"$sizesName" }; +" and "; code { +"$orderingsName" }; +" by using "; code { +szOrd }; +", "
        +"if you want to combine a "; code { +"$sizesName" }; +" and an "; code { +"$orderingsName" }; +". Use "
        code { +ordSz }; +", if you want to combine an "; code { +"$orderingsName" }; +" and a "; code { +"$sizesName" }
    }
    exampleRow {
        example {
            container {
                row {
                    col(all = Sizes.SZ_4 ord Orderings.ORD_3) { +"all = $sizesName.$sz4 $szOrd $orderingsName.$off1" }
                    col(all = Orderings.ORD_3 sz Sizes.SZ_4) { +"all = $orderingsName.$off1 $ordSz $sizesName.$sz4" }
                }
            }
        }
        kotlinExample {
            +"container {"; br { }
            +"    row {"; br { }
            +"        col(all = $sizesName.$sz4 $szOrd $orderingsName.$ord3) { +\"all = $sizesName.$sz4 $szOrd "
            +"$orderingsName.$ord3\" }"; br { }
            +"        col(all = $orderingsName.$ord3 $ordSz $sizesName.$sz4) { +\"all = $orderingsName.$ord3 $ordSz "
            +"$sizesName.$sz4\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }

    contentTitle(RBuilder::h3) { +"$offsetsName <-> $orderingsName" }
    p {
        +"Combine "; code { +"$offsetsName" }; +" and "; code { +"$orderingsName" }; +" by using "; code { +offOrd }
        +", if you want to combine an "; code { +"$offsetsName" }; +" and an "; code { +"$orderingsName" }; +". Use "
        code { +ordOff }; +", if you want to combine an "; code { +"$orderingsName" }; +" and an "
        code { +"$offsetsName" }
    }
    exampleRow {
        example {
            container {
                row {
                    col(all = Offsets.OFF_1 ord Orderings.ORD_3) {
                        +"all = $offsetsName.$off1 $offOrd $orderingsName.$off1"
                    }
                    col(all = Orderings.ORD_3 off Offsets.OFF_1) {
                        +"all = $orderingsName.$ord3 $ordOff $offsetsName.$off1"
                    }
                }
            }
        }
        kotlinExample {
            +"container {"; br { }
            +"    row {"; br { }
            +"        col(all = $offsetsName.$off1 $offOrd $orderingsName.$ord3) { +\"all = $offsetsName.$off1 $offOrd "
            +"$orderingsName.$ord3\" }"; br { }
            +"        col(all = $orderingsName.$ord3 $ordOff $offsetsName.$off1) { +\"all = $orderingsName.$ord3 "
            +"$ordOff $offsetsName.$off1\" }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
    contentTitle(RBuilder::h3) { +"$sizesName <-> $offsetsName <-> $orderingsName" }
    p {
        +"Use the same pairing functions to combine all three in all different orders."
    }
    exampleRow {
        example {
            container {
                row {
                    col(all = Sizes.SZ_4 off Offsets.OFF_1 ord Orderings.ORD_3) {
                        +"all = $sizesName.$sz4 $szOff $offsetsName.$off1 $offOrd $orderingsName.$ord3"
                    }
                }
                row {
                    col(all = Sizes.SZ_4 ord Orderings.ORD_3 off Offsets.OFF_1) {
                        +"all = $sizesName.$sz4 $szOrd $orderingsName.$ord3 $ordOff $offsetsName.$off1"
                    }
                }
                row {
                    col(all = Offsets.OFF_1 sz Sizes.SZ_4 ord Orderings.ORD_3) {
                        +"all = $offsetsName.$off1 $offSz $sizesName.$sz4 $szOrd $orderingsName.$ord3"
                    }
                }
                row {
                    col(all = Offsets.OFF_1 ord Orderings.ORD_3 sz Sizes.SZ_4) {
                        +"all = $offsetsName.$off1 $offOrd $orderingsName.$ord3 $ordSz $sizesName.$sz4"
                    }
                }
                row {
                    col(all = Orderings.ORD_3 sz Sizes.SZ_4 off Offsets.OFF_1) {
                        +"all = $orderingsName.$ord3 $ordSz $sizesName.$sz4 $szOff $offsetsName.$off1"
                    }
                }
                row {
                    col(all = Orderings.ORD_3 off Offsets.OFF_1 sz Sizes.SZ_4) {
                        +"all = $orderingsName.$ord3 $ordOff $offsetsName.$off1 $offSz $sizesName.$sz4"
                    }
                }
            }
        }
        kotlinExample {
            +"container { "; br { }
            +"    row { "; br { }
            +"        col(all = $sizesName.$sz4 $szOff $offsetsName.$off1 $offOrd $orderingsName.$ord3) { "; br { }
            +"            +\"all = $sizesName.$sz4 $szOff $offsetsName.$off1 $offOrd $orderingsName.$ord3\""; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"    row { "; br { }
            +"        col(all = $sizesName.$sz4 $szOrd $orderingsName.$ord3 $ordOff $offsetsName.$off1) {"; br { }
            +"            +\"all = $sizesName.$sz4 $szOrd $orderingsName.$ord3 $ordOff $offsetsName.$off1\""; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"    row {"; br { }
            +"        col($offsetsName.$off1 $offSz $sizesName.$sz4 $szOrd $orderingsName.$ord3) {"; br { }
            +"            +\"all = $offsetsName.$off1 $offSz $sizesName.$sz4 $szOrd $orderingsName.$ord3\""; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"    row {"; br { }
            +"        col($offsetsName.$off1 $offOrd $orderingsName.$ord3 $ordSz $sizesName.$sz4) {"; br { }
            +"            +\"all = $offsetsName.$off1 $offOrd $orderingsName.$ord3 $ordSz $sizesName.$sz4\""; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"    row {"; br { }
            +"        col(all = $orderingsName.$ord3 $ordSz $sizesName.$sz4 $szOff $offsetsName.$off1) {"; br { }
            +"            +\"all = $orderingsName.$ord3 $ordSz $sizesName.$sz4 $szOff $offsetsName.$off1\""; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"    row {"; br { }
            +"        col(all = $orderingsName.$ord3 $ordOff $offsetsName.$off1 $offSz $sizesName.$sz4) {"; br { }
            +"            +\"all = $orderingsName.$ord3 $ordOff $offsetsName.$off1 $offSz $sizesName.$sz4\""; br { }
            +"        }"; br { }
            +"    }"; br { }
            +"}"
        }
    }
}
