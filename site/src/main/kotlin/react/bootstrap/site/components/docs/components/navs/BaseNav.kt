@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.components.navs

import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.bootstrap.components.nav.Navs
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importNavComponents
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.dom.div

internal class BaseNav : SectionComponent() {
    override val title: String = "Base nav"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
The base `nav` component is built with flexbox and provide a strong foundation for building all types of navigation
components. It includes some style overrides (for working with lists), some link padding for larger hit areas, and basic
disabled styling.
            """
        }
        div("bd-callout bd-callout-info") {
            Markdown {
                //language=Markdown
                +"""
The base `nav` component does not include any `active` state. The following examples include the property, mainly to
demonstrate that this particular value does not trigger any special styling.
                """
            }
        }
        liveExample {
            ulTestingNav()
        }
        codeExample {
            +Imports.builder().importNavComponents().build()

            +FunCall.builder(Navs::ul)
                .nestedBy(RBuilder::Navs)
                .setLambdaArgument(
                    testingNavItemsString()
                ).build()
        }
        Markdown {
            //language=Markdown
            +"""
Don't want to use `ul`? You can also use `ol`, `nav` or even just `div`.
            """
        }
        liveExample {
            olTestingNav()
            navTestingNav()
            divTestingNav()
        }
        codeExample {
            +Imports.builder().importNavComponents().build()

            +FunCall.builder(Navs::ol)
                .nestedBy(RBuilder::Navs)
                .setLambdaArgument(
                    testingNavItemsString()
                ).build()
            appendLine("")
            +FunCall.builder(Navs::nav)
                .nestedBy(RBuilder::Navs)
                .setLambdaArgument(
                    testingNavItemsString()
                ).build()
            appendLine("")
            +FunCall.builder(Navs::div)
                .nestedBy(RBuilder::Navs)
                .setLambdaArgument(
                    testingNavItemsString()
                ).build()
        }
        Markdown {
            //language=Markdown
            +"""
Because `Navs.nav { }` and `Navs.div { }` use `display: flex`, the nav links behave the same as nav items would, but
without the extra markup.
            """
        }
        liveExample {
            Navs.nav {
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
            +Imports.builder().importNavComponents().build()

            +FunCall.builder(Navs::nav)
                .nestedBy(RBuilder::Navs)
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
    }

    private fun RBuilder.ulTestingNav() {
        Navs.ul {
            navItem {
                navLink(href = "#", active = true) {
                    attrs { onClickFunction = { it.preventDefault() } }
                    +"Active"
                }
            }
            repeat(2) {
                navItem {
                    navLink(href = "#") {
                        attrs { onClickFunction = { it.preventDefault() } }
                        +"Link"
                    }
                }
            }
            navItem {
                navLink(href = "#", disabled = true) {
                    +"Disabled"
                }
            }
        }
    }

    private fun RBuilder.olTestingNav() {
        Navs.ol {
            navItem {
                navLink(href = "#", active = true) {
                    attrs { onClickFunction = { it.preventDefault() } }
                    +"Active"
                }
            }
            repeat(2) {
                navItem {
                    navLink(href = "#") {
                        attrs { onClickFunction = { it.preventDefault() } }
                        +"Link"
                    }
                }
            }
            navItem {
                navLink(href = "#", disabled = true) {
                    +"Disabled"
                }
            }
        }
    }

    private fun RBuilder.navTestingNav() {
        Navs.nav {
            navItem {
                navLink(href = "#", active = true) {
                    attrs { onClickFunction = { it.preventDefault() } }
                    +"Active"
                }
            }
            repeat(2) {
                navItem {
                    navLink(href = "#") {
                        attrs { onClickFunction = { it.preventDefault() } }
                        +"Link"
                    }
                }
            }
            navItem {
                navLink(href = "#", disabled = true) {
                    +"Disabled"
                }
            }
        }
    }

    private fun RBuilder.divTestingNav() {
        Navs.div {
            navItem {
                navLink(href = "#", active = true) {
                    attrs { onClickFunction = { it.preventDefault() } }
                    +"Active"
                }
            }
            repeat(2) {
                navItem {
                    navLink(href = "#") {
                        attrs { onClickFunction = { it.preventDefault() } }
                        +"Link"
                    }
                }
            }
            navItem {
                navLink(href = "#", disabled = true) {
                    +"Disabled"
                }
            }
        }
    }
}
