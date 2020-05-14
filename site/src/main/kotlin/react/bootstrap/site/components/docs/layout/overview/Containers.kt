@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.layout.overview

import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.content.typography.muted
import react.bootstrap.layout.Container
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.layout.containerFun
import react.bootstrap.site.components.docs.layout.importContainer
import react.bootstrap.site.components.docs.layout.importContainerFun
import react.bootstrap.site.components.docs.layout.ktN
import react.bootstrap.site.components.docs.layout.ktContainer
import react.bootstrap.site.external.Markdown
import react.dom.br
import react.dom.code
import react.dom.li
import react.dom.p
import react.dom.span
import react.dom.td
import react.dom.th
import react.dom.thead
import react.dom.tr
import react.dom.ul

internal class Containers : SectionComponent() {
    override val title: String = "Containers"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Containers are the most basic layout element in Bootstrap and are __required when using our default grid system__.
Containers are used to contain, pad, and (sometimes) center the content within them. While containers *can* be nested,
most layouts do not require a nested container.
            """
        }
        p {
            +"Bootstrap comes with three different containers:"
        }
        ul {
            li {
                code { +"$containerFun { }" }; +", which sets a "; code { +"max-width" }
                +" at each responsive breakpoint"
            }
            li {
                code { +"$containerFun(viscosity = ${Container.Viscosities.FLUID.ktN}) { }" }; +", which is "
                code { +"width: 100%" }; +" at all breakpoints"
            }
            li {
                code {
                    +"$$containerFun(viscosity = ${Container.Viscosities::class.simpleName}"
                    +"{.${Container.Viscosities.SM.name}|.${Container.Viscosities.MD.name}"
                    +"|.${Container.Viscosities.LG.name}|.${Container.Viscosities.XL.name}|}) { }"
                }; +", which is "
                code { +"width: 100%" }; +" until the specified breakpoint"
            }
        }
        Markdown {
            //language=Markdown
            +"""
The table below illustrates how each container’s `max-width` compares to the original `$containerFun { }` and
`$containerFun(viscosity = ${Container.Viscosities.FLUID.ktN}) { }` accross each breakpoint.
            """
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
                    td { code { +"$containerFun(viscosity = ${Container.Viscosities.SM.ktN}) { }" } }
                    muted(RBuilder::td) { +"100%" }
                    td { +"540px" }
                    td { +"720px" }
                    td { +"960px" }
                    td { +"1140px" }
                }
                tr {
                    td { code { +"$containerFun(viscosity = ${Container.Viscosities.MD.ktN}) { }" } }
                    muted(RBuilder::td) { +"100%" }
                    muted(RBuilder::td) { +"100%" }
                    td { +"720px" }
                    td { +"960px" }
                    td { +"1140px" }
                }
                tr {
                    td { code { +"$containerFun(viscosity = ${Container.Viscosities.LG.ktN}) { }" } }
                    for (x in 1..3) {
                        muted(RBuilder::td) { +"100%" }
                    }
                    td { +"960px" }
                    td { +"1140px" }
                }
                tr {
                    td { code { +"$containerFun(viscosity = ${Container.Viscosities.XL.ktN}) { }" } }
                    for (x in 1..4) {
                        muted(RBuilder::td) { +"100%" }
                    }
                    td { +"1140px" }
                }
                tr {
                    td { code { +"$containerFun(viscosity = ${Container.Viscosities.FLUID.ktN}) { }" } }
                    for (x in 1..5) {
                        muted(RBuilder::td) { +"100%" }
                    }
                }
            }
        }
        subSectionTitle("All-in-one", section)
        Markdown {
            //language=Markdown
            +"""
Our default `$containerFun { }` is a responsive, fixed-width container, meaning its max-width changes at each
breakpoint.
            """
        }
        codeExample {
            importContainerFun()
            ln { }
            ktContainer {
                ln(it) { +"// Content here" }
            }
        }
        subSectionTitle("Fluid", section)
        Markdown {
            //language=Markdown
            +"""
Use `$containerFun(viscosity = ${Container.Viscosities.FLUID.ktN}) { }` for a full width container,
spanning the entire width of the viewport.
            """
        }
        codeExample {
            importContainer()
            importContainerFun()
            ln { }
            ktB(0, containerFun, "viscosity" to Container.Viscosities.FLUID.ktN) {
                ln(it) { +"// Content here" }
            }
        }
        subSectionTitle("Responsive", section)
        Markdown {
            //language=Markdown
            +"""
Responsive containers are new in Bootstrap v4.4. They allow you to specify a class that is 100% wide until the specified
breakpoint is reached, after which we apply `max-width`s for each of the higher breakpoints. For example,
`$containerFun(viscosity = ${Container.Viscosities.SM.ktN}) { }` is 100% wide to start until the `sm` breakpoint is
reached, where it will scale up with `md`, `lg`, and `xl`.
            """
        }
        codeExample {
            importContainer()
            importContainerFun()
            ln { }
            ktB(0, containerFun, "viscosity" to Container.Viscosities.SM.ktN) {
                ln(it) { +"+\"100% wide until small breakpoint\"" }
            }
            ktB(0, containerFun, "viscosity" to Container.Viscosities.MD.ktN) {
                ln(it) { +"+\"100% wide until medium breakpoint\"" }
            }
            ktB(0, containerFun, "viscosity" to Container.Viscosities.LG.ktN) {
                ln(it) { +"+\"100% wide until large breakpoint\"" }
            }
            ktB(0, containerFun, "viscosity" to Container.Viscosities.XL.ktN) {
                ln(it) { +"+\"100% wide until extra large breakpoint\"" }
            }
        }
    }
}
