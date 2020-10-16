@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.components.alerts

import react.RBuilder
import react.RElementBuilder
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.AlertBuilder
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
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.kt
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
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
                +FunSpec.builder(function)
                    .nestedBy(RBuilder::Alerts)
                    .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                    .addParameter("block", Generic("RHandler", Alert.Props::class))
                    .returns("ReactElement")
                    .build()
                ln { }
                +FunSpec.builder(function)
                    .nestedBy(RBuilder::Alerts)
                    .nestedBy(AlertBuilder::dismissible)
                    .addParameter("fade", Boolean::class, true, FunSpec.Parameter.NULL)
                    .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                    .addParameter("block", Generic("RHandler", Alert.DismissibleProps::class))
                    .returns("ReactElement")
                    .build()
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
            +FunSpec.builder(RElementBuilder<Alert.Props>::link, false)
                .nestedBy(Generic(RElementBuilder::class, Alert.Props::class))
                .addParameter("block", "ElementProvider")
                .returns("ReactElement")
                .build()
        }
        subSectionTitle(headingName, section)
        Markdown {
            //language=Markdown
            +"""
Adds `${ClassNames.ALERT_HEADING.kt}` to the outer most `ReactElement` resulting from `block`.
            """
        }
        codeExample {
            +FunSpec.builder(RElementBuilder<Alert.Props>::heading, false)
                .nestedBy(Generic(RElementBuilder::class, Alert.Props::class))
                .addParameter("headings", Headings::class)
                .addParameter("block", "ElementProvider")
                .returns("ReactElement")
                .build()
        }
        listOf(
            RElementBuilder<Alert.Props>::h1,
            RElementBuilder<Alert.Props>::h2,
            RElementBuilder<Alert.Props>::h3,
            RElementBuilder<Alert.Props>::h4,
            RElementBuilder<Alert.Props>::h5,
            RElementBuilder<Alert.Props>::h6,
        ).forEach { function ->
            subSectionTitle(function.name, section)
            Markdown {
                //language=Markdown
                +"""
Custom `${function.name}` which behaves the same but adds `${ClassNames.ALERT_HEADING.kt}` to `classes`.
            """
            }
            codeExample {
                +FunSpec.builder(function, false)
                    .nestedBy(Generic(RElementBuilder::class, Alert.Props::class))
                    .addParameter("classes", String::class, true, FunSpec.Parameter.NULL)
                    .addParameter("block", Generic("RDOMHandler", function.name.toUpperCase()))
                    .returns("ReactElement")
                    .build()
            }
        }
        subSectionTitle(closingElementName, section)
        p {
            +"Wrapper for a custom alert closing element."
        }
        codeExample {
            +FunSpec.builder(RElementBuilder<Alert.DismissibleProps>::closingElement, false)
                .nestedBy(Generic(RElementBuilder::class, Alert.DismissibleProps::class))
                .addParameter("block", "ElementProvider")
                .returns("ReactElement")
                .build()
        }
    }
}
