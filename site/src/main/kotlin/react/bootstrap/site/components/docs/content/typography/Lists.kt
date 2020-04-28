package react.bootstrap.site.components.docs.content.typography

import react.RBuilder
import react.bootstrap.content.typography.ListItemStyles
import react.bootstrap.content.typography.ListStyles
import react.bootstrap.content.typography.li
import react.bootstrap.content.typography.ul
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.fixings.kotlinExample
import react.bootstrap.site.components.docs.kt
import react.dom.br
import react.dom.code
import react.dom.h3
import react.dom.li
import react.dom.p
import react.dom.strong

fun RBuilder.lists() {
    contentTitle("Lists") { }
    contentTitle(RBuilder::h3, "Unstyled") { }
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
    kotlinExample {
        +"ul(${ListStyles.UNSTYLED.kt}) {"; br { }
        +"    li { +\"Lorem ipsum dolor sit amet\" }"; br { }
        +"    li { +\"Consectetur adipiscing elit\" }"; br { }
        +"    li { +\"Integer molestie lorem at massa\" }"; br { }
        +"    li { +\"Facilisis in pretium nisl aliquet\" }"; br { }
        +"    li {"; br { }
        +"        +\"Nulla volutpat aliquam \""; br { }
        +"        ul {"; br { }
        +"            li { +\"Phasellus iaculis neque\" }"; br { }
        +"            li { +\"Purus sodales ultricies\" }"; br { }
        +"            li { +\"Vestibulum laoreet porttitor sem\" }"; br { }
        +"            li { +\"Ac tristique libero volutpat at\" }"; br { }
        +"        }"; br { }
        +"    }"; br { }
        +"    li { +\"Faucibus porta lacus fringilla vel\" }"; br { }
        +"    li { +\"Aenean sit amet erat nunc\" }"; br { }
        +"    li { +\"Eget porttitor lorem\" }"; br { }
        +"}"
    }
    contentTitle(RBuilder::h3, "Inline") { }
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
}
