@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.layout.overview

import kotlinx.html.TD
import react.RBuilder
import react.bootstrap.content.tables.table
import react.bootstrap.content.typography.muted.muted
import react.bootstrap.helpers.classes
import react.bootstrap.layout.grid.container.Container
import react.bootstrap.layout.grid.container.container
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.importContainer
import react.bootstrap.site.components.docs.importContainerFun
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
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
        sectionTitle()
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
        val renderedContainerFun = FunCall.builder(RBuilder::container, FunCall.Style.INLINE)
            .setEmptyLambdaArgument()
            .build()
        val renderedContainerFunFluid = FunCall.builder(RBuilder::container, FunCall.Style.INLINE)
            .addArgument("viscosity", Container.Viscosities.FLUID)
            .setEmptyLambdaArgument()
            .build()
        ul {
            li {
                code { +renderedContainerFun }; +", which sets a "; code { +"max-width" }
                +" at each responsive breakpoint"
            }
            li {
                code { +renderedContainerFunFluid }; +", which is "
                code { +"width: 100%" }; +" at all breakpoints"
            }
            li {
                code {
                    +FunCall.builder(RBuilder::container, FunCall.Style.INLINE)
                        .addArgument(
                            "viscosity",
                            FunCall.Argument.PureValue(
                                buildString {
                                    append(Container.Viscosities::class.nestedName)
                                    append("{.")
                                    append(
                                        listOf(
                                            Container.Viscosities.SM,
                                            Container.Viscosities.MD,
                                            Container.Viscosities.LG,
                                            Container.Viscosities.XL,
                                        ).joinToString("|.")
                                    )
                                    append("}")
                                }
                            )
                        )
                        .setEmptyLambdaArgument()
                        .build()
                }; +", which is "
                code { +"width: 100%" }; +" until the specified breakpoint"
            }
        }
        Markdown {
            //language=Markdown
            +"""
The table below illustrates how each container’s `max-width` compares to the original `$renderedContainerFun` and
`$renderedContainerFunFluid` accross each breakpoint.
            """
        }
        // p {
        //     +"See them in action and compare them in our Grid example." // Todo link to examples
        // }
        table(classes = classes(ClassNames.TEXT_LEFT)) {
            thead {
                tr {
                    th { }
                    th { +"Extra small"; br { }; span(classes(ClassNames.FONT_WEIGHT_NORMAL)) { +"<576px" } }
                    th { +"Small"; br { }; span(classes(ClassNames.FONT_WEIGHT_NORMAL)) { +"≥576px" } }
                    th { +"Medium"; br { }; span(classes(ClassNames.FONT_WEIGHT_NORMAL)) { +"≥768px" } }
                    th { +"Large"; br { }; span(classes(ClassNames.FONT_WEIGHT_NORMAL)) { +"≥992px" } }
                    th { +"Extra large"; br { }; span(classes(ClassNames.FONT_WEIGHT_NORMAL)) { +"≥1200px" } }
                }
                tr {
                    td { code { +renderedContainerFun } }
                    muted<TD> { +"100%" }
                    td { +"540px" }
                    td { +"720px" }
                    td { +"960px" }
                    td { +"1140px" }
                }
                tr {
                    td {
                        code {
                            +FunCall.builder(RBuilder::container)
                                .addArgument("viscosity", Container.Viscosities.SM)
                                .setEmptyLambdaArgument()
                                .build()
                        }
                    }
                    muted<TD> { +"100%" }
                    td { +"540px" }
                    td { +"720px" }
                    td { +"960px" }
                    td { +"1140px" }
                }
                tr {
                    td {
                        code {
                            +FunCall.builder(RBuilder::container)
                                .addArgument("viscosity", Container.Viscosities.MD)
                                .setEmptyLambdaArgument()
                                .build()
                        }
                    }
                    muted<TD> { +"100%" }
                    muted<TD> { +"100%" }
                    td { +"720px" }
                    td { +"960px" }
                    td { +"1140px" }
                }
                tr {
                    td {
                        code {
                            +FunCall.builder(RBuilder::container)
                                .addArgument("viscosity", Container.Viscosities.LG)
                                .setEmptyLambdaArgument()
                                .build()
                        }
                    }
                    for (x in 1..3) {
                        muted<TD> { +"100%" }
                    }
                    td { +"960px" }
                    td { +"1140px" }
                }
                tr {
                    td {
                        code {
                            +FunCall.builder(RBuilder::container)
                                .addArgument("viscosity", Container.Viscosities.XL)
                                .setEmptyLambdaArgument()
                                .build()
                        }
                    }
                    for (x in 1..4) {
                        muted<TD> { +"100%" }
                    }
                    td { +"1140px" }
                }
                tr {
                    td { code { +renderedContainerFunFluid } }
                    for (x in 1..5) {
                        muted<TD> { +"100%" }
                    }
                }
            }
        }
        subSectionTitle("All-in-one")
        Markdown {
            //language=Markdown
            +"""
Our default `$renderedContainerFun` is a responsive, fixed-width container, meaning its max-width changes at each
breakpoint.
            """
        }
        codeExample {
            +Imports.builder()
                .importContainerFun()
                .build()

            +FunCall.builder(RBuilder::container)
                .setLambdaArgument("// Content here")
                .build()
        }
        subSectionTitle("Fluid")
        Markdown {
            //language=Markdown
            +"""
Use `$renderedContainerFunFluid` for a full width container,
spanning the entire width of the viewport.
            """
        }
        codeExample {
            +Imports.builder()
                .importContainer()
                .importContainerFun()
                .build()

            +FunCall.builder(RBuilder::container)
                .addArgument("viscosity", Container.Viscosities.FLUID)
                .setLambdaArgument("// Content here")
                .build()
        }
        subSectionTitle("Responsive")
        Markdown {
            val renderedSmContainer = FunCall.builder(RBuilder::container, FunCall.Style.INLINE)
                .addArgument("viscosity", Container.Viscosities.SM)
                .setEmptyLambdaArgument()
                .build()
            //language=Markdown
            +"""
Responsive containers are new in Bootstrap v4.4. They allow you to specify a class that is 100% wide until the specified
breakpoint is reached, after which we apply `max-width`s for each of the higher breakpoints. For example,
`$renderedSmContainer` is 100% wide to start until the `sm` breakpoint is
reached, where it will scale up with `md`, `lg`, and `xl`.
            """
        }
        codeExample {
            +Imports.builder()
                .importContainer()
                .importContainerFun()
                .build()

            +FunCall.builder(RBuilder::container)
                .addArgument("viscosity", Container.Viscosities.SM)
                .setLambdaArgument("// 100% wide until small breakpoint")
                .build()
            +FunCall.builder(RBuilder::container)
                .addArgument("viscosity", Container.Viscosities.MD)
                .setLambdaArgument("// 100% wide until medium breakpoint")
                .build()
            +FunCall.builder(RBuilder::container)
                .addArgument("viscosity", Container.Viscosities.LG)
                .setLambdaArgument("// 100% wide until large breakpoint")
                .build()
            +FunCall.builder(RBuilder::container)
                .addArgument("viscosity", Container.Viscosities.XL)
                .setLambdaArgument("// 100% wide until extra large breakpoint")
                .build()
        }
    }
}
