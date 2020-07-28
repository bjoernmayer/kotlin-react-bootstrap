@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.content.typography

import kotlinx.html.LI
import kotlinx.html.UL
import react.RBuilder
import react.ReactElement
import react.bootstrap.content.typography.ListItemStyles
import react.bootstrap.content.typography.ListStyles
import react.bootstrap.content.typography.li
import react.bootstrap.content.typography.ul
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.external.Markdown
import react.dom.RDOMBuilder
import react.dom.li
import react.dom.ul
import kotlin.reflect.KFunction3

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
        val ulFun: KFunction3<RBuilder, String?, (RDOMBuilder<UL>.() -> Unit), ReactElement> = RBuilder::ul
        val liFun: KFunction3<RBuilder, String?, (RDOMBuilder<LI>.() -> Unit), ReactElement> = RBuilder::li
        codeExample {
            import("content.typography.${ListStyles::class.simpleName}")
            import("content.typography.ul")
            ln { }
            ktFun(ulFun, args = mapOf(null to ListStyles.UNSTYLED.kt)) {
                ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Lorem ipsum dolor sit amet") }
                ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Consectetur adipiscing elit") }
                ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Integer molestie lorem at massa") }
                ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Facilisis in pretium nisl aliquet") }
                ktFun(liFun) {
                    ln("Nulla volutpat aliquam ")
                    ktFun(ulFun) {
                        ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Phasellus iaculis neque") }
                        ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Purus sodales ultricies") }
                        ktFun(
                            liFun,
                            style = FunStyle.INLINE_BLOCK
                        ) { string("Vestibulum laoreet porttitor sem") }
                        ktFun(
                            liFun,
                            style = FunStyle.INLINE_BLOCK
                        ) { string("Ac tristique libero volutpat at") }
                    }
                }
                ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Faucibus porta lacus fringilla vel") }
                ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Aenean sit amet erat nunc") }
                ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Eget porttitor lorem") }
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
            ktFun(ulFun, args = mapOf(null to ListStyles.INLINE.kt)) {
                ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Lorem ipsum") }
                ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Phasellus iaculis") }
                ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Nulla volutpat") }
            }
        }
    }
}
