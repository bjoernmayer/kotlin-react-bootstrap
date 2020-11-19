@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.components.buttons

import kotlinx.html.A
import kotlinx.html.BUTTON
import kotlinx.html.ButtonFormEncType
import kotlinx.html.ButtonFormMethod
import kotlinx.html.ButtonType
import kotlinx.html.INPUT
import kotlinx.html.InputFormEncType
import kotlinx.html.InputFormMethod
import kotlinx.html.LABEL
import react.RBuilder
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.ButtonComponent
import react.bootstrap.components.button.Buttons
import react.bootstrap.lib.component.PropHandler
import react.bootstrap.lib.component.RDOMHandler
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.lib.codepoet.FunCall
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
import react.dom.h4
import react.dom.p

internal class Reference : SectionComponent() {
    override val title: String = "Reference"

    override fun RBuilder.render() {
        sectionTitle()
        mapOf(
            ButtonComponent.Variants.Solid.DANGER to (solidDangerFun to outlineDangerFun),
            ButtonComponent.Variants.Solid.DARK to (solidDarkFun to outlineDarkFun),
            ButtonComponent.Variants.Solid.INFO to (solidInfoFun to outlineInfoFun),
            ButtonComponent.Variants.Solid.LIGHT to (solidLightFun to outlineLightFun),
            ButtonComponent.Variants.Solid.LINK to (solidLinkFun to null),
            ButtonComponent.Variants.Solid.PRIMARY to (solidPrimaryFun to outlinePrimaryFun),
            ButtonComponent.Variants.Solid.SECONDARY to (solidSecondaryFun to outlineSecondaryFun),
            ButtonComponent.Variants.Solid.SUCCESS to (solidSuccessFun to outlineSuccessFun),
            ButtonComponent.Variants.Solid.WARNING to (solidWarningFun to outlineWarningFun)
        ).forEach { entry ->
            val variantName = entry.key::class.normalName
            val (solidFun, outlineFun) = entry.value

            subSectionTitle(solidFun.name)
            h4("bd-content-title") { +"Button Element" }
            p {
                +"Adds a button in the \"$variantName\" context using the HTML button element."
            }
            val buttonTypeParameters = setOf(
                FunSpec.Parameter("formEncType", ButtonFormEncType::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("formMethod", ButtonFormMethod::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("type", ButtonType::class, false, ButtonType.button),
                FunSpec.Parameter("classes", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("active", Boolean::class, false, "false"),
                FunSpec.Parameter("disabled", Boolean::class, false, "false"),
                FunSpec.Parameter("nowrap", Boolean::class, false, "false"),
                FunSpec.Parameter("sizes", ButtonComponent.Sizes::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("blockSized", Boolean::class, false, "false"),
                FunSpec.Parameter(
                    "props",
                    Generic.builder<PropHandler<*>, ButtonComponent.Button.Props>(),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                ),
                FunSpec.Parameter("block", Generic.builder<RDOMHandler<*>, BUTTON>())
            )
            codeExample {
                +FunSpec.builder(solidFun)
                    .nestedBy(RBuilder::Buttons)
                    .nestedBy(ButtonBuilder::solid)
                    .apply {
                        buttonTypeParameters.forEach {
                            addParameter(it)
                        }
                    }
                    .returns("ReactElement")
                    .build()

                outlineFun?.apply {
                    appendLine("")
                    +FunSpec.builder(outlineFun)
                        .nestedBy(RBuilder::Buttons)
                        .nestedBy(ButtonBuilder::outline)
                        .apply {
                            buttonTypeParameters.forEach {
                                addParameter(it)
                            }
                        }
                        .returns("ReactElement")
                        .build()
                }
            }
            h4("bd-content-title") { +"Link Button" }
            p {
                +"Adds a button in the \"$variantName\" context using the HTML anchor element."
            }
            val linkButtonParameters = setOf(
                FunSpec.Parameter("href", String::class, true),
                FunSpec.Parameter("target", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("classes", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("active", Boolean::class, false, "false"),
                FunSpec.Parameter("disabled", Boolean::class, false, "false"),
                FunSpec.Parameter("nowrap", Boolean::class, false, "false"),
                FunSpec.Parameter("sizes", ButtonComponent.Sizes::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("blockSized", Boolean::class, false, "false"),
                FunSpec.Parameter(
                    "props",
                    Generic.builder<PropHandler<*>, ButtonComponent.Link.Props>(),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                ),
                FunSpec.Parameter("block", Generic.builder<RDOMHandler<*>, A>())
            )
            codeExample {
                +FunSpec.builder(solidFun)
                    .nestedBy(RBuilder::Buttons)
                    .nestedBy(ButtonBuilder::solid)
                    .apply {
                        linkButtonParameters.forEach {
                            addParameter(it)
                        }
                    }
                    .returns("ReactElement")
                    .build()
                outlineFun?.apply {
                    appendLine("")
                    +FunSpec.builder(outlineFun)
                        .nestedBy(RBuilder::Buttons)
                        .nestedBy(ButtonBuilder::outline)
                        .apply {
                            linkButtonParameters.forEach {
                                addParameter(it)
                            }
                        }
                        .returns("ReactElement")
                        .build()
                }
            }
            h4("bd-content-title") { +"Input Element Button" }
            p {
                +"Adds a button in the \"$variantName\" context using one of the HTML input button elements."
            }
            val inputElementButtonParameters = setOf(
                FunSpec.Parameter("type", ButtonComponent.Input.Type::class, false),
                FunSpec.Parameter("formEncType", InputFormEncType::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("formMethod", InputFormMethod::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("name", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("value", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("classes", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("active", Boolean::class, false, "false"),
                FunSpec.Parameter("disabled", Boolean::class, false, "false"),
                FunSpec.Parameter("nowrap", Boolean::class, false, "false"),
                FunSpec.Parameter("sizes", ButtonComponent.Sizes::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("blockSized", Boolean::class, false, "false"),
                FunSpec.Parameter(
                    "props",
                    Generic.builder<PropHandler<*>, ButtonComponent.Input.Props>(),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                ),
                FunSpec.Parameter("block", Generic.builder<RDOMHandler<*>, INPUT>())
            )
            codeExample {
                +FunSpec.builder(solidFun)
                    .nestedBy(RBuilder::Buttons)
                    .nestedBy(ButtonBuilder::solid)
                    .apply {
                        inputElementButtonParameters.forEach {
                            addParameter(it)
                        }
                    }
                    .returns("ReactElement")
                    .build()

                outlineFun?.apply {
                    appendLine("")
                    +FunSpec.builder(outlineFun)
                        .nestedBy(RBuilder::Buttons)
                        .nestedBy(ButtonBuilder::outline)
                        .apply {
                            inputElementButtonParameters.forEach {
                                addParameter(it)
                            }
                        }
                        .returns("ReactElement")
                        .build()
                }
            }
            h4("bd-content-title") { +"Check-/Radio-Box Button" }
            p {
                +"Adds a button in the \"$variantName\" context using check- or radio-boxes."
            }
            val boxButtonParameters = setOf(
                FunSpec.Parameter("type", ButtonComponent.Box.Type::class, false),
                FunSpec.Parameter("formEncType", InputFormEncType::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("formMethod", InputFormMethod::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("name", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("value", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("classes", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("active", Boolean::class, false, "false"),
                FunSpec.Parameter("disabled", Boolean::class, false, "false"),
                FunSpec.Parameter("nowrap", Boolean::class, false, "false"),
                FunSpec.Parameter("sizes", ButtonComponent.Sizes::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("blockSized", Boolean::class, false, "false"),
                FunSpec.Parameter(
                    "props",
                    Generic.builder<PropHandler<*>, ButtonComponent.Box.Props>(),
                    default = FunCall.builder(
                        PropHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                ),
                FunSpec.Parameter(
                    "input",
                    Generic.builder<RDOMHandler<*>, INPUT>(),
                    default = FunCall.builder(
                        RDOMHandler::class.simpleName!!,
                        style = FunCall.Style.INLINE
                    ).setEmptyLambdaArgument().build()
                ),
                FunSpec.Parameter("block", Generic.builder<RDOMHandler<*>, LABEL>())
            )
            codeExample {
                +FunSpec.builder(solidFun)
                    .nestedBy(RBuilder::Buttons)
                    .nestedBy(ButtonBuilder::solid)
                    .apply {
                        boxButtonParameters.forEach {
                            addParameter(it)
                        }
                    }
                    .returns("ReactElement")
                    .build()

                outlineFun?.apply {
                    appendLine("")
                    +FunSpec.builder(outlineFun)
                        .nestedBy(RBuilder::Buttons)
                        .nestedBy(ButtonBuilder::outline)
                        .apply {
                            boxButtonParameters.forEach {
                                addParameter(it)
                            }
                        }
                        .returns("ReactElement")
                        .build()
                }
            }
        }
    }
}
