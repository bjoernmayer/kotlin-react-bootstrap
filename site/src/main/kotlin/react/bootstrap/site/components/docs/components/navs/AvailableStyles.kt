package react.bootstrap.site.components.docs.components.navs

import kotlinx.html.A
import kotlinx.html.id
import react.RBuilder
import react.RElementBuilder
import react.bootstrap.components.nav.Navs
import react.bootstrap.components.nav.Navs.Appearance
import react.bootstrap.components.nav.Navs.WidthHandling
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importNavComponents
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.dom.a

internal class AvailableStyles : SectionComponent() {
    override val title: String = "Available styles"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Change the style of `nav { }` component with modifiers and utilities. Mix and match as needed, or build your own.
            """
        }
        subSectionTitle("Horizontal alignment", section)
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
            Navs.ul(classes = "${ClassNames.JUSTIFY_CONTENT_CENTER}") {
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
                .addArgument("classes", ClassNames.JUSTIFY_CONTENT_CENTER)
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
            Navs.ul(classes = "${ClassNames.JUSTIFY_CONTENT_END}") {
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
                .addArgument("classes", ClassNames.JUSTIFY_CONTENT_END)
                .setLambdaArgument(testingNavItemsString())
                .build()
        }
        subSectionTitle("Vertical", section)
        Markdown {
            //language=Markdown
            +"""
Stack your navigation by changing the flex item direction with the `${ClassNames.FLEX_COLUMN}` utility. Need to stack
them on some viewports but not others? Use the responsive versions (e.g., `${ClassNames.FLEX_SM_COLUMN}``).
            """
        }
        liveExample {
            Navs.ul(classes = "${ClassNames.FLEX_COLUMN}") {
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
                .addArgument("classes", ClassNames.FLEX_COLUMN)
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
            Navs.nav(classes = "${ClassNames.FLEX_COLUMN}") {
                navLink(href = "#", active = true) {
                    +"Active"
                }
                navLink(href = "#") {
                    +"Link"
                }
                navLink(href = "#") {
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
                .addArgument("classes", ClassNames.FLEX_COLUMN)
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
        subSectionTitle("Tabs", section)
        Markdown {
            //language=Markdown
            +"""
Set `appearance = ${Appearance.TABS.nestedName}` to generate a tabbed interface.
            """
        }
        liveExample {
            Navs.ul(appearance = Appearance.TABS) {
                buildDefaultExample()
            }
        }
        subSectionTitle("Pills", section)
        liveExample {
            Navs.ul(appearance = Appearance.PILLS) {
                buildDefaultExample()
            }
        }
        subSectionTitle("Fill and justify", section)
        liveExample {
            Navs.ul(appearance = Appearance.PILLS, widthHandling = WidthHandling.FILL) {
                navItem {
                    navLink(href = "#", active = true) {
                        +"Active"
                    }
                }
                navItem {
                    navLink(href = "#") {
                        +"Much longer nav link"
                    }
                }
                navItem {
                    navLink(href = "#") {
                        +"Link"
                    }
                }
                navItem {
                    navLink(href = "#", disabled = true) {
                        +"Disabled"
                    }
                }
            }
        }
        a {
            attrs {
                id = "lol"
                val test: A = this
            }
        }
        liveExample {
            Navs.ul(appearance = Appearance.PILLS, widthHandling = WidthHandling.JUSTIFY) {
                navItem {
                    navLink(href = "#", active = true) {
                        +"Active"
                    }
                }
                navItem {
                    navLink(href = "#") {
                        +"Much longer nav link"
                    }
                }
                navItem {
                    navLink(href = "#") {
                        +"Link"
                    }
                }
                navItem {
                    navLink(href = "#", disabled = true) {
                        +"Disabled"
                    }
                }
            }
        }
        subSectionTitle("Active Navlink", section)
        liveExample {
            Navs.ul(
                appearance = Appearance.PILLS,
                activeLinkPredicate = {
                    it.props.id == "thisOneIsActive"
                }
            ) {
                buildDefaultExample()
            }
        }
    }

    private fun RElementBuilder<Navs.Ul.Props>.buildDefaultExample() {
        navItem {
            navLink(href = "#", active = true) {
                +"Active"
            }
        }
        navItem {
            navLink(href = "#") {
                +"Link"
            }
        }
        navItem {
            navLink(href = "#") {
                +"Link"
            }
        }
        navItem {
            navLink(href = "#", disabled = true) {
                +"Disabled"
            }
        }
    }
}
