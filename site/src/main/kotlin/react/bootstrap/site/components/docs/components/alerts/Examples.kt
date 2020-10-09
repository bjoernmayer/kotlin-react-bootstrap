@file:Suppress("NAME_SHADOWING", "NestedLambdaShadowedImplicitParameter")

package react.bootstrap.site.components.docs.components.alerts

import kotlinx.html.currentTimeMillis
import react.RBuilder
import react.RElementBuilder
import react.RProps
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.Alerts
import react.bootstrap.components.alert.closingElement
import react.bootstrap.components.alert.link
import react.bootstrap.components.button.Buttons
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.WithDomEvents
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.components.buttons.outlineButtonBuilderParents
import react.bootstrap.site.components.docs.components.buttons.outlineDangerFun
import react.bootstrap.site.components.docs.components.buttons.solidButtonBuilderParents
import react.bootstrap.site.components.docs.components.buttons.solidInfoFun
import react.bootstrap.site.components.docs.components.buttons.solidSuccessFun
import react.bootstrap.site.components.docs.fixings.FunStyle
import react.bootstrap.site.components.docs.fixings.Quoted
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.liveExample
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.external.Markdown
import react.child
import react.dom.a
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
        sectionTitle(section)
        Markdown {
            //language=Markdown
            +"""
Alerts are available for any length of text, as well as an optional dismiss button. For proper styling, use one of the
eight __required__ variants (e.g., `${Alert.Variants.SUCCESS.kt}`).
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
            variants.forEach { (variant, function) ->
                child(
                    function.invoke(null) {
                        +"A simple ${variant.name.toLowerCase()} alert-check it out!"
                    }
                )
            }
        }
        codeExample {
            import("components.alert.Alerts")
            ln { }
            variants.forEach { (variant, function) ->
                ktFun(function, alertBuilderParents) {
                    ln("A simple ${variant.name.toLowerCase()} alert-check it out!")
                }
            }
        }
        subSectionTitle("Link color", section)
        Markdown {
            //language=Markdown
            +"""
Use the `$linkName`-function (only available inside `RElementBuilder<$alertPropsName>` to quickly provide matching
colored links within any alert.
            """
        }
        liveExample {
            variants.forEach { (variant, function) ->
                child(
                    function.invoke(null) {
                        +"A simple ${variant.name.toLowerCase()} alert with "
                        link { a(href = "#") { +"an example link" } }; +". Give it a click if you like."
                    }
                )
            }
        }
        codeExample {
            import("components.alert.Alerts")
            import("components.alert.$linkName")
            ln { }
            variants.forEach { (variant, function) ->
                ktFun(function, alertBuilderParents) {
                    ln("A simple ${variant.name.toLowerCase()} alert with ")
                    ktFun(RElementBuilder<Alert.Props>::link, style = FunStyle.INLINE) {
                        ktFun(
                            RBuilder::a,
                            style = FunStyle.INLINE,
                            args = mapOf("href" to Quoted("#"))
                        ) {
                            string("an example link")
                        }
                        +"; +\". Give it a click if you like.\""
                    }
                }
            }
        }
        subSectionTitle("Additional content", section)
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
                p("${ClassNames.MB_0}") {
                    +"Whenever you need to, be sure to use margin utilities to keep things nice and tidy."
                }
            }
        }
        codeExample {
            import("components.alert.Alerts")
            import("components.alert.h4")
            importClassNames()
            ln { }
            ktFun(Alerts::success, alertBuilderParents) {
                ktFun(RBuilder::h4, style = FunStyle.INLINE_BLOCK) {
                    string("Well done!")
                }
                ktFun(RBuilder::p) {
                    multiline(
                        "Aww yeah, you successfully read this important alert message. This example text is going to " +
                            "run a bit longer ",
                        "so that you can see how spacing within an alert works with this kind of content."
                    )
                }
                ktFun(RBuilder::hr, style = FunStyle.INLINE_BLOCK) { }
                ktFun(RBuilder::p, args = mapOf(null to Quoted("\${${ClassNames.MB_0.kt}}"))) {
                    ln("Whenever you need to, be sure to use margin utilities to keep things nice and tidy.")
                }
            }
        }
        subSectionTitle("Dismissing", section)
        Markdown {
            //language=Markdown
            +"""
Use the builders under `${buildNestedName(Alerts::dismissible.name, RBuilder::Alerts.name)}` to create dismissible
alerts.
            """
        }
        liveExample {
            Alerts.dismissible.warning(fade = true) {
                attrs {
                    dismissible?.apply {
                        onClose = {
                            console.log("Close on Alert was clicked. Timestamp: ${currentTimeMillis()}")
                        }
                        onClosed = {
                            console.log("Alert was dismissed. Timestamp: ${currentTimeMillis()}")
                        }
                    }
                }
                strong { +"Holy guacamole!" }; +" You should check in on some of those fields below."
            }
        }
        codeExample {
            import("components.alert.Alerts")
            ln { }
            ktFun(Alerts.dismissible::warning, dismissibleAlertBuilderParents, args = mapOf("fade" to "true")) {
                ktFun(RElementBuilder<RProps>::attrs) {
                    ktFun(Any::apply, listOf("${Alert.Props::dismissible.name}?")) {
                        ktBlock("${Alert.Props.Dismissible::onClose.name} =") {
                            ktFun(
                                Console::log,
                                listOf("console"),
                                style = FunStyle.INLINE,
                                args = mapOf(
                                    null to Quoted(
                                        "Close on Alert was clicked. Timestamp: \${currentTimeMillis()}"
                                    )
                                )
                            )
                        }
                        ktBlock("${Alert.Props.Dismissible::onClosed.name} =") {
                            ktFun(
                                Console::log,
                                listOf("console"),
                                style = FunStyle.INLINE,
                                args = mapOf(
                                    null to Quoted(
                                        "Alert was dismissed. Timestamp: \${currentTimeMillis()}"
                                    )
                                )
                            )
                        }
                    }
                }
                ktFun(
                    RBuilder::strong,
                    style = FunStyle.INLINE
                ) {
                    string("Holy guacamole!")
                }
                +"; +\" You should check in on some of those fields below.\""
            }
        }
        contentTitle(RBuilder::h4, "Close element")
        Markdown {
            //language=Markdown
            +"""
You can build your own custom close element, by using `$closingElementName { }`.
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
            import("components.alert.Alerts")
            import("components.alert.$closingElementName")
            import("components.button.Buttons")
            importClassNames()
            ln { }
            ktFun(Alerts.dismissible::info, dismissibleAlertBuilderParents) {
                ln("You want some cookies")
                ktFun(RBuilder::hr, style = FunStyle.INLINE_BLOCK) { }
                ktFun(RElementBuilder<Alert.DismissibleProps>::closingElement) {
                    ktFun(solidSuccessFun, parents = solidButtonBuilderParents) {
                        ln("Sure!")
                    }
                }
            }
        }
        contentTitle(RBuilder::h4, "State hook")
        p {
            +"The callbacks can also be used for something like this:"
        }
        liveExample {
            child(dismissibleAlert)
        }
        codeExample {
            import("components.alert.Alerts")
            import("components.alert.$closingElementName")
            import("components.button.Buttons")
            ln { }
            ktBlock("private val dismissibleAlert = functionalComponent<RProps>") {
                ln { +"var show by useState(false)" }
                ln { }
                ktBlock("if (show)") {
                    ktFun(Alerts.dismissible::danger, dismissibleAlertBuilderParents) {
                        ktFun(RElementBuilder<RProps>::attrs) {
                            ktFun(Any::apply, listOf("${Alert.Props::dismissible.name}?")) {
                                ln { +"${Alert.Props.Dismissible::onClosed.name} = { show = false }" }
                            }
                        }
                        ln("You picked the wrong house, fool!")
                        ktFun(RBuilder::hr, style = FunStyle.INLINE_BLOCK) { }
                        ktFun(RElementBuilder<Alert.DismissibleProps>::closingElement) {
                            ktFun(solidInfoFun, parents = solidButtonBuilderParents) {
                                ktFun(RElementBuilder<RProps>::attrs) {
                                    ln { +"// The onClick event on the closing element can still be set" }
                                    ktBlock("${Alert.Props::onClick.name} =") {
                                        ktFun(
                                            Console::log,
                                            listOf("console"),
                                            style = FunStyle.INLINE,
                                            args = mapOf(
                                                null to Quoted(
                                                    "Phew. Good, that this worked out."
                                                )
                                            )
                                        )
                                    }
                                }
                                ln("Ey, ey ey ey, Big Smoke, it's me, Carl, chill, chill!")
                            }
                        }
                    }
                }
                ktBlock("else") {
                    ktFun(outlineDangerFun, parents = outlineButtonBuilderParents) {
                        ktFun(RElementBuilder<RProps>::attrs) {
                            ln { +"${WithDomEvents::onClick.name} = { show = true }" }
                        }
                        ln("Open door & go in")
                    }
                }
            }
        }
    }

    private val dismissibleAlert = functionalComponent<RProps> {
        var show by useState(false)

        if (show) {
            Alerts.dismissible.danger {
                attrs {
                    dismissible?.apply {
                        onClosed = { show = false }
                    }
                }
                +"You picked the wrong house, fool!"
                hr { }
                closingElement {
                    Buttons.solid.info {
                        attrs {
                            // a onClick event on the closing element can still be set
                            onClick = {
                                console.log("Phew. Good, that this worked out.")
                            }
                        }
                        +"Ey, ey ey ey, Big Smoke, it's me, Carl, chill, chill!"
                    }
                }
            }
        } else {
            Buttons.outline.danger {
                attrs {
                    onClick = { show = true }
                }
                +"Open door & go in"
            }
        }
    }
}
