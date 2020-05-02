@file:Suppress("NAME_SHADOWING")

package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.ListItemStyles
import react.bootstrap.content.typography.ListStyles
import react.bootstrap.content.typography.li
import react.bootstrap.content.typography.ul
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.dom.code
import react.dom.h3
import react.dom.li
import react.dom.p
import react.dom.strong
import react.dom.ul

internal fun RBuilder.lists() {
    contentTitle("Lists")
    contentTitle(RBuilder::h3, "Unstyled")
    p {
        +"Remove the default "; code { +"list-style" }; +" and left margin on list items (immediate children only). "
        strong { +"This only applies to immediate children list items" }; +", meaning you will need to add the class "
        +"for any nested lists as well."
    }
    example {
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
    codeBox {
        ln { +"import react.bootstrap.content.typography.${ListStyles::class.simpleName}" }
        ln { +"import react.bootstrap.content.typography.ul" }
        ln { }
        ktBlock(0, "ul(${ListStyles.UNSTYLED.kt})") { il ->
            ln(il) { +"li { +\"Lorem ipsum dolor sit amet\" }" }
            ln(il) { +"li { +\"Consectetur adipiscing elit\" }" }
            ln(il) { +"li { +\"Integer molestie lorem at massa\" }" }
            ln(il) { +"li { +\"Facilisis in pretium nisl aliquet\" }" }
            ktBlock(il, "li") { il ->
                ln(il) { +"+\"Nulla volutpat aliquam \"" }
                ktBlock(il, "ul") { il ->
                    ln(il) { +"li { +\"Phasellus iaculis neque\" }" }
                    ln(il) { +"li { +\"Purus sodales ultricies\" }" }
                    ln(il) { +"li { +\"Vestibulum laoreet porttitor sem\" }" }
                    ln(il) { +"li { +\"Ac tristique libero volutpat at\" }" }
                }
            }
            ln(il) { +"li { +\"Faucibus porta lacus fringilla vel\" }" }
            ln(il) { +"li { +\"Aenean sit amet erat nunc\" }" }
            ln(il) { +"li { +\"Eget porttitor lorem\" }" }
        }
    }
    contentTitle(RBuilder::h3, "Inline")
    p {
        +"Remove a list’s bullets and apply some light "; code { +"margin" }; +" with a combination of two functions, "
        code { +"ul(${ListStyles.INLINE.kt}) { }" }; +" and "
        code { +"li(${ListItemStyles.INLINE.kt}) { }" }; +"."
    }
    example {
        ul(ListStyles.INLINE) {
            li(ListItemStyles.INLINE) { +"Lorem ipsum" }
            li(ListItemStyles.INLINE) { +"Phasellus iaculis" }
            li(ListItemStyles.INLINE) { +"Nulla volutpat" }
        }
    }
    codeBox {
        ln { +"import react.bootstrap.content.typography.${ListItemStyles::class.simpleName}" }
        ln { +"import react.bootstrap.content.typography.${ListStyles::class.simpleName}" }
        ln { +"import react.bootstrap.content.typography.li" }
        ln { +"import react.bootstrap.content.typography.ul" }
        ln { }
        ktBlock(0, "ul(${ListStyles.INLINE.kt}) ") { il ->
            ln(il) { +"li(${ListItemStyles.INLINE.kt}) { +\"Lorem ipsum\" }" }
            ln(il) { +"li(${ListItemStyles.INLINE.kt}) { +\"Phasellus iaculis\" }" }
            ln(il) { +"li(${ListItemStyles.INLINE.kt}) { +\"Nulla volutpat\" }" }
        }
    }
}
