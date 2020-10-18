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
import react.bootstrap.layout.grid.col.ColAttributes
import react.bootstrap.layout.grid.col.col
import react.bootstrap.layout.grid.row.row
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.Quoted
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.layout.grid.colFun
import react.bootstrap.site.components.docs.layout.grid.rowFun
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.dom.RDOMBuilder
import react.dom.dd
import react.dom.dl
import react.dom.dt
import react.dom.li
import react.dom.p
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
            ktFun(ulFun, args = mapOf(null to ListStyles.UNSTYLED.nestedName)) {
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
Remove a list’s bullets and apply some light `margin` with a combination of two functions,
`ul(${ListStyles.INLINE.nestedName}) { }` and `li(${ListItemStyles.INLINE.nestedName}) { }`.
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
            ktFun(ulFun, args = mapOf(null to ListStyles.INLINE.nestedName)) {
                ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Lorem ipsum") }
                ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Phasellus iaculis") }
                ktFun(liFun, style = FunStyle.INLINE_BLOCK) { string("Nulla volutpat") }
            }
        }
        subSectionTitle("Description list alignment", section)
        Markdown {
            //language=Markdown
            +"""
Align terms and descriptions horizontally by using our grid system’s builder funs. For longer terms, you can optionally
add a `${ClassNames.TEXT_TRUNCATE.nestedName}` class to truncate the text with an ellipsis.
            """
        }
        liveExample {
            row(renderAs = { dl { } }) {
                col(sm = ColAttributes.Sizes.SZ_3, renderAs = { dt { } }) { +"Description lists" }
                col(sm = ColAttributes.Sizes.SZ_9, renderAs = { dd { } }) {
                    +"A description list is perfect for defining terms."
                }

                col(sm = ColAttributes.Sizes.SZ_3, renderAs = { dt { } }) { +"Euismod" }
                col(sm = ColAttributes.Sizes.SZ_9, renderAs = { dd { } }) {
                    p { +"Vestibulum id ligula porta felis euismod semper eget lacinia odio sem nec elit." }
                    p { +"Donec id elit non mi porta gravida at eget metus." }
                }

                col(sm = ColAttributes.Sizes.SZ_3, renderAs = { dt { } }) { +"Malesuada porta" }
                col(sm = ColAttributes.Sizes.SZ_9, renderAs = { dd { } }) {
                    +"Etiam porta sem malesuada magna mollis euismod."
                }

                col(classes = "${ClassNames.TEXT_TRUNCATE}", sm = ColAttributes.Sizes.SZ_3, renderAs = { dt { } }) {
                    +"Truncated term is truncated"
                }
                col(sm = ColAttributes.Sizes.SZ_9, renderAs = { dd { } }) {
                    +"""
Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massajustosit amet risus.
                    """
                }

                col(sm = ColAttributes.Sizes.SZ_3, renderAs = { dt { } }) { +"Nesting" }
                col(sm = ColAttributes.Sizes.SZ_9, renderAs = { dd { } }) {
                    row(renderAs = { dl { } }) {
                        col(sm = ColAttributes.Sizes.SZ_4, renderAs = { dt { } }) { +"Nested definition list" }
                        col(sm = ColAttributes.Sizes.SZ_8, renderAs = { dd { } }) {
                            +"Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc."
                        }
                    }
                }
            }
        }
        codeExample {
            val sz3 = buildNestedName(
                ColAttributes.Sizes.SZ_3::class,
                ColAttributes::class,
                ColAttributes.Sizes::class
            )
            val sz9 = buildNestedName(
                ColAttributes.Sizes.SZ_9::class,
                ColAttributes::class,
                ColAttributes.Sizes::class
            )

            val renderDl = "renderAs" to "{ dl { } }"
            val renderDt = "renderAs" to "{ dt { } }"
            val renderDd = "renderAs" to "{ dd { } }"
            val dtArgs = mapOf("sm" to sz3, renderDt)
            val ddArgs = mapOf("sm" to sz9, renderDd)

            import("layout.grid.col.${ColAttributes::class.simpleName!!}")
            import("layout.grid.col.$colFun")
            import("layout.grid.row.$rowFun")
            ln { }
            ktFun(RBuilder::row, args = mapOf(renderDl)) {
                ktFun(RBuilder::col, style = FunStyle.INLINE_BLOCK, args = dtArgs) {
                    string("Description lists")
                }
                ktFun(RBuilder::col, style = FunStyle.BLOCK, args = ddArgs) {
                    ln("A description list is perfect for defining terms.")
                }
                ln { }
                ktFun(RBuilder::col, style = FunStyle.INLINE_BLOCK, args = dtArgs) { string("Euismod") }
                ktFun(RBuilder::col, style = FunStyle.BLOCK, args = ddArgs) {
                    ktFun(RBuilder::p, style = FunStyle.INLINE_BLOCK) {
                        string("Vestibulum id ligula porta felis euismod semper eget lacinia odio sem nec elit.")
                    }
                    ktFun(RBuilder::p, style = FunStyle.INLINE_BLOCK) {
                        string("Donec id elit non mi porta gravida at eget metus.")
                    }
                }
                ln { }
                ktFun(RBuilder::col, style = FunStyle.INLINE_BLOCK, args = dtArgs) { string("Malesuada porta") }
                ktFun(RBuilder::col, style = FunStyle.BLOCK, args = ddArgs) {
                    ln("Etiam porta sem malesuada magna mollis euismod.")
                }
                ln { }
                ktFun(
                    RBuilder::col,
                    style = FunStyle.BLOCK,
                    args = mutableMapOf<String, Any>(
                        "classes" to Quoted("\${${ClassNames.TEXT_TRUNCATE.nestedName}}")
                    ).apply {
                        putAll(dtArgs)
                    }
                ) { ln("Truncated term is truncated") }
                ktFun(RBuilder::col, style = FunStyle.BLOCK, args = ddArgs) {
                    multiline(
                        "Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum" +
                            "massajustosit amet risus",
                        "."
                    )
                }
                ln { }
                ktFun(RBuilder::col, style = FunStyle.INLINE_BLOCK, args = dtArgs) { string("Nesting") }
                ktFun(RBuilder::col, style = FunStyle.BLOCK, args = ddArgs) {
                    ktFun(RBuilder::row, args = mapOf(renderDl)) {
                        ktFun(
                            RBuilder::col,
                            style = FunStyle.INLINE_BLOCK,
                            args = dtArgs.toMutableMap().apply {
                                put(
                                    "sm",
                                    buildNestedName(
                                        ColAttributes.Sizes.SZ_4::class,
                                        ColAttributes::class,
                                        ColAttributes.Sizes::class
                                    )
                                )
                            }
                        ) {
                            string("Nested definition list")
                        }
                        ktFun(
                            RBuilder::col,
                            style = FunStyle.BLOCK,
                            args = ddArgs.toMutableMap().apply {
                                put(
                                    "sm",
                                    buildNestedName(
                                        ColAttributes.Sizes.SZ_8::class,
                                        ColAttributes::class,
                                        ColAttributes.Sizes::class
                                    )
                                )
                            }
                        ) {
                            ln("Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc.")
                        }
                    }
                }
            }
        }
    }
}
