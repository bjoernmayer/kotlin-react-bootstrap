@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.components.alerts

import kotlinx.html.currentTimeMillis
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RElementBuilder
import react.RProps
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.AlertBuilder
import react.bootstrap.components.alert.Alerts
import react.bootstrap.components.alert.closingElement
import react.bootstrap.components.alert.link
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.Buttons
import react.bootstrap.lib.DomTag
import react.bootstrap.lib.bootstrap.ClassNames
import react.bootstrap.site.components.docs.components.buttons.outlineDangerFun
import react.bootstrap.site.components.docs.components.buttons.solidInfoFun
import react.bootstrap.site.components.docs.components.buttons.solidSuccessFun
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.Assignment
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.Generic
import react.bootstrap.site.lib.codepoet.If
import react.bootstrap.site.lib.codepoet.Imports
import react.bootstrap.site.lib.codepoet.LambdaValue
import react.child
import react.dom.h4
import react.dom.hr
import react.dom.p
import react.dom.strong
import react.functionalComponent
import react.getValue
import react.setValue
import react.useState
import kotlin.js.Console

internal class Examples : SectionComponent() {
    override val title: String = "Examples"

    override fun RBuilder.render() {
        sectionTitle()
        Markdown {
            //language=Markdown
            +"""
Alerts are available for any length of text, as well as an optional dismiss button. For proper styling, use one of the
eight __required__ variants (e.g., `${Alert.Variants.SUCCESS.nestedName}`).
            """
        }
        val variants = mapOf(
            Alert.Variants.DANGER to Alerts::danger,
            Alert.Variants.DARK to Alerts::dark,
            Alert.Variants.INFO to Alerts::info,
            Alert.Variants.LIGHT to Alerts::light,
            Alert.Variants.PRIMARY to Alerts::primary,
            Alert.Variants.SECONDARY to Alerts::secondary,
            Alert.Variants.SUCCESS to Alerts::success,
            Alert.Variants.WARNING to Alerts::warning
        )

        liveExample {
            variants.forEach { (variant, _) ->
                AlertBuilder(this).apply {
                    alert(variant = variant) {
                        +"A simple ${variant.name.toLowerCase()} alert-check it out!"
                    }
                }
            }
        }
        codeExample {
            +Imports.builder()
                .addImport("components.alert.Alerts")
                .build()
            variants.forEach { (variant, function) ->
                +FunCall.builder(function)
                    .nestedBy(RBuilder::Alerts)
                    .setLambdaArgument(plusString("A simple ${variant.name.toLowerCase()} alert-check it out!"))
                    .build()
            }
        }
        subSectionTitle("Link color")
        Markdown {
            //language=Markdown
            +"""
Use the `${Alert.DomBuilder<*>::link.name}`-function (only available inside
`${Alert.DomBuilder::class.nestedName}` to quickly provide matching colored links within any alert.
            """
        }
        liveExample {
            variants.forEach { (variant, _) ->
                AlertBuilder(this).apply {
                    alert(variant = variant) {
                        +"A simple ${variant.name.toLowerCase()} alert with "
                        link(href = "#") { +"an example link" }; +". Give it a click if you like."
                    }
                }
            }
        }
        codeExample {
            +Imports.builder()
                .addImport("components.alert.${Alert.DomBuilder<*>::link.name}")
                .addImport("components.alert.Alerts")
                .build()
            variants.forEach { (variant, function) ->
                +FunCall.builder(function)
                    .nestedBy(RBuilder::Alerts)
                    .setLambdaArgument(
                        plusString("A simple ${variant.name.toLowerCase()} alert with "),
                        "\n",
                        FunCall.builder(Alert.DomBuilder<*>::link, FunCall.Style.INLINE)
                            .addArgument("href", "#")
                            .setLambdaArgument(plusString("an example link"))
                            .build(),
                        " ${plusString(". Give it a click if you like.")}"
                    ).build()
            }
        }
        subSectionTitle("Additional content")
        p {
            +"""
Alerts can also contain additional HTML elements like headings, paragraphs and dividers.
            """
        }
        liveExample {
            Alerts.success {
                h4 { +"Well done!" }
                p {
                    +"""
Aww yeah, you successfully read this important alert message. This example text is going to run a bit longer so that you
 can see how spacing within an alert works with this kind of content.
                    """
                }
                hr { }
                p(classes = "${ClassNames.MB_0}") {
                    +"Whenever you need to, be sure to use margin utilities to keep things nice and tidy."
                }
            }
        }
        codeExample {
            +Imports.builder()
                .addImport("components.alert.Alerts")
                .addImport("components.alert.h4")
                .importClassNames()
                .build()
            +FunCall.builder(Alerts::success)
                .nestedBy(RBuilder::Alerts)
                .setLambdaArgument(
                    FunCall.builder("h4", FunCall.Style.NEW_INLINE)
                        .setLambdaArgument(plusString("Well done!"))
                        .build(),
                    FunCall.builder(RBuilder::p)
                        .setLambdaArgument(
                            plusString(
                                "Aww yeah, you successfully read this important alert message. This example text is " +
                                    "going to run a "
                            ),
                            "\n",
                            plusString(
                                "bit longer so that you  can see how spacing within an alert works with this kind of" +
                                    " content."
                            )
                        ).build(),
                    FunCall.builder(RBuilder::hr, FunCall.Style.NEW_INLINE)
                        .setEmptyLambdaArgument()
                        .build(),
                    FunCall.builder(RBuilder::p)
                        .addArgument("classes", ClassNames.MB_0)
                        .setLambdaArgument(
                            plusString(
                                "Whenever you need to, be sure to use margin utilities to keep things nice and tidy."
                            )
                        ).build()
                ).build()
        }
        subSectionTitle("Dismissing")
        Markdown {
            //language=Markdown
            +"""
Use the builders under `${RBuilder::Alerts.name}.${Alerts::dismissible.name}` to create dismissible
alerts.
            """
        }
        liveExample {
            Alerts.dismissible.warning(
                fade = true,
                props = {
                    onClose = {
                        console.log("Close on Alert was clicked. Timestamp: ${currentTimeMillis()}")
                    }
                    onClosed = {
                        console.log("Alert was dismissed. Timestamp: ${currentTimeMillis()}")
                    }
                }
            ) {
                strong { +"Holy guacamole!" }; +" You should check in on some of those fields below."
            }
        }

        codeExample {
            +Imports.builder()
                .addImport("components.alert.Alerts")
                .build()
            +FunCall.builder(Alerts.dismissible::warning, putArgumentsOnSeparateLine = true)
                .nestedBy(RBuilder::Alerts)
                .nestedBy(AlertBuilder::dismissible)
                .addArgument("fade", true)
                .addArgument(
                    "props",
                    LambdaValue(
                        buildString {
                            append(
                                Assignment.builder(Alert.Dismissible.Props<*>::onClose)
                                    .value(
                                        LambdaValue(
                                            FunCall.builder(Console::log, FunCall.Style.INLINE)
                                                .nestedBy(::console)
                                                .addArgument(
                                                    "Close on Alert was clicked. Timestamp: " +
                                                        "\${currentTimeMillis()}"
                                                )
                                                .build()
                                        )
                                    )
                                    .build()
                            )

                            append(
                                Assignment.builder(Alert.Dismissible.Props<*>::onClosed)
                                    .value(
                                        LambdaValue(
                                            FunCall.builder(Console::log, FunCall.Style.INLINE)
                                                .nestedBy(::console)
                                                .addArgument(
                                                    "Alert was dismissed. Timestamp: \${currentTimeMillis()}"
                                                )
                                                .build()
                                        )
                                    )
                                    .build()
                            )
                        },
                        LambdaValue.Style.ARGUMENT_BLOCK
                    )
                )
                .setLambdaArgument(
                    FunCall.builder(RBuilder::strong, FunCall.Style.INLINE, appendSemicolon = true)
                        .setLambdaArgument(plusString("Holy guacamole!"))
                        .build(),
                    " ",
                    plusString(" You should check in on some of those fields below.")
                )
                .build()
        }
        h4("bd-content-title") { +"Close element" }
        Markdown {
            //language=Markdown
            +"""
You can build your own custom close element, by using `closingElement { }`.
        """
        }
        liveExample {
            Alerts.dismissible.info {
                +"You want some cookies?"
                hr { }
                closingElement {
                    Buttons.solid.success {
                        +"Sure!"
                    }
                }
            }
        }
        codeExample {
            +Imports.builder()
                .addImport("components.alert.Alerts")
                .addImport("components.alert.closingElement")
                .addImport("components.button.Buttons")
                .importClassNames()
                .build()
            +FunCall.builder(Alerts.dismissible::info)
                .nestedBy(RBuilder::Alerts)
                .nestedBy(AlertBuilder::dismissible)
                .setLambdaArgument(
                    plusString("You want some cookies"),
                    "\n",
                    FunCall.builder(RBuilder::hr, FunCall.Style.NEW_INLINE)
                        .setEmptyLambdaArgument()
                        .build(),
                    FunCall.builder("closingElement")
                        .setLambdaArgument(
                            FunCall.builder(solidSuccessFun)
                                .nestedBy(RBuilder::Buttons)
                                .nestedBy(ButtonBuilder::solid)
                                .setLambdaArgument(plusString("Sure!"))
                                .build()
                        )
                        .build()
                )
                .build()
        }
        h4("bd-content-title") { +"State hook" }
        p {
            +"The callbacks can also be used for something like this:"
        }
        liveExample {
            child(
                functionalComponent {
                    var show by useState(false)

                    if (show) {
                        Alerts.dismissible.danger(
                            props = {
                                onClosed = { show = false }
                            }
                        ) {
                            +"You picked the wrong house, fool!"
                            hr { }
                            closingElement {
                                attrs {
                                    onClickFunction = {
                                        console.log("Phew. Good, that this worked out.")
                                    }
                                }
                                Buttons.solid.info {
                                    +"Ey, ey ey ey, Big Smoke, it's me, Carl, chill, chill!"
                                }
                            }
                        }
                    } else {
                        Buttons.outline.danger {
                            attrs {
                                onClickFunction = { show = true }
                            }
                            +"Open door & go in"
                        }
                    }
                }
            )
        }
        codeExample {
            +Imports.builder()
                .addImport("components.alert.Alerts")
                .addImport("components.alert.closingElement")
                .addImport("components.button.Buttons")
                .build()
            +FunCall.builder("child")
                .addArgument(
                    FunCall.builder(Generic("functionalComponent", "RProps"))
                        .setLambdaArgument(
                            Assignment.builder("show")
                                .varType()
                                .value(
                                    Assignment.FunCallDelegate(
                                        FunCall.builder("useState")
                                            .addArgument(false)
                                    )
                                )
                                .build(),
                            "\n\n",
                            If.builder("show")
                                .setContent(
                                    FunCall.builder(Alerts.dismissible::danger)
                                        .nestedBy(RBuilder::Alerts)
                                        .nestedBy(AlertBuilder::dismissible)
                                        .setLambdaArgument(
                                            FunCall.builder(RElementBuilder<RProps>::attrs)
                                                .setLambdaArgument(
                                                    Assignment.builder(Alert.Dismissible.Props<*>::onClosed)
                                                        .value(
                                                            LambdaValue(
                                                                Assignment.builder("show")
                                                                    .value(false)
                                                                    .build(),
                                                                LambdaValue.Style.INLINE
                                                            )
                                                        )
                                                        .build()
                                                )
                                                .build(),
                                            plusString("You picked the wrong house, fool!"),
                                            "\n",
                                            FunCall.builder(RBuilder::hr, FunCall.Style.NEW_INLINE)
                                                .setEmptyLambdaArgument()
                                                .build(),
                                            FunCall.builder("closingElement")
                                                .setLambdaArgument(
                                                    FunCall.builder(RElementBuilder<RProps>::attrs)
                                                        .setLambdaArgument(
                                                            "// The onClick event on the closing element " +
                                                                "can still be set",
                                                            "\n",
                                                            Assignment.builder(DomTag::onClickFunction)
                                                                .value(
                                                                    LambdaValue(
                                                                        FunCall.builder(
                                                                            Console::log,
                                                                            FunCall.Style.INLINE
                                                                        )
                                                                            .nestedBy(::console)
                                                                            .addArgument(
                                                                                "Phew. Good, that this " +
                                                                                    "worked out."
                                                                            )
                                                                            .build()
                                                                    )
                                                                )
                                                                .build()
                                                        )
                                                        .build(),
                                                    FunCall.builder(solidInfoFun)
                                                        .nestedBy(RBuilder::Buttons)
                                                        .nestedBy(ButtonBuilder::solid)
                                                        .setLambdaArgument(
                                                            plusString(
                                                                "Ey, ey ey ey, Big Smoke, it's me, Carl, chill, chill!"
                                                            )
                                                        )
                                                        .build()
                                                )
                                                .build()
                                        )
                                        .build()
                                )
                                .setElseContent(
                                    FunCall.builder(outlineDangerFun)
                                        .nestedBy(RBuilder::Buttons)
                                        .nestedBy(ButtonBuilder::outline)
                                        .setLambdaArgument(
                                            FunCall.builder(RElementBuilder<RProps>::attrs)
                                                .setLambdaArgument(
                                                    Assignment.builder(DomTag::onClickFunction)
                                                        .value(
                                                            LambdaValue(
                                                                Assignment.builder("show")
                                                                    .value(true)
                                                                    .build(),
                                                                LambdaValue.Style.INLINE
                                                            )
                                                        )
                                                        .build()
                                                )
                                                .build(),
                                            plusString("Open door & go in")
                                        )
                                        .build()
                                )
                                .build()
                        )
                )
                .build()
        }
    }
}
