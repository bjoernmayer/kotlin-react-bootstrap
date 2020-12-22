package react.bootstrap.site.components.docs.components.navbar

import kotlinx.html.A
import kotlinx.html.HtmlInlineTag
import kotlinx.html.NAV
import kotlinx.html.SPAN
import kotlinx.html.id
import react.RBuilder
import react.RElementBuilder
import react.RProps
import react.bootstrap.components.nav.navLink
import react.bootstrap.components.navbar.Navbar
import react.bootstrap.components.navbar.NavbarNavs
import react.bootstrap.components.navbar.brand
import react.bootstrap.components.navbar.collapse
import react.bootstrap.components.navbar.navItem
import react.bootstrap.components.navbar.navbar
import react.bootstrap.components.navbar.toggler
import react.bootstrap.helpers.classes
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.Assignment
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.bootstrap.site.lib.codepoet.LineComment
import react.dom.span

internal class SupportedContent : SectionComponent() {
    override val title: String = "Supported content"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
Navbars come with built-in support for a handful of sub-components. Choose from the following as needed:

- `.brand()` for your company, product, or project name.
- `.nav()` for a full-height and lightweight navigation.
- `.text()` for adding vertically centered strings of text.

Here’s an example of all the sub-components included in a responsive light-themed navbar.
            """
        }
        liveExample {
            navbar<NAV>(classes(ClassNames.BG_LIGHT), expand = Breakpoints.LG, theme = Navbar.Theme.LIGHT) {
                brand<A> {
                    attrs {
                        href = "#"
                    }
                    +"Navbar"
                }
                toggler { }
                collapse(
                    props = {
                        // instead I could require the property of the div. this is possible
                        id = "navbarSupportedContent"
                    }
                ) {
                }
            }
        }
        subSectionTitle("Brand")
        Markdown {
            //language=Markdown
            +"""
The `.brand` element is a generic component and can be applied to all `${HtmlInlineTag::class.simpleName}`s, but an
anchor works best as some elements might require utility classes or custom styles.
            """
        }
        liveExample {
            navbar<NAV>(classes(ClassNames.BG_LIGHT), theme = Navbar.Theme.LIGHT) {
                brand<A> {
                    attrs {
                        href = "#"
                    }
                    +"Navbar"
                }
            }
            navbar<NAV>(classes(ClassNames.BG_LIGHT), theme = Navbar.Theme.LIGHT) {
                brand<SPAN>(classes(ClassNames.MB_0, ClassNames.H1)) {
                    +"Navbar"
                }
            }
        }
        codeExample {
            +Imports.builder()
                .addImport("components.navbar.${Navbar::class.simpleName}")
                .addImport("components.navbar.${Navbar.DomBuilder<*>::brand.name}")
                .addImport("components.navbar.${RBuilder::navbar.name}")
                .importClassNames()
                .build()
            +LineComment.builder("As a link").build()
            +FunCall.builder(::navbar)
                .addTypeParameter(NAV::class)
                .addArgument(FunCall.builder(::classes, FunCall.Style.INLINE).addArgument(ClassNames.BG_LIGHT))
                .addArgument("theme", Navbar.Theme.LIGHT)
                .setLambdaArgument(
                    FunCall.builder(Navbar.DomBuilder<*>::brand)
                        .addTypeParameter(A::class)
                        .setLambdaArgument(
                            FunCall.builder(RElementBuilder<RProps>::attrs)
                                .setLambdaArgument(Assignment.builder(A::href).value("#").build())
                                .build(),
                            plusString("Navbar")
                        )
                        .build()
                ).build()
            +LineComment.builder("As a heading").build()
            +FunCall.builder(::navbar)
                .addTypeParameter(NAV::class)
                .addArgument(FunCall.builder(::classes, FunCall.Style.INLINE).addArgument(ClassNames.BG_LIGHT))
                .addArgument("theme", Navbar.Theme.LIGHT)
                .setLambdaArgument(
                    FunCall.builder(Navbar.DomBuilder<*>::brand)
                        .addTypeParameter(SPAN::class)
                        .addArgument(
                            FunCall.builder(::classes, FunCall.Style.INLINE)
                                .addArgument(ClassNames.MB_0)
                                .addArgument(ClassNames.H1)
                        )
                        .setLambdaArgument(plusString("Navbar"))
                        .build()
                ).build()
        }

        subSectionTitle("Nav")
        liveExample {
            navbar<NAV>(theme = Navbar.Theme.LIGHT, expand = Breakpoints.LG) {
                brand<A> {
                    attrs {
                        href = "#"
                    }
                    +"Navbar"
                }
                // todo in navbar navs also items can be active. LOLOLOLOL
                // Also you need to find out how you want to build the toggling.
                NavbarNavs.ul {
                    navItem {
                        navLink("#", active = true) {
                            +"Home"
                            span(classes(ClassNames.SR_ONLY)) { +"current" }
                        }
                    }
                    navItem {
                        navLink {
                            +"Features"
                        }
                    }
                    navItem {
                        navLink {
                            +"Pricing"
                        }
                    }
                    navItem {
                        navLink(disabled = true) {
                            +"Disabled"
                        }
                    }
                }
            }
        }
    }
}
