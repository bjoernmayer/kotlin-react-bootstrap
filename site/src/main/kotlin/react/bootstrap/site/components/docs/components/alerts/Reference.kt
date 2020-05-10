package react.bootstrap.site.components.docs.components.alerts

import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.H3
import kotlinx.html.H4
import kotlinx.html.H5
import kotlinx.html.H6
import react.RBuilder
import react.RElementBuilder
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.alert
import react.bootstrap.components.alert.closingElement
import react.bootstrap.components.alert.dismissibleAlert
import react.bootstrap.components.alert.h1
import react.bootstrap.components.alert.h2
import react.bootstrap.components.alert.h3
import react.bootstrap.components.alert.h4
import react.bootstrap.components.alert.h5
import react.bootstrap.components.alert.h6
import react.bootstrap.components.alert.heading
import react.bootstrap.components.alert.link
import react.bootstrap.content.typography.Headings
import react.bootstrap.lib.ClassNames
import react.bootstrap.lib.WithOnClick
import react.bootstrap.site.components.docs.FunReference
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.external.Markdown
import react.dom.p

internal class Reference : SectionComponent() {
    override val title: String = "Reference"

    override fun RBuilder.render() {
        subSectionTitle(alertName, section)
        p {
            +"Adds an alert component."
        }
        codeExample {
            +FunReference(
                RBuilder::alert,
                setOf(RBuilder::class.simpleName!!),
                setOf(
                    FunReference.Argument("variant", Alert.Variants::class),
                    FunReference.Argument("classes", String::class, true, "null"),
                    FunReference.Argument("block", "RHandler<${Alert.Props::class.simpleName}>")
                ),
                "ReactElement"
            ).print(false)
        }
        subSectionTitle(dismissibleAlertName, section)
        p {
            +"Adds an dismissible alert component."
        }

        codeExample {
            +FunReference(
                RBuilder::dismissibleAlert,
                setOf(RBuilder::class.simpleName!!),
                setOf(
                    FunReference.Argument("variant", Alert.Variants::class),
                    FunReference.Argument("fade", Boolean::class, true, "null"),
                    FunReference.Argument("classes", String::class, true, "null"),
                    FunReference.Argument("block", "RHandler<${Alert.DismissibleProps::class.simpleName}>")
                ),
                "ReactElement"
            ).print(false)
        }
        subSectionTitle(linkName, section)
        Markdown {
            //language=Markdown
            +"""
Adds `${ClassNames.ALERT_LINK.kt}` to the outer most `ReactElement` resulting from `block`.
            """
        }
        codeExample {
            +FunReference(
                RElementBuilder<Alert.Props>::link,
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.simpleName}>"),
                setOf(
                    FunReference.Argument("block", "ElementProvider")
                ),
                "ReactElement"
            ).print(true)
        }
        subSectionTitle(headingName, section)
        Markdown {
            //language=Markdown
            +"""
Adds `${ClassNames.ALERT_HEADING.kt}` to the outer most `ReactElement` resulting from `block`.
            """
        }
        codeExample {
            +FunReference(
                RElementBuilder<Alert.Props>::heading,
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.simpleName}>"),
                setOf(

                    FunReference.Argument("headings", Headings::class),
                    FunReference.Argument("block", "ElementProvider")
                ),
                "ReactElement"
            ).print(true)
        }
        subSectionTitle("h1", section)
        Markdown {
            //language=Markdown
            +"""
Custom `h1` which behaves the same but adds `${ClassNames.ALERT_HEADING.kt}` to `classes`.
            """
        }
        codeExample {
            +FunReference(
                RElementBuilder<Alert.Props>::h1,
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.simpleName}>"),
                setOf(
                    FunReference.Argument("classes", String::class, true, "null"),
                    FunReference.Argument("block", "RDOMHandler<${H1::class.simpleName}>")
                ),
                "ReactElement"
            ).print(true)
        }
        subSectionTitle("h2", section)
        Markdown {
            //language=Markdown
            +"""
Custom `h2` which behaves the same but adds `${ClassNames.ALERT_HEADING.kt}` to `classes`.
            """
        }
        codeExample {
            +FunReference(
                RElementBuilder<Alert.Props>::h2,
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.simpleName}>"),
                setOf(
                    FunReference.Argument("classes", String::class, true, "null"),
                    FunReference.Argument("block", "RDOMHandler<${H2::class.simpleName}>")
                ),
                "ReactElement"
            ).print(true)
        }
        subSectionTitle("h3", section)
        Markdown {
            //language=Markdown
            +"""
Custom `h3` which behaves the same but adds `${ClassNames.ALERT_HEADING.kt}` to `classes`.
            """
        }
        codeExample {
            +FunReference(
                RElementBuilder<Alert.Props>::h3,
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.simpleName}>"),
                setOf(
                    FunReference.Argument("classes", String::class, true, "null"),
                    FunReference.Argument("block", "RDOMHandler<${H3::class.simpleName}>")
                ),
                "ReactElement"
            ).print(true)
        }
        subSectionTitle("h4", section)
        Markdown {
            //language=Markdown
            +"""
Custom `h4` which behaves the same but adds `${ClassNames.ALERT_HEADING.kt}` to `classes`.
            """
        }
        codeExample {
            +FunReference(
                RElementBuilder<Alert.Props>::h4,
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.simpleName}>"),
                setOf(
                    FunReference.Argument("classes", String::class, true, "null"),
                    FunReference.Argument("block", "RDOMHandler<${H4::class.simpleName}>")
                ),
                "ReactElement"
            ).print(true)
        }
        subSectionTitle("h5", section)
        Markdown {
            //language=Markdown
            +"""
Custom `h5` which behaves the same but adds `${ClassNames.ALERT_HEADING.kt}` to `classes`.
            """
        }
        codeExample {
            +FunReference(
                RElementBuilder<Alert.Props>::h5,
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.simpleName}>"),
                setOf(
                    FunReference.Argument("classes", String::class, true, "null"),
                    FunReference.Argument("block", "RDOMHandler<${H5::class.simpleName}>")
                ),
                "ReactElement"
            ).print(true)
        }
        subSectionTitle("h6", section)
        Markdown {
            //language=Markdown
            +"""
Custom `h6` which behaves the same but adds `${ClassNames.ALERT_HEADING.kt}` to `classes`.
            """
        }
        codeExample {
            +FunReference(
                RElementBuilder<Alert.Props>::h6,
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.simpleName}>"),
                setOf(
                    FunReference.Argument("classes", String::class, true, "null"),
                    FunReference.Argument("block", "RDOMHandler<${H6::class.simpleName}>")
                ),
                "ReactElement"
            ).print(true)
        }
        subSectionTitle(closingElementName, section)
        p {
            +"Wrapper for a custom alert closing element."
        }
        alert(Alert.Variants.INFO) {
            Markdown {
                //language=Markdown
                +"""
Be aware the `${buildNestedName(WithOnClick::onClick.name, WithOnClick::class)}` of the outer most element gets
overwritten.
                """
            }
        }
        codeExample {
            +FunReference(
                RElementBuilder<Alert.DismissibleProps>::closingElement,
                setOf("${RElementBuilder::class.simpleName}<${Alert.DismissibleProps::class.simpleName}>"),
                setOf(
                    FunReference.Argument("block", "ElementProvider")
                ),
                "ReactElement"
            ).print(true)
        }
    }
}
