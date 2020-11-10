package react.bootstrap.site.components.docs.components.navbar

import kotlinx.html.A
import kotlinx.html.classes
import react.RBuilder
import react.bootstrap.components.navbar.Navbar
import react.bootstrap.components.navbar.brand
import react.bootstrap.lib.bootstrap.Breakpoints
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.liveExample
import react.dom.a

internal class SupportedContent : SectionComponent() {
    override val title: String = "Supported content"

    override fun RBuilder.render() {
        sectionTitle()
        liveExample {
            child(Navbar::class) {
                attrs {
                    expand = Breakpoints.LG
                    theme = Navbar.Theme.LIGHT
                    classes = setOf(ClassNames.BG_LIGHT.className)
                }

                brand<A>(ClassNames.TEXT_PRIMARY.className) {
                    attrs {
                        href = "#"
                    }
                    +"Navbar"
                }
                a {
                    attrs {
                        classes = setOf(ClassNames.NAVBAR_BRAND.className)
                    }
                    +"Navbar"
                }
            }
        }
    }
}
