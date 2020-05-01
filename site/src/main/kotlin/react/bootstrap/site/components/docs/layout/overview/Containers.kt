package react.bootstrap.site.components.docs.layout.overview

import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.content.typography.muted
import react.bootstrap.layout.Container
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.layout.grid.containerFun
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.layout.grid.ktContainer
import react.bootstrap.site.components.docs.ln
import react.dom.br
import react.dom.code
import react.dom.em
import react.dom.h3
import react.dom.li
import react.dom.p
import react.dom.span
import react.dom.strong
import react.dom.td
import react.dom.th
import react.dom.thead
import react.dom.tr
import react.dom.ul

internal fun RBuilder.containers() {
    contentTitle("Containers")
    p {
        +"Containers are the most basic layout element in Bootstrap and are "; strong {
        +"required when using Bootstrap"
        +"'s default grid system"
    }; +". Containers are used to contain, pad, and (sometimes) center the content within"
        +" them. While containers "; em { +"can" }; +" be nested, most layouts do not require a nested container."
    }
    p {
        +"Bootstrap comes with three different containers:"
    }
    ul {
        li {
            code { +"$containerFun { }" }; +", which sets a "; code { +"max-width" }; +" at each responsive breakpoint"
        }
        li {
            code { +"$containerFun(viscosity = ${Container.Viscosities.FLUID.kt}) { }" }; +", which is "
            code { +"width: 100%" }; +" at all breakpoints"
        }
        li {
            code {
                +"container(viscosity = ${Container.Viscosities::class.simpleName}"
                +"{.${Container.Viscosities.SM.name}|.${Container.Viscosities.MD.name}"
                +"|.${Container.Viscosities.LG.name}|.${Container.Viscosities.XL.name}|}) { }"
            }; +", which is "
            code { +"width: 100%" }; +" until the specified breakpoint"
        }
    }
    p {
        +"The table below illustrates how each container’s "; code { +"max-width" }; +" compares to the original "
        code { +"$containerFun { }" }; +" and "
        code { +"$containerFun(viscosity = ${Container.Viscosities.FLUID.kt}) { }" }; +" across each breakpoint."
    }
    p {
        +"See them in action and compare them in our Grid example." // Todo link to examples
    }
    table(classes = "${ClassNames.TEXT_LEFT}") {
        thead {
            tr {
                th { }
                th { +"Extra small"; br { }; span(classes = "${ClassNames.FONT_WEIGHT_NORMAL}") { +"<576px" } }
                th { +"Small"; br { }; span(classes = "${ClassNames.FONT_WEIGHT_NORMAL}") { +"≥576px" } }
                th { +"Medium"; br { }; span(classes = "${ClassNames.FONT_WEIGHT_NORMAL}") { +"≥768px" } }
                th { +"Large"; br { }; span(classes = "${ClassNames.FONT_WEIGHT_NORMAL}") { +"≥992px" } }
                th { +"Extra large"; br { }; span(classes = "${ClassNames.FONT_WEIGHT_NORMAL}") { +"≥1200px" } }
            }
            tr {
                td { code { +"$containerFun { }" } }
                muted(RBuilder::td) { +"100%" }
                td { +"540px" }
                td { +"720px" }
                td { +"960px" }
                td { +"1140px" }
            }
            tr {
                td { code { +"$containerFun(viscosity = ${Container.Viscosities.SM.kt}) { }" } }
                muted(RBuilder::td) { +"100%" }
                td { +"540px" }
                td { +"720px" }
                td { +"960px" }
                td { +"1140px" }
            }
            tr {
                td { code { +"$containerFun(viscosity = ${Container.Viscosities.MD.kt}) { }" } }
                muted(RBuilder::td) { +"100%" }
                muted(RBuilder::td) { +"100%" }
                td { +"720px" }
                td { +"960px" }
                td { +"1140px" }
            }
            tr {
                td { code { +"$containerFun(viscosity = ${Container.Viscosities.LG.kt}) { }" } }
                for (x in 1..3) {
                    muted(RBuilder::td) { +"100%" }
                }
                td { +"960px" }
                td { +"1140px" }
            }
            tr {
                td { code { +"$containerFun(viscosity = ${Container.Viscosities.XL.kt}) { }" } }
                for (x in 1..4) {
                    muted(RBuilder::td) { +"100%" }
                }
                td { +"1140px" }
            }
            tr {
                td { code { +"$containerFun(viscosity = ${Container.Viscosities.FLUID.kt}) { }" } }
                for (x in 1..5) {
                    muted(RBuilder::td) { +"100%" }
                }
            }
        }
    }
    contentTitle(RBuilder::h3, "All-in-one")
    p {
        +"Bootstrap's default "; code { +"$containerFun { }" }; +" is a responsive, fixed-width container, meaning its "
        +"max-width changes at each breakpoint."
    }
    codeBox {
        ktContainer { il ->
            ln(il) { +"// Content here" }
        }
    }
    contentTitle(RBuilder::h3, "Fluid")
    p {
        +"Use "; code { +"$containerFun(viscosity = ${Container.Viscosities.FLUID.kt}) { }" }; +" for a full width "
        +"container, spanning the entire width of the viewport."
    }
    codeBox {
        ktBlock(0, "$containerFun(viscosity = ${Container.Viscosities.FLUID.kt})") { il ->
            ln(il) { +"// Content here" }
        }
    }
    contentTitle(RBuilder::h3, "Responsive")
    p {
        +"Responsive containers are new in Bootstrap v4.4. They allow you to specify a class that is 100% wide until "
        +"the specified breakpoint is reached, after which we apply "; code { +"max-width" }; +"s for each of the "
        +"higher breakpoints. For example, "; code { +"$containerFun(viscosity = ${Container.Viscosities.SM.kt}) { }" }
        +" is 100% wide to start until the "; code { +"sm" }; +" breakpoint is reached, where it will scale up with "
        code { +"md" }; +", "; code { +"lg" }; +", and "; code { +"xl" }; +"."
    }
    codeBox {
        ktBlock(0, "$containerFun(viscosity = ${Container.Viscosities.SM.kt})") { il ->
            ln(il) { +"+\"100% wide until small breakpoint\"" }
        }
        ktBlock(0, "$containerFun(viscosity = ${Container.Viscosities.MD.kt})") { il ->
            ln(il) { +"+\"100% wide until medium breakpoint\"" }
        }
        ktBlock(0, "$containerFun(viscosity = ${Container.Viscosities.LG.kt})") { il ->
            ln(il) { +"+\"100% wide until large breakpoint\"" }
        }
        ktBlock(0, "$containerFun(viscosity = ${Container.Viscosities.XL.kt})") { il ->
            ln(il) { +"+\"100% wide until extra large breakpoint\"" }
        }
    }
}
