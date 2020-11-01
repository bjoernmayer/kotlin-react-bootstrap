package react.bootstrap.site.components.docs.components.navs

import react.RBuilder
import react.RElementBuilder
import react.RProps
import react.bootstrap.components.button.Button
import react.bootstrap.components.nav.Navs
import react.bootstrap.components.nav.Navs.Appearance
import react.bootstrap.components.nav.navItem
import react.bootstrap.components.nav.navLink
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.importNavComponents
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.Assignment
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Generic
import react.bootstrap.site.lib.codepoet.Imports
import react.bootstrap.site.lib.codepoet.LambdaValue
import react.bootstrap.site.lib.codepoet.When
import react.child
import react.dom.div
import react.dom.h3
import react.functionalComponent
import react.getValue
import react.setValue
import react.useState

internal class ActiveState : SectionComponent() {
    override val title: String = "Active state"

    override fun RBuilder.render() {
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
In a few examples above you will see a visual change, when clicking through the nav points. This is because, they are
 marked as active on a click. Here we will show you two ways to accomplish this.
            """
        }
        div(classes = "bd-callout bd-callout-info") {
            Markdown {
                //language=Markdown
                +"""
There will be a separate `Tab` component in the future which simplifies building such an interfce.
                """
            }
        }
        subSectionTitle("React's useState", section)
        Markdown {
            //language=Markdown
            +"""
In this example we make use of Reacts `useState` to quickly build a functional component which generates the active
behaviour.
            """
        }

        val linkExampleMap = mapOf(
            0 to "Link",
            1 to "Zelda",
            2 to "Impa",
            3 to "Ravio"
        )
        liveExample {
            child(
                functionalComponent {
                    var activeNavLink by useState(0)

                    Navs.ul(appearance = Appearance.TABS) {
                        linkExampleMap.forEach { (active, text) ->
                            navItem {
                                navLink(href = "#", active = activeNavLink == active) {
                                    attrs {
                                        onClick = {
                                            it.preventDefault()
                                            activeNavLink = active
                                        }
                                    }
                                    +text
                                }
                            }
                        }
                    }
                    h3(classes = "${ClassNames.MT_3}") {
                        +when (activeNavLink) {
                            0 -> "Content about Link"
                            1 -> "Content about Zelda"
                            2 -> "Content about Impa"
                            3 -> "Content about Ravio"
                            else -> "No Active page"
                        }
                    }
                }
            )
        }
        codeExample {
            +Imports.builder()
                .importNavComponents()
                .importClassNames()
                .build()

            +FunCall.builder("child")
                .addArgument(
                    FunCall.builder(Generic("functionalComponent", "RProps"))
                        .setLambdaArgument(
                            Assignment.builder("activeNavLink")
                                .varType()
                                .value(
                                    Assignment.FunCallDelegate(
                                        FunCall.builder("useState")
                                            .addArgument(0)
                                    )
                                )
                                .build(),
                            "\n\n",
                            FunCall.builder(Navs::ul)
                                .nestedBy(RBuilder::Navs)
                                .addArgument("appearance", Appearance.TABS)
                                .setLambdaArgument(
                                    buildString {
                                        linkExampleMap.forEach { (active, text) ->
                                            append(
                                                FunCall.builder(navItemBuilderFun)
                                                    .setLambdaArgument(
                                                        FunCall.builder(navLinkBuilderFun)
                                                            .addArgument("href", "#")
                                                            .addArgument(
                                                                "active",
                                                                FunCall.Argument.PureValue("activeNavLink == $active")
                                                            )
                                                            .setLambdaArgument(
                                                                FunCall.builder(RElementBuilder<RProps>::attrs)
                                                                    .setLambdaArgument(
                                                                        Assignment.builder(Button.Props::onClick)
                                                                            .value(
                                                                                LambdaValue(
                                                                                    "it.preventDefault()\n" +
                                                                                        "activeNavLink = $active",
                                                                                    LambdaValue.Style.BLOCK
                                                                                )
                                                                            )
                                                                            .build()
                                                                    )
                                                                    .build(),
                                                                plusString(text)
                                                            )
                                                            .build()
                                                    )
                                                    .build()
                                            )
                                        }
                                    }

                                )
                                .build(),
                            FunCall.builder(RBuilder::h3)
                                .addArgument("classes", ClassNames.MT_3)
                                .setLambdaArgument(
                                    "+",
                                    When.builder("activeNavLink")
                                        .addBranch("0", "\"Content about Link\"")
                                        .addBranch("1", "\"Content about Zelda\"")
                                        .addBranch("2", "\"Content about Impa\"")
                                        .addBranch("3", "\"Content about Ravio\"")
                                        .addElse("\"No Active page\"")
                                        .build()
                                )
                                .build()

                        )
                )
                .build()
        }

        subSectionTitle("Active predicate", section)
        /*
         This Active Predicate means:


         I need to find the navItems if there are any.
         And in there I need to find NavLinks.

         In the navLinks I have to set a new event handler on the onClick. The handler lives in the nav.
         The handler will just update the "current active" nav link and triggers a rerender.

         Problem here: I had this problem somewhere else already. I need to check if the user already  did set an
         event handler for the click. Then I need to trigger both.

         All in all it's just stuff that I have done already
         */

        liveExample {
            Navs.ul(
                appearance = Appearance.PILLS,
                activeLinkPredicate = {
                    it.props.id == "thisOneIsActive"
                }
            ) {
                navItem {
                    navLink(href = "#", active = true) {
                        attrs {
                            id = "thisOneIsActive"
                        }
                        +"Active"
                    }
                }
                navItem {
                    navLink(href = "#") {
                        +"Link"
                    }
                }
                navItem {
                    navLink(href = "#") {
                        +"Link"
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
}
