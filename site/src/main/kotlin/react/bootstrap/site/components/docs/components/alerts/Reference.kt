@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.components.alerts

import kotlinx.html.A
import kotlinx.html.SPAN
import react.RBuilder
import react.RElementBuilder
import react.ReactElement
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.AlertBuilder
import react.bootstrap.components.alert.Alerts
import react.bootstrap.components.alert.h1
import react.bootstrap.components.alert.h2
import react.bootstrap.components.alert.h3
import react.bootstrap.components.alert.h4
import react.bootstrap.components.alert.h5
import react.bootstrap.components.alert.h6
import react.bootstrap.components.alert.link
import react.bootstrap.content.typography.heading.Heading
import react.bootstrap.lib.DomTag
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.FunSpec.Parameter.Modifier.CROSSINLINE
import react.bootstrap.site.lib.codepoet.FunSpec.Parameter.Modifier.NOINLINE
import react.bootstrap.site.lib.codepoet.Generic
import react.bootstrap.site.lib.codepoet.LambdaValue
import react.dom.p
import kotlin.reflect.KFunction

internal class Reference : SectionComponent() {
    override val title: String = "Reference"

    override fun RBuilder.render() {
        sectionTitle()
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
            subSectionTitle(function.name)
            p {
                +"Adds an alert component with the $variantName context."
            }
            codeExample {
                +FunSpec.builder(function)
                    .nestedBy(RBuilder::Alerts)
                    .addParameter<String?>("classes", null)
                    .addParameter("block", Generic("RHandler", Alert.Props::class))
                    .returns("ReactElement")
                    .build()
                +"\n"
                +FunSpec.builder(function)
                    .nestedBy(RBuilder::Alerts)
                    .nestedBy(AlertBuilder::dismissible)
                    .addParameter("fade", false)
                    .addParameter<String?>("classes", null)
                    .addParameter("block", Generic("RHandler", Alert.Dismissible.Props::class))
                    .returns("ReactElement")
                    .build()
            }
        }

        subSectionTitle(RElementBuilder<Alert.Props>::link.name)
        Markdown {
            //language=Markdown
            +"""
Creates a `${Alert.Link::class.nestedName}` element.
            """
        }
        codeExample {
            +FunSpec.builder(RElementBuilder<Alert.Props>::link)
                .nestedByGeneric<RElementBuilder<*>, Alert.Props>()
                .addParameter<String?>("href", null)
                .addParameter<String?>("target", null)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "handler",
                    Generic("RHandler", Alert.Link.Props::class),
                    default = LambdaValue("", LambdaValue.Style.INLINE).build()
                )
                .addParameter("block", Generic("RDOMHandler", A::class))
                .returns("ReactElement")
                .build()
        }
        subSectionTitle("heading")
        Markdown {
            //language=Markdown
            +"""
Creates a generic `${Alert.Heading::class.nestedName}` element.
            """
        }
        codeExample {
            +FunSpec.builder(
                object : KFunction<ReactElement> {
                    override val name: String = "heading"
                },
                inline = true
            )
                .nestedByGeneric<RElementBuilder<*>, Alert.Props>()
                .addTypeParameter("T", DomTag::class, true)
                .addParameter<Heading.Sizes>("size")
                .addParameter<String?>("classes", null)
                .addParameter(
                    "handler",
                    Generic("RHandler", Generic(Heading.Props::class, "T").build()),
                    default = LambdaValue("", LambdaValue.Style.INLINE).build(),
                    modifier = CROSSINLINE
                )
                .addParameter("block", Generic("RDOMHandler", "T"), modifier = NOINLINE)
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
            subSectionTitle(function.name)
            Markdown {
                //language=Markdown
                +"""
Creates a `${Alert.Heading::class.nestedName}` element.
            """
            }
            codeExample {
                +FunSpec.builder(function)
                    .nestedByGeneric<RElementBuilder<*>, Alert.Props>()
                    .addParameter<String?>("classes", null)
                    .addParameter(
                        "handler",
                        Generic("RHandler", Generic(Heading.Props::class, function.name.toUpperCase()).build()),
                        default = LambdaValue("", LambdaValue.Style.INLINE).build()
                    )
                    .addParameter("block", Generic("RDOMHandler", function.name.toUpperCase()))
                    .returns("ReactElement")
                    .build()
            }
            Markdown {
                //language=Markdown
                +"""
Creates a `${Alert.Heading::class.nestedName}` and uses `T` to render the element.
            """
            }
            codeExample {
                +FunSpec.builder(function, inline = true)
                    .nestedByGeneric<RElementBuilder<*>, Alert.Props>()
                    .addTypeParameter("T", DomTag::class, true)
                    .addParameter<String?>("classes", null)
                    .addParameter(
                        "handler",
                        Generic("RHandler", Generic(Heading.Props::class, "T").build()),
                        default = LambdaValue("", LambdaValue.Style.INLINE).build(),
                        modifier = CROSSINLINE
                    )
                    .addParameter("block", Generic("RDOMHandler", function.name.toUpperCase()), modifier = NOINLINE)
                    .returns("ReactElement")
                    .build()
            }
        }
        subSectionTitle("closingElement")
        p {
            +"Wrapper for a custom alert closing element."
        }
        codeExample {
            +FunSpec.builder(
                object : KFunction<ReactElement> {
                    override val name: String = "closingElement"
                }
            )
                .nestedByGeneric<RElementBuilder<*>, Alert.Dismissible.Props>()
                .addParameter(
                    "handler",
                    Generic("RHandler", Generic(Alert.Dismissible.ClosingElement.Props::class, SPAN::class).build()),
                    default = LambdaValue("", LambdaValue.Style.INLINE).build()
                )
                .addParameter("block", Generic("RDOMHandler", SPAN::class))
                .returns("ReactElement")
                .build()
            +"\n"
            +FunSpec.builder(
                object : KFunction<ReactElement> {
                    override val name: String = "closingElement"
                },
                inline = true
            )
                .nestedByGeneric<RElementBuilder<*>, Alert.Dismissible.Props>()
                .addTypeParameter("T", DomTag::class, true)
                .addParameter(
                    "handler",
                    Generic("RHandler", Generic(Alert.Dismissible.ClosingElement.Props::class, SPAN::class).build()),
                    default = LambdaValue("", LambdaValue.Style.INLINE).build(),
                    modifier = NOINLINE
                )
                .addParameter(
                    "block",
                    Generic("RDOMHandler", "T"),
                    modifier = NOINLINE
                )
                .returns("ReactElement")
                .build()
        }
    }
}
