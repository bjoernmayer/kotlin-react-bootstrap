@file:Suppress("DuplicatedCode")

package react.bootstrap.site.components.docs.components.buttons

import kotlinx.html.ButtonFormEncType
import kotlinx.html.ButtonFormMethod
import kotlinx.html.ButtonType
import kotlinx.html.InputFormEncType
import kotlinx.html.InputFormMethod
import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.components.button.ButtonBuilder
import react.bootstrap.components.button.Buttons
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.contentTitle
import react.bootstrap.site.lib.codepoet.FunSpec
import react.bootstrap.site.lib.codepoet.Generic
import react.dom.h4
import react.dom.p

internal class Reference : SectionComponent() {
    override val title: String = "Reference"

    override fun RBuilder.render() {
        sectionTitle(section)
        mapOf(
            Button.Variants.Solid.DANGER to (solidDangerFun to outlineDangerFun),
            Button.Variants.Solid.DARK to (solidDarkFun to outlineDarkFun),
            Button.Variants.Solid.INFO to (solidInfoFun to outlineInfoFun),
            Button.Variants.Solid.LIGHT to (solidLightFun to outlineLightFun),
            Button.Variants.Solid.LINK to (solidLinkFun to null),
            Button.Variants.Solid.PRIMARY to (solidPrimaryFun to outlinePrimaryFun),
            Button.Variants.Solid.SECONDARY to (solidSecondaryFun to outlineSecondaryFun),
            Button.Variants.Solid.SUCCESS to (solidSuccessFun to outlineSuccessFun),
            Button.Variants.Solid.WARNING to (solidWarningFun to outlineWarningFun)
        ).forEach { entry ->
            val variantName = entry.key::class.normalName
            val (solidFun, outlineFun) = entry.value

            subSectionTitle(solidFun.name, section)
            contentTitle(RBuilder::h4, "Button Element")
            p {
                +"Adds a button in the \"$variantName\" context using the HTML button element."
            }
            val buttonTypeParameters = setOf(
                FunSpec.Parameter("buttonType", ButtonType::class, false, ButtonType.button),
                FunSpec.Parameter("buttonFormEncType", ButtonFormEncType::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("buttonFormMethod", ButtonFormMethod::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("active", Boolean::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("disabled", Boolean::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("nowrap", Boolean::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("sizes", Button.Sizes::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("blockSized", Boolean::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("classes", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("block", Generic("RHandler", Button.Props::class))
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
            contentTitle(RBuilder::h4, "Link Button")
            p {
                +"Adds a button in the \"$variantName\" context using the HTML anchor element."
            }
            val linkButtonParameters = setOf(
                FunSpec.Parameter("href", String::class, true),
                FunSpec.Parameter("target", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("active", Boolean::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("disabled", Boolean::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("nowrap", Boolean::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("sizes", Button.Sizes::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("blockSized", Boolean::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("classes", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("block", Generic("RHandler", Button.Props::class))
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
            contentTitle(RBuilder::h4, "Input Element Button")
            p {
                +"Adds a button in the \"$variantName\" context using one of the HTML input elements."
            }
            val inputElementButtonParameters = setOf(
                FunSpec.Parameter("value", String::class),
                FunSpec.Parameter("name", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("title", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("type", Button.Types.Input.Type::class, false, Button.Types.Input.Type.BUTTON),
                FunSpec.Parameter("inputFormEncType", InputFormEncType::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("inputFormMethod", InputFormMethod::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("active", Boolean::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("disabled", Boolean::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("nowrap", Boolean::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("sizes", Button.Sizes::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("blockSized", Boolean::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("classes", String::class, true, FunSpec.Parameter.NULL),
                FunSpec.Parameter("block", Generic("RHandler", Button.Props::class))
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
        }
    }
}
