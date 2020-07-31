@file:Suppress("DuplicatedCode")

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
import react.bootstrap.components.alert.Alerts
import react.bootstrap.components.alert.closingElement
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
import react.bootstrap.site.components.docs.FunReference
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.external.Markdown
import react.dom.p

internal class Reference : SectionComponent() {
    override val title: String = "Reference"

    override fun RBuilder.render() {
        sectionTitle(section)
        mapOf(
            Alert.Variants.DANGER to Alerts::danger,
            Alert.Variants.DARK to Alerts::dark,
            Alert.Variants.INFO to Alerts::info,
            Alert.Variants.LIGHT to Alerts::light,
            Alert.Variants.PRIMARY to Alerts::primary,
            Alert.Variants.SECONDARY to Alerts::secondary,
            Alert.Variants.SUCCESS to Alerts::success,
            Alert.Variants.WARNING to Alerts::warning
        ).forEach { (variant, function) ->
            val variantName = variant::class.simpleName!!.toLowerCase().capitalize()
            subSectionTitle(function.name, section)
            p {
                +"Adds an alert component with the $variantName context."
            }
            codeExample {
                +FunReference(
                    function,
                    alertBuilderParents.toSet(),
                    setOf(
                        FunReference.Argument("classes", String::class, true, FunReference.Argument.NULL),
                        FunReference.Argument("block", "RHandler<${Alert.Props::class.nestedName}>")
                    ),
                    "ReactElement"
                ).print(false)
                ln { }
                +FunReference(
                    function,
                    dismissibleAlertBuilderParents.toSet(),
                    setOf(
                        FunReference.Argument("fade", Boolean::class, true, FunReference.Argument.NULL),
                        FunReference.Argument("classes", String::class, true, FunReference.Argument.NULL),
                        FunReference.Argument("block", "RHandler<${Alert.DismissibleProps::class.nestedName}>")
                    ),
                    "ReactElement"
                ).print(false)
            }
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
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.nestedName}>"),
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
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.nestedName}>"),
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
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.nestedName}>"),
                setOf(
                    FunReference.Argument("classes", String::class, true, FunReference.Argument.NULL),
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
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.nestedName}>"),
                setOf(
                    FunReference.Argument("classes", String::class, true, FunReference.Argument.NULL),
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
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.nestedName}>"),
                setOf(
                    FunReference.Argument("classes", String::class, true, FunReference.Argument.NULL),
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
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.nestedName}>"),
                setOf(
                    FunReference.Argument("classes", String::class, true, FunReference.Argument.NULL),
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
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.nestedName}>"),
                setOf(
                    FunReference.Argument("classes", String::class, true, FunReference.Argument.NULL),
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
                setOf("${RElementBuilder::class.simpleName}<${Alert.Props::class.nestedName}>"),
                setOf(
                    FunReference.Argument("classes", String::class, true, FunReference.Argument.NULL),
                    FunReference.Argument("block", "RDOMHandler<${H6::class.simpleName}>")
                ),
                "ReactElement"
            ).print(true)
        }
        subSectionTitle(closingElementName, section)
        p {
            +"Wrapper for a custom alert closing element."
        }
        codeExample {
            +FunReference(
                RElementBuilder<Alert.DismissibleProps>::closingElement,
                setOf("${RElementBuilder::class.simpleName}<${Alert.DismissibleProps::class.nestedName}>"),
                setOf(
                    FunReference.Argument("block", "ElementProvider")
                ),
                "ReactElement"
            ).print(true)
        }
    }
}
