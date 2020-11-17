package react.bootstrap.site.components.docs.components.navbar

import kotlinx.html.A
import kotlinx.html.SPAN
import kotlinx.html.classes
import react.RBuilder
import react.bootstrap.components.navbar.Navbar
import react.bootstrap.components.navbar.brand
import react.bootstrap.components.navbar.navbar
import react.bootstrap.helpers.addOrInit
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.lib.kotlinxhtml.addClass
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.liveExample
import react.dom.a

internal class SupportedContent : SectionComponent() {
    override val title: String = "Supported content"

    override fun RBuilder.render() {
        sectionTitle()
        liveExample {
            navbar(
                props = {
                    theme = Navbar.Theme.LIGHT
                }
            ) {
                attrs {
                    addClass(ClassNames.BG_LIGHT)
                }

                brand<A> {
                    attrs {
                        href = "#"
                    }
                    +"Navbar"
                }
            }
        }
        liveExample {
            navbar(
                props = {
                    theme = Navbar.Theme.LIGHT
                }
            ) {
                attrs {
                    addClass(ClassNames.BG_LIGHT)
                }

                brand<SPAN> {
                    attrs {
                        addClass(ClassNames.MB_0, ClassNames.H1)
                    }
                    +"Navbar"
                }
            }
        }
    }
}
