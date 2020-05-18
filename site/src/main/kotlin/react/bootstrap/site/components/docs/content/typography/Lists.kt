@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.ListItemStyles
import react.bootstrap.content.typography.ListStyles
import react.bootstrap.content.typography.li
import react.bootstrap.content.typography.ul
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.import
import react.bootstrap.site.components.docs.fixings.ktB
import react.bootstrap.site.components.docs.fixings.ktF
import react.bootstrap.site.components.docs.fixings.ktIB
import react.bootstrap.site.components.docs.fixings.ktIF
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.fixings.ln
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.external.Markdown
import react.dom.li
import react.dom.ul

internal class Lists : SectionComponent() {
    override val title: String = "Lists"

    override fun RBuilder.render() {
        sectionTitle(section)
        subSectionTitle("Unstyled", section)
        Markdown {
            //language=Markdown
            +"""
Remove the default `list-style` and left margin on list items (immediate children only). __This only applies to
immediate children list items__, meaning you will need to add the class for any nested lists as well.
            """
        }
        liveExample {
            ul(ListStyles.UNSTYLED) {
                li { +"Lorem ipsum dolor sit amet" }
                li { +"Consectetur adipiscing elit" }
                li { +"Integer molestie lorem at massa" }
                li { +"Facilisis in pretium nisl aliquet" }
                li {
                    +"Nulla volutpat aliquam "
                    ul {
                        li { +"Phasellus iaculis neque" }
                        li { +"Purus sodales ultricies" }
                        li { +"Vestibulum laoreet porttitor sem" }
                        li { +"Ac tristique libero volutpat at" }
                    }
                }
                li { +"Faucibus porta lacus fringilla vel" }
                li { +"Aenean sit amet erat nunc" }
                li { +"Eget porttitor lorem" }
            }
        }
        codeExample {
            import("content.typography.${ListStyles::class.simpleName}")
            import("content.typography.ul")
            ln { }
            ktF(0, "ul", ListStyles.UNSTYLED.kt) {
                ktIB(it, "li", "+\"Lorem ipsum dolor sit amet\"")
                ktIB(it, "li", "+\"Consectetur adipiscing elit\"")
                ktIB(it, "li", "+\"Integer molestie lorem at massa\"")
                ktIB(it, "li", "+\"Facilisis in pretium nisl aliquet\"")
                ktB(it, "li") {
                    ln(it) { +"+\"Nulla volutpat aliquam \"" }
                    ktB(it, "ul") {
                        ktIB(it, "li", "+\"Phasellus iaculis neque\"")
                        ktIB(it, "li", "+\"Purus sodales ultricies\"")
                        ktIB(it, "li", "+\"Vestibulum laoreet porttitor sem\"")
                        ktIB(it, "li", "+\"Ac tristique libero volutpat at\"")
                    }
                }
                ktIB(it, "li", "+\"Faucibus porta lacus fringilla vel\"")
                ktIB(it, "li", "+\"Aenean sit amet erat nunc\"")
                ktIB(it, "li", "+\"Eget porttitor lorem\"")
            }
        }
        subSectionTitle("Inline", section)
        Markdown {
            //language=Markdown
            +"""
Remove a list’s bullets and apply some light `margin` with a combination of two functions, `ul(${ListStyles.INLINE.kt})
{ }` and `li(${ListItemStyles.INLINE.kt}) { }`.
            """
        }
        liveExample {
            ul(ListStyles.INLINE) {
                li(ListItemStyles.INLINE) { +"Lorem ipsum" }
                li(ListItemStyles.INLINE) { +"Phasellus iaculis" }
                li(ListItemStyles.INLINE) { +"Nulla volutpat" }
            }
        }
        codeExample {
            import("content.typography.${ListItemStyles::class.simpleName}")
            import("content.typography.${ListStyles::class.simpleName}")
            import("content.typography.li")
            import("content.typography.ul")
            ln { }
            ktF(0, "ul", ListStyles.INLINE.kt) {
                ktIF(it, "li", ListItemStyles.INLINE.kt, "Lorem ipsum")
                ktIF(it, "li", ListItemStyles.INLINE.kt, "Phasellus iaculis")
                ktIF(it, "li", ListItemStyles.INLINE.kt, "Nulla volutpat")
            }
        }
    }
}
