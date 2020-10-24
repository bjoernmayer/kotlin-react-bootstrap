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
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.layout.grid.colFun
import react.bootstrap.site.components.docs.layout.grid.rowFun
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Imports
import react.bootstrap.site.lib.codepoet.LambdaValue
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
        val loremList = listOf(
            null to "Lorem ipsum dolor sit amet",
            null to "Consectetur adipiscing elit",
            null to "Integer molestie lorem at massa",
            null to "Facilisis in pretium nisl aliquet",
            "Nulla volutpat aliquam " to listOf(
                "Phasellus iaculis neque",
                "Purus sodales ultricies",
                "Vestibulum laoreet porttitor sem",
                "Ac tristique libero volutpat at",
            ),
            null to "Faucibus porta lacus fringilla vel",
            null to "Aenean sit amet erat nunc",
            null to "Eget porttitor lorem",
        )
        liveExample {
            ul(ListStyles.UNSTYLED) {
                loremList.forEach { (key, value) ->
                    if (value is String) {
                        li { +value }
                    }

                    if (value is List<*>) {
                        li {
                            +key!!
                            ul {
                                value.forEach {
                                    li { +(it as String) }
                                }
                            }
                        }
                    }
                }
            }
        }
        val ulFun: KFunction3<RBuilder, String?, (RDOMBuilder<UL>.() -> Unit), ReactElement> = RBuilder::ul
        val liFun: KFunction3<RBuilder, String?, (RDOMBuilder<LI>.() -> Unit), ReactElement> = RBuilder::li
        codeExample {
            +Imports.builder()
                .addImport("content.typography.${ListStyles::class.simpleName}")
                .addImport("content.typography.ul")
                .build()

            +FunCall.builder(ulFun)
                .addArgument(ListStyles.UNSTYLED)
                .setLambdaArgument(
                    loremList.joinToString("") { (key, value) ->
                        if (value is String) {
                            FunCall.builder(liFun, FunCall.Style.NEW_INLINE)
                                .setLambdaArgument(plusString(value))
                                .build()
                        } else {
                            FunCall.builder(liFun)
                                .setLambdaArgument(
                                    plusString(key!!),
                                    "\n",
                                    FunCall.builder(ulFun)
                                        .setLambdaArgument(
                                            (value as List<*>).joinToString("") {
                                                FunCall.builder(liFun, FunCall.Style.NEW_INLINE)
                                                    .setLambdaArgument(plusString(it as String))
                                                    .build()
                                            }
                                        )
                                        .build()
                                )
                                .build()
                        }
                    }
                )
                .build()
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
            +Imports.builder()
                .addImport("content.typography.${ListItemStyles::class.simpleName}")
                .addImport("content.typography.${ListStyles::class.simpleName}")
                .addImport("content.typography.li")
                .addImport("content.typography.ul")
                .build()

            +FunCall.builder(ulFun)
                .addArgument(ListStyles.INLINE)
                .setLambdaArgument(
                    listOf("Lorem ipsum", "Phasellus iaculis", "Nulla volutpat").joinToString("\n") {
                        FunCall.builder(liFun, FunCall.Style.INLINE)
                            .setLambdaArgument(plusString(it))
                            .build()
                    }
                )
                .build()
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
            val sz3 = buildString {
                append(ColAttributes.Sizes::class.nestedName)
                append(".")
                append(ColAttributes.Sizes.Companion::SZ_3.name)
            }
            val sz9 = buildString {
                append(ColAttributes.Sizes::class.nestedName)
                append(".")
                append(ColAttributes.Sizes.Companion::SZ_9.name)
            }

            fun FunCall.addSz3Argument(): FunCall {
                addArgument("sm", FunCall.Argument.PureValue(sz3))
                return this
            }

            fun FunCall.addSz9Argument(): FunCall {
                addArgument("sm", FunCall.Argument.PureValue(sz9))
                return this
            }

            fun FunCall.addDtArgument(): FunCall {
                addArgument(
                    "renderAs",
                    LambdaValue(
                        FunCall.builder(RBuilder::dt, FunCall.Style.INLINE)
                            .setEmptyLambdaArgument()
                            .build(),
                        LambdaValue.Style.INLINE
                    )
                )
                return this
            }

            fun FunCall.addDdArgument(): FunCall {
                addArgument(
                    "renderAs",
                    LambdaValue(
                        FunCall.builder(RBuilder::dd, FunCall.Style.INLINE)
                            .setEmptyLambdaArgument()
                            .build(),
                        LambdaValue.Style.INLINE
                    )
                )
                return this
            }

            +Imports.builder()
                .addImport("layout.grid.col.${ColAttributes::class.simpleName!!}")
                .addImport("layout.grid.col.$colFun")
                .addImport("layout.grid.row.$rowFun")
                .build()

            +FunCall.builder(RBuilder::row)
                .addArgument(
                    "renderAs",
                    LambdaValue(
                        FunCall.builder(RBuilder::dl, FunCall.Style.INLINE)
                            .setEmptyLambdaArgument()
                            .build(),
                        LambdaValue.Style.INLINE
                    )
                )
                .setLambdaArgument(
                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                        .addSz3Argument()
                        .addDtArgument()
                        .setLambdaArgument(plusString("Description lists"))
                        .build(),
                    FunCall.builder(RBuilder::col)
                        .addSz9Argument()
                        .addDdArgument()
                        .setLambdaArgument(plusString("A description list is perfect for defining terms."))
                        .build(),
                    "\n",
                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                        .addSz3Argument()
                        .addDtArgument()
                        .setLambdaArgument(plusString("Euismod"))
                        .build(),
                    FunCall.builder(RBuilder::col)
                        .addSz9Argument()
                        .addDdArgument()
                        .setLambdaArgument(
                            FunCall.builder(RBuilder::p, FunCall.Style.NEW_INLINE)
                                .setLambdaArgument(
                                    plusString(
                                        "Vestibulum id ligula porta felis euismod semper eget lacinia odio " +
                                            "sem nec elit."
                                    )
                                )
                                .build(),
                            FunCall.builder(RBuilder::p, FunCall.Style.INLINE)
                                .setLambdaArgument(plusString("Donec id elit non mi porta gravida at eget metus."))
                                .build()
                        )
                        .build(),
                    "\n",
                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                        .addSz3Argument()
                        .addDtArgument()
                        .setLambdaArgument(plusString("Malesuada porta"))
                        .build(),
                    FunCall.builder(RBuilder::col)
                        .addSz9Argument()
                        .addDdArgument()
                        .setLambdaArgument(plusString("Etiam porta sem malesuada magna mollis euismod."))
                        .build(),
                    "\n",
                    FunCall.builder(RBuilder::col)
                        .addArgument("classes", ClassNames.TEXT_TRUNCATE)
                        .addSz3Argument()
                        .addDtArgument()
                        .setLambdaArgument(plusString("Truncated term is truncated"))
                        .build(),
                    FunCall.builder(RBuilder::col)
                        .addSz9Argument()
                        .addDdArgument()
                        .setLambdaArgument(
                            plusString(
                                "Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut " +
                                    "fermentum "
                            ),
                            "\n",
                            plusString("massajustosit amet risus.")
                        )
                        .build(),
                    "\n",
                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                        .addSz3Argument()
                        .addDtArgument()
                        .setLambdaArgument(plusString("Nesting"))
                        .build(),
                    FunCall.builder(RBuilder::col)
                        .addSz9Argument()
                        .addDdArgument()
                        .setLambdaArgument(
                            FunCall.builder(RBuilder::row)
                                .addArgument(
                                    "renderAs",
                                    LambdaValue(
                                        FunCall.builder(RBuilder::dl, FunCall.Style.INLINE)
                                            .setEmptyLambdaArgument()
                                            .build(),
                                        LambdaValue.Style.INLINE
                                    )
                                )
                                .setLambdaArgument(
                                    FunCall.builder(RBuilder::col, FunCall.Style.NEW_INLINE)
                                        .addArgument(
                                            "sm",
                                            FunCall.Argument.PureValue(
                                                buildString {
                                                    append(ColAttributes.Sizes::class.nestedName)
                                                    append(".")
                                                    append(ColAttributes.Sizes.Companion::SZ_4.name)
                                                }
                                            )
                                        )
                                        .addDtArgument()
                                        .setLambdaArgument(plusString("Nested definition list"))
                                        .build(),
                                    FunCall.builder(RBuilder::col)
                                        .addArgument(
                                            "sm",
                                            FunCall.Argument.PureValue(
                                                buildString {
                                                    append(ColAttributes.Sizes::class.nestedName)
                                                    append(".")
                                                    append(ColAttributes.Sizes.Companion::SZ_8.name)
                                                }
                                            )
                                        )
                                        .addDdArgument()
                                        .setLambdaArgument(
                                            plusString(
                                                "Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc."
                                            ),
                                        )
                                        .build(),
                                )
                                .build()
                        )
                        .build(),
                )
                .build()
        }
    }
}
