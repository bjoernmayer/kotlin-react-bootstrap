@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.components.alerts

import kotlinx.html.A
import kotlinx.html.DIV
import kotlinx.html.HtmlBlockTag
import kotlinx.html.SPAN
import react.RBuilder
import react.ReactElement
import react.bootstrap.components.alert.Alert
import react.bootstrap.components.alert.AlertBuilder
import react.bootstrap.components.alert.AlertDOMHandler
import react.bootstrap.components.alert.Alerts
import react.bootstrap.components.alert.h1
import react.bootstrap.components.alert.h2
import react.bootstrap.components.alert.h3
import react.bootstrap.components.alert.h4
import react.bootstrap.components.alert.h5
import react.bootstrap.components.alert.h6
import react.bootstrap.components.alert.link
import react.bootstrap.content.typography.heading.Heading
import react.bootstrap.lib.DOMTag
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.nestedName
import react.bootstrap.site.external.Markdown
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
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
            val variantName = variant.name.toLowerCase().capitalize()
            subSectionTitle(function.name)
            Markdown {
                //language=Markdown
                +"""
Creates an `alert` component with `$variantName` context.
                """
            }
            codeExample {
                +FunSpec.builder(function)
                    .nestedBy(RBuilder::Alerts)
                    .addParameter<String?>("classes", null)
                    .addParameter(
                        "props",
                        Generic.builder<PropHandler<*>, Alert.Props<*>>(),
                        default = FunCall.builder(
                            PropHandler::class.simpleName!!,
                            style = FunCall.Style.INLINE
                        ).setEmptyLambdaArgument().build()
                    )
                    .addParameter("block", Generic.builder<AlertDOMHandler<*>, DIV>())
                    .returns("ReactElement")
                    .build()
                +"\n"
                +FunSpec.builder(function)
                    .nestedBy(RBuilder::Alerts)
                    .nestedBy(AlertBuilder::dismissible)
                    .addParameter("fade", false)
                    .addParameter<String?>("classes", null)
                    .addParameter(
                        "props",
                        Generic.builder<PropHandler<*>, Alert.Dismissible<*>>(),
                        default = FunCall.builder(
                            PropHandler::class.simpleName!!,
                            style = FunCall.Style.INLINE
                        ).setEmptyLambdaArgument().build()
                    )
                    .addParameter("block", Generic.builder<AlertDOMHandler<*>, DIV>())
                    .returns("ReactElement")
                    .build()
            }
            Markdown {
                //language=Markdown
                +"""
Creates a generic `alert` component with $variantName context.
                """
            }
            codeExample {
                +FunSpec.builder(function, inline = true)
                    .nestedBy(RBuilder::Alerts)
                    .addTypeParameter("T", HtmlBlockTag::class, true)
                    .addParameter<String?>("classes", null)
                    .addParameter(
                        "props",
                        Generic.builder<PropHandler<*>, Alert.Props<*>>(),
                        default = FunCall.builder(
                            PropHandler::class.simpleName!!,
                            style = FunCall.Style.INLINE
                        ).setEmptyLambdaArgument().build()
                    )
                    .addParameter("block", Generic(AlertDOMHandler::class, "T"))
                    .returns("ReactElement")
                    .build()
                +"\n"
                +FunSpec.builder(function, inline = true)
                    .nestedBy(RBuilder::Alerts)
                    .addTypeParameter("T", HtmlBlockTag::class, true)
                    .nestedBy(AlertBuilder::dismissible)
                    .addParameter("fade", false)
                    .addParameter<String?>("classes", null)
                    .addParameter(
                        "props",
                        Generic.builder<PropHandler<*>, Alert.Dismissible.Props<*>>(),
                        default = FunCall.builder(
                            PropHandler::class.simpleName!!,
                            style = FunCall.Style.INLINE
                        ).setEmptyLambdaArgument().build()
                    )
                    .addParameter("block", Generic(AlertDOMHandler::class, "T"))
                    .returns("ReactElement")
                    .build()
            }
        }

        subSectionTitle(Alert.DomBuilder<*>::link.name)
        Markdown {
            //language=Markdown
            +"""
Creates a `${Alert.Link::class.nestedName}` element.
            """
        }
        codeExample {
            +FunSpec.builder(Alert.DomBuilder<*>::link)
                .nestedBy(Generic(Alert.DomBuilder::class, "*"))
                .addParameter<String?>("href", null)
                .addParameter<String?>("target", null)
                .addParameter<String?>("classes", null)
                .addParameter(
                    "props",
                    Generic.builder<PropHandler<*>, Alert.Link.Props>(),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic.builder<RDOMHandler<*>, A>())
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
                .nestedBy(Generic(Alert.DomBuilder::class, "*"))
                .addTypeParameter("T", DOMTag::class, true)
                .addParameter<Heading.Sizes>("size")
                .addParameter<String?>("classes", null)
                .addParameter(
                    "props",
                    Generic(PropHandler::class, Generic(Heading.Props::class, "T").build()),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic(RDOMHandler::class, "T"))
                .returns("ReactElement")
                .build()
        }
        listOf(
            Alert.DomBuilder<*>::h1,
            Alert.DomBuilder<*>::h2,
            Alert.DomBuilder<*>::h3,
            Alert.DomBuilder<*>::h4,
            Alert.DomBuilder<*>::h5,
            Alert.DomBuilder<*>::h6,
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
                    .nestedBy(Generic(Alert.DomBuilder::class, "*"))
                    .addParameter<String?>("classes", null)
                    .addParameter(
                        "props",
                        Generic(PropHandler::class, Generic(Heading.Props::class, function.name.toUpperCase()).build()),
                        default = FunCall.builder(
                            PropHandler::class.simpleName!!,
                            style = FunCall.Style.INLINE
                        ).setEmptyLambdaArgument().build()
                    )
                    .addParameter("block", Generic(RDOMHandler::class, function.name.toUpperCase()))
                    .returns("ReactElement")
                    .build()
            }
            Markdown {
                //language=Markdown
                +"""
Creates a generic `${Alert.Heading::class.nestedName}` element.
            """
            }
            codeExample {
                +FunSpec.builder(function, inline = true)
                    .nestedBy(Generic(Alert.DomBuilder::class, "*"))
                    .addTypeParameter("T", DOMTag::class, true)
                    .addParameter<String?>("classes", null)
                    .addParameter(
                        "props",
                        Generic(PropHandler::class, Generic(Heading.Props::class, "T").build()),
                        default = FunCall.builder(
                            PropHandler::class.simpleName!!,
                            style = FunCall.Style.INLINE
                        ).setEmptyLambdaArgument().build()
                    )
                    .addParameter("block", Generic(RDOMHandler::class, function.name.toUpperCase()))
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
                .nestedBy(Generic(Alert.DomBuilder::class, "*"))
                .addParameter(
                    "props",
                    Generic(
                        PropHandler::class,
                        Generic(Alert.Dismissible.ClosingElement.Props::class, SPAN::class).build()
                    ),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter("block", Generic.builder<RDOMHandler<*>, SPAN>())
                .returns("ReactElement")
                .build()
            +"\n"
            +FunSpec.builder(
                object : KFunction<ReactElement> {
                    override val name: String = "closingElement"
                },
                inline = true
            )
                .nestedBy(Generic(Alert.DomBuilder::class, "*"))
                .addTypeParameter("T", DOMTag::class, true)
                .addParameter(
                    "props",
                    Generic(
                        PropHandler::class,
                        Generic(Alert.Dismissible.ClosingElement.Props::class, SPAN::class).build()
                    ),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                )
                .addParameter(
                    "block",
                    Generic(RDOMHandler::class, "T")
                )
                .returns("ReactElement")
                .build()
        }
    }
}
