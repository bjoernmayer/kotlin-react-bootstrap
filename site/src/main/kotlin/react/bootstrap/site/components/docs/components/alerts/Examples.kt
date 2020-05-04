@file:Suppress("NAME_SHADOWING")

package react.bootstrap.site.components.docs.components.alerts

import react.RBuilder
import react.RElementBuilder
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.alert
import react.bootstrap.components.alert.h4
import react.bootstrap.components.alert.link
import react.bootstrap.lib.ClassNames
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.components.docs.fixings.exampleRow
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.layout.grid.ktBlock
import react.bootstrap.site.components.docs.ln
import react.dom.h3
import react.dom.hr
import react.dom.p
import react.dom.strong

internal fun RBuilder.examples() {
    contentTitle("Example")
    formattedText {
        """
            Alerts are available for any length of text, as well as an optional dismiss button. For proper styling, use
            one of the eight <required|strong> variants (e.g., <${Alert.Variants.SUCCESS.kt}|code>).
        """.trimIndent()
    }
    exampleRow {
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
    contentTitle(RBuilder::h3, "Link color")
    formattedText('%', '&') {
        """
            Use the %link|code&-function (only available inside %RElementBuilder<Alert>|code& to quickly provide
            matching colored links within any alert.
        """.trimIndent()
    }
    exampleRow {
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
                    +"${RElementBuilder<Alert.Props>::link.name}(\"#\") { +\"an example link\" }; +\". Give it a click"
                    +"if you like.\""
                }
            }
        }
    }
    contentTitle(RBuilder::h3, "Additional content")
    p {
        +"""
            Alerts can also contain additional HTML elements like headings, paragraphs and dividers.
        """.trimIndent()
    }
    exampleRow {
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
                    +"Aww yeah, you successfully read this important alert message. This example text is going to run a"
                }
                ln(il + 1) {
                    +"bit longer so that you can see how spacing within an alert works with this kind of content."
                }
                ln(il) { +"\"\"\".trimIndent()" }
            }
            ln(il) { +"hr { }" }
            ktBlock(il, "p(\"\${${ClassNames.MB_0.kt}})\"") { il ->
                ln(il) { +"+\"Whenever you need to, be sure to use margin utilities to keep things nice and tidy.\"" }
            }
        }
    }
    contentTitle(RBuilder::h3, "Dismissing")
    formattedText {
        """
            Set the <alert(dismissible)|code>-argument to dismiss any alert inline.
        """.trimIndent()
    }
    exampleRow {
        alert(variant = Alert.Variants.WARNING, dismissible = Alert.Transition.FADE_OUT) {
            strong { +"Holy guacamole!" }; +" You should check in on some of those fields below."
        }
    }
}
