@file:Suppress("NAME_SHADOWING")

package react.bootstrap.site.components.docs.components.alerts

import kotlinx.html.currentTimeMillis
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RElementBuilder
import react.RProps
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.alert
import react.bootstrap.components.alert.closingElement
import react.bootstrap.components.alert.dismissibleAlert
import react.bootstrap.components.alert.h4
import react.bootstrap.components.alert.link
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.example
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.child
import react.dom.button
import react.dom.h4
import react.dom.hr
import react.dom.p
import react.dom.strong
import react.functionalComponent
import react.useState

internal class Examples : SectionComponent() {
    override val title: String = "Examples"

    override fun RBuilder.render() {
        sectionTitle(section)
        formattedText {
            """
            Alerts are available for any length of text, as well as an optional dismiss button. For proper styling, use
            one of the eight <required|strong> variants (e.g., <${Alert.Variants.SUCCESS.kt}|code>).
        """.trimIndent()
        }
        example {
            Alert.Variants.values().iterator().forEach { variant ->
                alert(variant) {
                    +"A simple ${variant.name.toLowerCase()} alert-check it out!"
                }
            }
        }
        codeBox {
            ln { +"import react.bootstrap.components.alert.Alert" }
            ln { +"import react.bootstrap.components.alert.alert" }
            ln { }
            Alert.Variants.values().iterator().forEach { variant ->
                ktBlock(0, "${RBuilder::alert.name}(${variant.kt})") { il ->
                    ln(il) { +"+\"A simple ${variant.name.toLowerCase()} alert-check it out!\"" }
                }
            }
        }
        subSectionTitle("Link color", section)
        formattedText('%', '&') {
            """
            Use the %link|code&-function (only available inside %RElementBuilder<Alert>|code& to quickly provide
            matching colored links within any alert.
        """.trimIndent()
        }
        example {
            Alert.Variants.values().iterator().forEach { variant ->
                alert(variant) {
                    +"A simple ${variant.name.toLowerCase()} alert with "
                    link("#") { +"an example link" }; +". Give it a click if you like."
                }
            }
        }
        codeBox {
            ln { +"import react.bootstrap.components.alert.Alert" }
            ln { +"import react.bootstrap.components.alert.link" }
            ln { +"import react.bootstrap.components.alert.alert" }
            ln { }
            Alert.Variants.values().iterator().forEach { variant ->
                ktBlock(0, "${RBuilder::alert.name}(${variant.kt})") { il ->
                    ln(il) { +"+\"A simple ${variant.name.toLowerCase()} alert with \"" }
                    ln(il) {
                        +"${RElementBuilder<Alert.Props>::link.name}(\"#\") { +\"an example link\" }; +\". Give it a"
                        +"click if you like.\""
                    }
                }
            }
        }
        subSectionTitle("Additional content", section)
        p {
            +"""
            Alerts can also contain additional HTML elements like headings, paragraphs and dividers.
        """.trimIndent()
        }
        example {
            alert(Alert.Variants.SUCCESS) {
                h4 { +"Well done!" }
                p {
                    +"""
                    Aww yeah, you successfully read this important alert message. This example text is going to run a
                    bit longer so that you can see how spacing within an alert works with this kind of content.
                """.trimIndent()
                }
                hr { }
                p("${ClassNames.MB_0}") {
                    +"Whenever you need to, be sure to use margin utilities to keep things nice and tidy."
                }
            }
        }
        codeBox {
            ln { +"import react.bootstrap.components.alert.Alert" }
            ln { +"import react.bootstrap.components.alert.alert" }
            ln { +"import react.bootstrap.components.alert.h4" }
            ln { +"import react.bootstrap.lib.ClassNames" }
            ln { }
            ktBlock(0, "alert(${Alert.Variants.SUCCESS.kt})") { il ->
                ln(il) { +"h4 { +\"Well done!\" }" }
                ktBlock(il, "p") { il ->
                    ln(il) { +"+\"\"\"" }
                    ln(il + 1) {
                        +"Aww yeah, you successfully read this important alert message. This example text is going to"
                        +" run a"
                    }
                    ln(il + 1) {
                        +"bit longer so that you can see how spacing within an alert works with this kind of content."
                    }
                    ln(il) { +"\"\"\".trimIndent()" }
                }
                ln(il) { +"hr { }" }
                ktBlock(il, "p(\"\${${ClassNames.MB_0.kt}})\"") { il ->
                    ln(il) {
                        +"+\"Whenever you need to, be sure to use margin utilities to keep things nice and tidy.\""
                    }
                }
            }
        }
        subSectionTitle("Dismissing", section)
        formattedText {
            """
                Use <${RBuilder::dismissibleAlert.name} { }|code> to create a dismissible alert.
            """.trimIndent()
        }
        example {
            dismissibleAlert(variant = Alert.Variants.WARNING, fade = true) {
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
        codeBox {
            ln { +"import react.bootstrap.components.alert.Alert" }
            ln { +"import react.bootstrap.components.alert.dismissibleAlert" }
            ln { }
            ktBlock(
                0,
                "${RBuilder::dismissibleAlert.name}(variant = ${Alert.Variants.WARNING.kt}, fade = true)"
            ) { il ->
                ktBlock(il, "attrs") { il ->
                    ktBlock(il, "${Alert.Props::dismissible.name}?.apply") { il ->
                        ktBlock(il, Alert.DismissibleProps::onClose.name) { il ->
                            ln(il) {
                                +"console.log(\"Close on Alert was clicked. Timestamp: \${currentTimeMillis()}\")"
                            }
                        }
                        ktBlock(il, Alert.DismissibleProps::onClosed.name) { il ->
                            ln(il) {
                                +"console.log(\"Close on Alert was clicked. Timestamp: \${currentTimeMillis()}\")"
                            }
                        }
                    }
                }
                ln(il) { +"strong { +\"Holy guacamole!\" }; +\" You should check in on some of those fields below.\"" }
            }
        }
        contentTitle(RBuilder::h4, "Close element")
        formattedText {
            """
                You can build your own custom close element, by using
                <${RElementBuilder<Alert.Props>::closingElement.name} { }|code>.
            """.trimIndent()
        }
        example {
            dismissibleAlert(variant = Alert.Variants.INFO) {
                +"You want some cookies?"
                hr { }
                closingElement {
                    button(classes = "${ClassNames.BTN} ${ClassNames.BTN_SUCCESS}") {
                        +"Sure!"
                    }
                }
            }
        }
        codeBox {
            ln { +"import react.bootstrap.components.alert.Alert" }
            ln { +"import react.bootstrap.components.alert.closingElement" }
            ln { +"import react.bootstrap.components.alert.dismissibleAlert" }
            ln { +"import react.bootstrap.lib.ClassNames" }
            ln { }
            ktBlock(
                0,
                "${RBuilder::dismissibleAlert.name}(variant = ${Alert.Variants.INFO.kt})"
            ) { il ->
                ln(il) { +" +\"You want some cookies?\"" }
                ln(il) { +"hr { }" }
                ktBlock(il, RElementBuilder<Alert.Props>::closingElement.name) { il ->
                    ktBlock(il, "button(classes = \"\${ClassNames.BTN} \${ClassNames.BTN_SUCCESS}\")") { il ->
                        ln(il) { +"+\"Sure!\"" }
                    }
                }
            }
        }
        contentTitle(RBuilder::h4, "State hook")
        p {
            +"The callbacks can also be used for something like this:"
        }
        example {
            child(dismissibleAlert)
        }
        codeBox {
            ln { +"import react.bootstrap.components.alert.Alert" }
            ln { +"import react.bootstrap.components.alert.closingElement" }
            ln { +"import react.bootstrap.components.alert.dismissibleAlert" }
            ln { +"import react.bootstrap.lib.ClassNames" }
            ln { }
            ktBlock(0, "private val dismissibleAlert = functionalComponent<RProps>") { il ->
                ln(il) { +"val (show, setShow) = useState(false)" }
                ln { }
                ktBlock(il, "if (show)") { il ->
                    ktBlock(il, "${RBuilder::dismissibleAlert.name}(variant = ${Alert.Variants.DANGER.kt})") { il ->
                        ktBlock(il, "attrs") { il ->
                            ktBlock(il, "${Alert.Props::dismissible.name}?.apply") { il ->
                                ktBlock(il, Alert.DismissibleProps::onClosed.name) { il ->
                                    ln(il) { +"setShow(false)" }
                                }
                            }
                        }
                        ln(il) { +"+\"You picked the wrong house, fool!\"" }
                        ln(il) { +"hr { }" }
                        ktBlock(il, RElementBuilder<Alert.Props>::closingElement.name) { il ->
                            ktBlock(il, "button(classes = \"\${ClassNames.BTN} \${ClassNames.BTN_INFO}\") ") { il ->
                                ln(il) { +"+\"Ey, ey ey ey, Big Smoke, it's me, Carl, chill, chill!\"" }
                            }
                        }
                    }
                }
                ktBlock(il, "else") { il ->
                    ktBlock(il, "button(classes = \"\${ClassNames.BTN} \${ClassNames.BTN_OUTLINE_DANGER}\")") { il ->
                        ktBlock(il, "attrs") { il ->
                            ln(il) { +"onClickFunction = { setShow(true) }" }
                        }
                        ln(il) { +"+\"Open door & go in\"" }
                    }
                }
            }
        }
    }

    private val dismissibleAlert = functionalComponent<RProps> {
        val (show, setShow) = useState(false)

        // Todo use button component
        if (show) {
            dismissibleAlert(variant = Alert.Variants.DANGER) {
                attrs {
                    dismissible?.apply {
                        onClosed = {
                            setShow(false)
                        }
                    }
                }
                +"You picked the wrong house, fool!"
                hr { }
                closingElement {
                    button(classes = "${ClassNames.BTN} ${ClassNames.BTN_INFO}") {
                        +"Ey, ey ey ey, Big Smoke, it's me, Carl, chill, chill!"
                    }
                }
            }
        } else {
            button(classes = "${ClassNames.BTN} ${ClassNames.BTN_OUTLINE_DANGER}") {
                attrs {
                    onClickFunction = { setShow(true) }
                }
                +"Open door & go in"
            }
        }
    }
}
