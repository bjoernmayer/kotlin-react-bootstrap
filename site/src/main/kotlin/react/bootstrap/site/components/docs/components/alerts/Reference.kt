package react.bootstrap.site.components.docs.components.alerts

import react.RBuilder
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.alert
import react.bootstrap.content.typography.Headings
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.WithOnClick
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeBox
import react.bootstrap.site.components.docs.formattedText
import react.bootstrap.site.components.docs.kt
import react.dom.p

internal class Reference : SectionComponent() {
    override val title: String = "Reference"

    override fun RBuilder.render() {
        subSectionTitle(alertName, section)
        p {
            +"Adds an alert component."
        }
        codeBox {
            +"""
                fun RBuilder.$alertName(
                    variant: ${Alert.Variants::class.nestedName},
                    classes: String? = null,
                    block: RHandler<$alertPropsName>
                ): ReactElement
            """.trimIndent()
        }
        subSectionTitle(dismissibleAlertName, section)
        p {
            +"Adds an dismissible alert component."
        }
        codeBox {
            +"""
                fun RBuilder.$dismissibleAlertName(
                    variant: ${Alert.Variants::class.nestedName},
                    fade: Boolean? = null,
                    classes: String? = null,
                    block: RHandler<${Alert.DismissibleProps::class.nestedName}>
                ): ReactElement
            """.trimIndent()
        }
        subSectionTitle(linkName, section)
        formattedText {
            "Adds <${ClassNames.ALERT_LINK.kt}|code> to the outer most <ReactElement|code> resulting from <block|code>."
        }
        codeBox {
            +"fun RElementBuilder<$alertPropsName>.link(block: ElementProvider): ReactElement"
        }
        subSectionTitle(headingName, section)
        formattedText {
            "Adds <${ClassNames.ALERT_HEADING.kt}|code> to the outer most <ReactElement|code> resulting from <block|code>."
        }
        codeBox {
            val funDef = "fun RElementBuilder<$alertPropsName>.heading(headings: ${Headings::class.simpleName}, " +
                "block: ElementProvider): ReactElement"
            +funDef
        }
        subSectionTitle("h1", section)
        formattedText {
            "Custom <h1|code> which behaves the same but adds <${ClassNames.ALERT_HEADING.kt}|code> to <classes|code>."
        }
        codeBox {
            val funDef = "fun RElementBuilder<$alertPropsName>.h1(classes: String? = null, block: RDOMBuilder<H1>.()" +
                " -> Unit): ReactElement"
            +funDef
        }
        subSectionTitle("h2", section)
        formattedText {
            "Custom <h2|code> which behaves the same but adds <${ClassNames.ALERT_HEADING.kt}|code> to <classes|code>."
        }
        codeBox {
            val funDef = "fun RElementBuilder<$alertPropsName>.h2(classes: String? = null, block: RDOMBuilder<H2>.()" +
                " -> Unit): ReactElement"
            +funDef
        }
        subSectionTitle("h3", section)
        formattedText {
            "Custom <h3|code> which behaves the same but adds <${ClassNames.ALERT_HEADING.kt}|code> to <classes|code>."
        }
        codeBox {
            val funDef = "fun RElementBuilder<$alertPropsName>.h3(classes: String? = null, block: RDOMBuilder<H3>.()" +
                " -> Unit): ReactElement"
            +funDef
        }
        subSectionTitle("h4", section)
        formattedText {
            "Custom <h4|code> which behaves the same but adds <${ClassNames.ALERT_HEADING.kt}|code> to <classes|code>."
        }
        codeBox {
            val funDef = "fun RElementBuilder<$alertPropsName>.h4(classes: String? = null, block: RDOMBuilder<H4>.()" +
                " -> Unit): ReactElement"
            +funDef
        }
        subSectionTitle("h5", section)
        formattedText {
            "Custom <h5|code> which behaves the same but adds <${ClassNames.ALERT_HEADING.kt}|code> to <classes|code>."
        }
        codeBox {
            val funDef = "fun RElementBuilder<$alertPropsName>.h5(classes: String? = null, block: RDOMBuilder<H5>.()" +
                " -> Unit): ReactElement"
            +funDef
        }
        subSectionTitle("h6", section)
        formattedText {
            "Custom <h6|code> which behaves the same but adds <${ClassNames.ALERT_HEADING.kt}|code> to <classes|code>."
        }
        codeBox {
            val funDef = "fun RElementBuilder<$alertPropsName>.h6(classes: String? = null, block: RDOMBuilder<H6>.()" +
                " -> Unit): ReactElement"
            +funDef
        }
        subSectionTitle(closingElementName, section)
        p {
            +"Wrapper for a custom alert closing element."
        }
        alert(Alert.Variants.INFO) {
            formattedText {
                "Be aware that the <${WithOnClick::class.simpleName}.${WithOnClick::onClick.name}|code> of the outer" +
                    "most element gets overwritten."
            }

        }
        codeBox {
            val funDef = "fun RElementBuilder<${Alert.DismissibleProps::class.nestedName}>.closingElement(block: Ele" +
                "mentProvider): ReactElement"
            +funDef
        }
    }
}
