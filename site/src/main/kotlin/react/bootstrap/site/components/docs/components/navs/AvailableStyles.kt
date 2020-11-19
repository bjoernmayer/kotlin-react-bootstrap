@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.components.navs

import kotlinx.html.UL
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RProps
import react.bootstrap.components.nav.NavComponent
import react.bootstrap.components.nav.NavComponent.Appearance
import react.bootstrap.components.nav.NavComponent.WidthHandling
import react.bootstrap.components.nav.Navs
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.helpers.classes
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importNavComponents
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.FunCall.Style.INLINE
import react.bootstrap.site.lib.codepoet.Imports
import react.child
import react.functionalComponent
import react.getValue
import react.setValue
import react.useState

internal class AvailableStyles : SectionComponent() {
    override val title: String = "Available styles"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
Change the style of `nav { }` component with modifiers and utilities. Mix and match as needed, or build your own.
            """
        }

        subSectionTitle("Horizontal alignment")
        Markdown {
            //language=Markdown
            +"""
Change the horizontal alignment of your nav with Bootstrap's
[flexbox utilities](https://getbootstrap.com/docs/4.5/layout/grid/#horizontal-alignment). By default, navs are
left-aligned, but you can easily change them to center or right aligned.
            """
        }
        Markdown {
            //language=Markdown
            +"""
Centered with `${ClassNames.JUSTIFY_CONTENT_CENTER.nestedName}`:
            """
        }
        liveExample {
            Navs.ul(classes(ClassNames.JUSTIFY_CONTENT_CENTER)) {
                buildDefaultExample()
            }
        }
        codeExample {
            +Imports.builder()
                .importNavComponents()
                .importClassNames()
                .build()

            +FunCall.builder(Navs::ul)
                .nestedBy(RBuilder::Navs)
                .addArgument(FunCall.builder(::classes, INLINE).addArgument(ClassNames.JUSTIFY_CONTENT_CENTER))
                .setLambdaArgument(testingNavItemsString())
                .build()
        }
        Markdown {
            //language=Markdown
            +"""
Centered with `${ClassNames.JUSTIFY_CONTENT_END.nestedName}`:
            """
        }
        liveExample {
            Navs.ul(classes(ClassNames.JUSTIFY_CONTENT_END)) {
                buildDefaultExample()
            }
        }
        codeExample {
            +Imports.builder()
                .importNavComponents()
                .importClassNames()
                .build()

            +FunCall.builder(Navs::ul)
                .nestedBy(RBuilder::Navs)
                .addArgument(FunCall.builder(::classes, INLINE).addArgument(ClassNames.JUSTIFY_CONTENT_END))
                .setLambdaArgument(testingNavItemsString())
                .build()
        }

        subSectionTitle("Vertical")
        Markdown {
            //language=Markdown
            +"""
Stack your navigation by changing the flex item direction with the `${ClassNames.FLEX_COLUMN}` utility. Need to stack
them on some viewports but not others? Use the responsive versions (e.g., `${ClassNames.FLEX_SM_COLUMN}``).
            """
        }
        liveExample {
            Navs.ul(classes(ClassNames.FLEX_COLUMN)) {
                buildDefaultExample()
            }
        }
        codeExample {
            +Imports.builder()
                .importNavComponents()
                .importClassNames()
                .build()

            +FunCall.builder(Navs::ul)
                .nestedBy(RBuilder::Navs)
                .addArgument(FunCall.builder(::classes, INLINE).addArgument(ClassNames.FLEX_COLUMN))
                .setLambdaArgument(testingNavItemsString())
                .build()
        }
        Markdown {
            //language=Markdown
            +"""
As always, vertical navigation is possible without `ul`s, too.
            """
        }
        liveExample {
            Navs.nav(classes(ClassNames.FLEX_COLUMN)) {
                navLink(href = "#", active = true) {
                    attrs { onClickFunction = { it.preventDefault() } }
                    +"Active"
                }
                navLink(href = "#") {
                    attrs { onClickFunction = { it.preventDefault() } }
                    +"Link"
                }
                navLink(href = "#") {
                    attrs { onClickFunction = { it.preventDefault() } }
                    +"Link"
                }
                navLink(href = "#", disabled = true) {
                    +"Disabled"
                }
            }
        }
        codeExample {
            +Imports.builder()
                .importNavComponents()
                .importClassNames()
                .build()

            +FunCall.builder(Navs::nav)
                .nestedBy(RBuilder::Navs)
                .addArgument(FunCall.builder(::classes, INLINE).addArgument(ClassNames.FLEX_COLUMN))
                .setLambdaArgument(
                    buildString {
                        append(
                            FunCall.builder(navLinkBuilderFun)
                                .addArgument("href", "#")
                                .addArgument("active", true)
                                .setLambdaArgument(plusString("Active"))
                                .build()
                        )
                        repeat(2) {
                            append(
                                FunCall.builder(navLinkBuilderFun)
                                    .addArgument("href", "#")
                                    .setLambdaArgument(plusString("Link"))
                                    .build()
                            )
                        }
                        append(
                            FunCall.builder(navLinkBuilderFun)
                                .addArgument("href", "#")
                                .addArgument("disabled", true)
                                .setLambdaArgument(plusString("Disabled"))
                                .build()
                        )
                    }

                ).build()
        }

        subSectionTitle("Tabs")
        Markdown {
            //language=Markdown
            +"""
Set `appearance = ${Appearance.TABS.nestedName}` to generate a tabbed interface.
            """
        }
        liveExample {
            child(
                buildToglleableNavLinks {
                    appearance = Appearance.TABS
                }
            )
        }
        codeExample {
            +Imports.builder()
                .importNavComponents()
                .build()

            +FunCall.builder(Navs::ul)
                .nestedBy(RBuilder::Navs)
                .addArgument("appearance", Appearance.TABS)
                .setLambdaArgument(testingNavItemsString())
                .build()
        }

        subSectionTitle("Pills")
        liveExample {
            child(
                buildToglleableNavLinks {
                    appearance = Appearance.PILLS
                }
            )
        }
        codeExample {
            +Imports.builder()
                .importNavComponents()
                .build()

            +FunCall.builder(Navs::ul)
                .nestedBy(RBuilder::Navs)
                .addArgument("appearance", Appearance.PILLS)
                .setLambdaArgument(testingNavItemsString())
                .build()
        }

        subSectionTitle("Fill and justify")
        Markdown {
            //language=Markdown
            +"""
Force your .nav’s contents to extend the full available width by setting `widthHandling`. To proportionately fill all
available space with your `navItem`s, use `${WidthHandling.FILL.nestedName}`. Notice that all horizontal space is
occupied, but not every nav item has the same width.
            """
        }
        liveExample {
            child(
                buildToglleableNavLinks(linkText1 = "Much longer nav link") {
                    appearance = Appearance.PILLS
                    widthHandling = WidthHandling.FILL
                }
            )
        }
        codeExample {
            +Imports.builder()
                .importNavComponents()
                .build()

            +FunCall.builder(Navs::ul)
                .nestedBy(RBuilder::Navs)
                .addArgument("appearance", Appearance.PILLS)
                .addArgument("widthHandling", WidthHandling.FILL)
                .setLambdaArgument(
                    FunCall.builder(navItemBuilderFun)
                        .setLambdaArgument(
                            FunCall.builder(navLinkBuilderFun)
                                .addArgument("href", "#")
                                .addArgument("active", true)
                                .setLambdaArgument(plusString("Active"))
                                .build()
                        )
                        .build(),
                    FunCall.builder(navItemBuilderFun)
                        .setLambdaArgument(
                            FunCall.builder(navLinkBuilderFun)
                                .addArgument("href", "#")
                                .addArgument("active", true)
                                .setLambdaArgument(plusString("Much longer nav link"))
                                .build()
                        )
                        .build(),
                    FunCall.builder(navItemBuilderFun)
                        .setLambdaArgument(
                            FunCall.builder(navLinkBuilderFun)
                                .addArgument("href", "#")
                                .addArgument("active", true)
                                .setLambdaArgument(plusString("Link"))
                                .build()
                        )
                        .build(),
                    FunCall.builder(navItemBuilderFun)
                        .setLambdaArgument(
                            FunCall.builder(navLinkBuilderFun)
                                .addArgument("href", "#")
                                .addArgument("disabled", true)
                                .setLambdaArgument(plusString("Disabled"))
                                .build()
                        )
                        .build()
                )
                .build()
        }
        Markdown {
            //language=Markdown
            +"""
When using a `<nav>`-based navigation, you can safely omit `navItem` as only `navLink` is required for styling `<a>`
elements.
            """
        }
        liveExample {
            child(
                buildToglleableNavLinksInNavNav(linkText1 = "Much longer nav link") {
                    appearance = Appearance.PILLS
                    widthHandling = WidthHandling.FILL
                }
            )
        }
        codeExample {
            +Imports.builder()
                .importNavComponents()
                .build()

            +FunCall.builder(Navs::nav)
                .nestedBy(RBuilder::Navs)
                .addArgument("appearance", Appearance.PILLS)
                .addArgument("widthHandling", WidthHandling.FILL)
                .setLambdaArgument(
                    FunCall.builder(navLinkBuilderFun)
                        .addArgument("href", "#")
                        .addArgument("active", true)
                        .setLambdaArgument(plusString("Active"))
                        .build(),
                    FunCall.builder(navLinkBuilderFun)
                        .addArgument("href", "#")
                        .setLambdaArgument(plusString("Much longer nav link"))
                        .build(),
                    FunCall.builder(navLinkBuilderFun)
                        .addArgument("href", "#")
                        .setLambdaArgument(plusString("Link"))
                        .build(),
                    FunCall.builder(navLinkBuilderFun)
                        .addArgument("href", "#")
                        .addArgument("disabled", true)
                        .setLambdaArgument(plusString("Disabled"))
                        .build()
                ).build()
        }
        Markdown {
            //language=Markdown
            +"""
For equal-width elements, use `${WidthHandling.JUSTIFY.nestedName}`. All horizontal space will be occupied by nav
links, but unlike the `${WidthHandling.FILL.nestedName}` above, every nav item will be the same width.
            """
        }
        liveExample {
            child(
                buildToglleableNavLinks(linkText1 = "Much longer nav link") {
                    appearance = Appearance.PILLS
                    widthHandling = WidthHandling.JUSTIFY
                }
            )
        }
        codeExample {
            +Imports.builder()
                .importNavComponents()
                .build()

            +FunCall.builder(Navs::ul)
                .nestedBy(RBuilder::Navs)
                .addArgument("appearance", Appearance.PILLS)
                .addArgument("widthHandling", WidthHandling.JUSTIFY)
                .setLambdaArgument(
                    FunCall.builder(navItemBuilderFun)
                        .setLambdaArgument(
                            FunCall.builder(navLinkBuilderFun)
                                .addArgument("href", "#")
                                .addArgument("active", true)
                                .setLambdaArgument(plusString("Active"))
                                .build()
                        )
                        .build(),
                    FunCall.builder(navItemBuilderFun)
                        .setLambdaArgument(
                            FunCall.builder(navLinkBuilderFun)
                                .addArgument("href", "#")
                                .addArgument("active", true)
                                .setLambdaArgument(plusString("Much longer nav link"))
                                .build()
                        )
                        .build(),
                    FunCall.builder(navItemBuilderFun)
                        .setLambdaArgument(
                            FunCall.builder(navLinkBuilderFun)
                                .addArgument("href", "#")
                                .addArgument("active", true)
                                .setLambdaArgument(plusString("Link"))
                                .build()
                        )
                        .build(),
                    FunCall.builder(navItemBuilderFun)
                        .setLambdaArgument(
                            FunCall.builder(navLinkBuilderFun)
                                .addArgument("href", "#")
                                .addArgument("disabled", true)
                                .setLambdaArgument(plusString("Disabled"))
                                .build()
                        )
                        .build()
                )
                .build()
        }
        Markdown {
            //language=Markdown
            +"""
Similar to the `${WidthHandling.FILL.nestedName}` example using a `<nav>`-based navigation.
            """
        }
        liveExample {
            child(
                buildToglleableNavLinksInNavNav(linkText1 = "Much longer nav link") {
                    appearance = Appearance.PILLS
                    widthHandling = WidthHandling.JUSTIFY
                }
            )
        }
        codeExample {
            +Imports.builder()
                .importNavComponents()
                .build()

            +FunCall.builder(Navs::nav)
                .nestedBy(RBuilder::Navs)
                .addArgument("appearance", Appearance.PILLS)
                .addArgument("widthHandling", WidthHandling.JUSTIFY)
                .setLambdaArgument(
                    FunCall.builder(navLinkBuilderFun)
                        .addArgument("href", "#")
                        .addArgument("active", true)
                        .setLambdaArgument(plusString("Active"))
                        .build(),
                    FunCall.builder(navLinkBuilderFun)
                        .addArgument("href", "#")
                        .setLambdaArgument(plusString("Much longer nav link"))
                        .build(),
                    FunCall.builder(navLinkBuilderFun)
                        .addArgument("href", "#")
                        .setLambdaArgument(plusString("Link"))
                        .build(),
                    FunCall.builder(navLinkBuilderFun)
                        .addArgument("href", "#")
                        .addArgument("disabled", true)
                        .setLambdaArgument(plusString("Disabled"))
                        .build()
                ).build()
        }
    }

    private fun NavComponent.DomBuilder<UL>.buildDefaultExample() {
        navItem {
            navLink(href = "#", active = true) {
                attrs {
                    onClickFunction = {
                        it.preventDefault()
                    }
                }
                +"Active"
            }
        }
        navItem {
            navLink(href = "#") {
                attrs {
                    onClickFunction = {
                        it.preventDefault()
                    }
                }
                +"Link"
            }
        }
        navItem {
            navLink(href = "#") {
                attrs {
                    onClickFunction = {
                        it.preventDefault()
                    }
                }
                +"Link"
            }
        }
        navItem {
            navLink(href = "#", disabled = true) {
                +"Disabled"
            }
        }
    }

    private fun buildToglleableNavLinks(
        linkText0: String = "Active",
        linkText1: String = "Link",
        linkText2: String = "Link",
        disabledLinkText: String = "Disabled",
        props: NavComponent.Ul.Props.() -> Unit
    ) = functionalComponent<RProps> {
        var activeNavLink by useState(0)

        Navs.ul(
            props = {
                props()
            }
        ) {
            navItem {
                navLink(href = "#", active = activeNavLink == 0) {
                    attrs {
                        onClickFunction = {
                            it.preventDefault()
                            activeNavLink = 0
                        }
                    }
                    +linkText0
                }
            }
            navItem {
                navLink(href = "#", active = activeNavLink == 1) {
                    attrs {
                        onClickFunction = {
                            it.preventDefault()
                            activeNavLink = 1
                        }
                    }
                    +linkText1
                }
            }
            navItem {
                navLink(href = "#", active = activeNavLink == 2) {
                    attrs {
                        onClickFunction = {
                            it.preventDefault()
                            activeNavLink = 2
                        }
                    }
                    +linkText2
                }
            }
            navItem {
                navLink(href = "#", disabled = true) {
                    +disabledLinkText
                }
            }
        }
    }

    private fun buildToglleableNavLinksInNavNav(
        linkText0: String = "Active",
        linkText1: String = "Link",
        linkText2: String = "Link",
        disabledLinkText: String = "Disabled",
        props: NavComponent.Nav.Props.() -> Unit
    ) = functionalComponent<RProps> {
        var activeNavLink by useState(0)

        Navs.nav(
            props = {
                props()
            }
        ) {
            navLink(href = "#", active = activeNavLink == 0) {
                attrs {
                    onClickFunction = {
                        it.preventDefault()
                        activeNavLink = 0
                    }
                }
                +linkText0
            }
            navLink(href = "#", active = activeNavLink == 1) {
                attrs {
                    onClickFunction = {
                        it.preventDefault()
                        activeNavLink = 1
                    }
                }
                +linkText1
            }
            navLink(href = "#", active = activeNavLink == 2) {
                attrs {
                    onClickFunction = {
                        it.preventDefault()
                        activeNavLink = 2
                    }
                }
                +linkText2
            }
            navLink(href = "#", disabled = true) {
                +disabledLinkText
            }
        }
    }
}
