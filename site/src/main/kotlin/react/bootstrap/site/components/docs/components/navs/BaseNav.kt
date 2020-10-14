@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.components.navs

import kotlinx.html.DIV
import react.RBuilder
import react.bootstrap.components.nav.Navs
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.Quoted
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.dom.RDOMBuilder
import react.dom.div

internal class BaseNav : SectionComponent() {
    override val title: String = "Base nav"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
The base `nav` component is built with flexbox and provide a strong foundation for building all types of navigation
components. It includes some style overrides (for working with lists), some link padding for larger hit areas, and basic
disabled styling.
            """
        }
        div(classes = "bd-callout bd-callout-info") {
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
            importNavsBuilder()
            importNavItemBuilder()
            importNavLinkBuilder()
            ln { }
            ktFun(
                Navs::ul,
                navsBuilderParents,
                style = FunStyle.BLOCK
            ) {
                ktFun(
                    navItemBuilderFun,
                    style = FunStyle.BLOCK
                ) {
                    ktFun(
                        navLinkBuilderFun,
                        style = FunStyle.BLOCK,
                        args = mapOf(
                            "href" to Quoted("#"),
                            "active" to true
                        )
                    ) {
                        ln("Active")
                    }
                }
                repeat(2) {
                    ktFun(
                        navItemBuilderFun,
                        style = FunStyle.BLOCK
                    ) {
                        ktFun(
                            navLinkBuilderFun,
                            style = FunStyle.BLOCK,
                            args = mapOf(
                                "href" to Quoted("#")
                            )
                        ) {
                            ln("Link")
                        }
                    }
                }
                ktFun(
                    navItemBuilderFun,
                    style = FunStyle.BLOCK
                ) {
                    ktFun(
                        navLinkBuilderFun,
                        style = FunStyle.BLOCK,
                        args = mapOf(
                            "href" to Quoted("#"),
                            "disabled" to true
                        )
                    ) {
                        ln("Disabled")
                    }
                }
            }
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
            importNavsBuilder()
            importNavItemBuilder()
            importNavLinkBuilder()
            ln { }
            // Todo: Add Code Examples for all three
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
            importNavsBuilder()
            importNavItemBuilder()
            importNavLinkBuilder()
            ln { }
            ktFun(
                Navs::nav,
                navsBuilderParents,
                style = FunStyle.BLOCK
            ) {
                ktFun(
                    navLinkBuilderFun,
                    style = FunStyle.BLOCK,
                    args = mapOf(
                        "href" to Quoted("#"),
                        "active" to true
                    )
                ) {
                    ln("Active")
                }
                repeat(2) {
                    ktFun(
                        navLinkBuilderFun,
                        style = FunStyle.BLOCK,
                        args = mapOf(
                            "href" to Quoted("#")
                        )
                    ) {
                        ln("Link")
                    }
                }
                ktFun(
                    navLinkBuilderFun,
                    style = FunStyle.BLOCK,
                    args = mapOf(
                        "href" to Quoted("#"),
                        "disabled" to true
                    )
                ) {
                    ln("Disabled")
                }
            }
        }
    }

    private fun RDOMBuilder<DIV>.ulTestingNav() {
        Navs.ul {
            navItem {
                navLink(href = "#", active = true) {
                    +"Active"
                }
            }
            repeat(2) {
                navItem {
                    navLink(href = "#") {
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

    private fun RDOMBuilder<DIV>.olTestingNav() {
        Navs.ol {
            navItem {
                navLink(href = "#", active = true) {
                    +"Active"
                }
            }
            repeat(2) {
                navItem {
                    navLink(href = "#") {
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

    private fun RDOMBuilder<DIV>.navTestingNav() {
        Navs.nav {
            navItem {
                navLink(href = "#", active = true) {
                    +"Active"
                }
            }
            repeat(2) {
                navItem {
                    navLink(href = "#") {
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

    private fun RDOMBuilder<DIV>.divTestingNav() {
        Navs.div {
            navItem {
                navLink(href = "#", active = true) {
                    +"Active"
                }
            }
            repeat(2) {
                navItem {
                    navLink(href = "#") {
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
