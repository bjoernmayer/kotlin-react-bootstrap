package react.bootstrap.site.components.docs.components.buttons

import kotlinx.html.ButtonFormEncType
import kotlinx.html.ButtonFormMethod
import kotlinx.html.ButtonType
import kotlinx.html.InputFormEncType
import kotlinx.html.InputFormMethod
import react.RBuilder
import react.bootstrap.components.button.Button
import react.bootstrap.site.components.docs.FunReference
import react.bootstrap.site.components.docs.fixings.SectionComponent
import react.bootstrap.site.components.docs.fixings.codeExample
import react.bootstrap.site.components.docs.fixings.contentTitle
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
            val buttonTypeArgs = setOf(
                FunReference.Argument(
                    "buttonType",
                    ButtonType::class.simpleName!!,
                    false,
                    "${ButtonType::class.simpleName}.${ButtonType.button.name}"
                ),
                FunReference.Argument(
                    "buttonFormEncType",
                    ButtonFormEncType::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "buttonFormMethod",
                    ButtonFormMethod::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "active",
                    Boolean::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "disabled",
                    Boolean::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "nowrap",
                    Boolean::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "sizes",
                    Button.Sizes::class.nestedName,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "blockSized",
                    Boolean::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "classes",
                    String::class,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "block",
                    "RHandler<${Button.Props::class.nestedName}>"
                )
            )
            codeExample {
                +FunReference(
                    solidFun,
                    solidButtonBuilderParents.toSet(),
                    buttonTypeArgs,
                    "ReactElement"
                ).print(false)

                outlineFun?.apply {
                    ln { }
                    +FunReference(
                        outlineFun,
                        outlineButtonBuilderParents.toSet(),
                        buttonTypeArgs,
                        "ReactElement"
                    ).print(false)
                }
            }
            contentTitle(RBuilder::h4, "Link Button")
            p {
                +"Adds a button in the \"$variantName\" context using the HTML anchor element."
            }
            val linkButtonArgs = setOf(
                FunReference.Argument(
                    "href",
                    String::class.simpleName!!,
                    true
                ),
                FunReference.Argument(
                    "target",
                    String::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "active",
                    Boolean::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "disabled",
                    Boolean::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "nowrap",
                    Boolean::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "sizes",
                    Button.Sizes::class.nestedName,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "blockSized",
                    Boolean::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "classes",
                    String::class,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "block",
                    "RHandler<${Button.Props::class.nestedName}>"
                )
            )
            codeExample {
                +FunReference(
                    solidFun,
                    solidButtonBuilderParents.toSet(),
                    linkButtonArgs,
                    "ReactElement"
                ).print(false)
                outlineFun?.apply {
                    ln { }
                    +FunReference(
                        outlineFun,
                        outlineButtonBuilderParents.toSet(),
                        linkButtonArgs,
                        "ReactElement"
                    ).print(false)
                }
            }
            contentTitle(RBuilder::h4, "Input Element Button")
            p {
                +"Adds a button in the \"$variantName\" context using one of the HTML input elements."
            }
            val inputElementButtonArgs = setOf(
                FunReference.Argument(
                    "value",
                    String::class.simpleName!!
                ),
                FunReference.Argument(
                    "name",
                    String::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "title",
                    String::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "type",
                    Button.Types.Input.Type::class.nestedName,
                    false,
                    Button.Types.Input.Type.BUTTON.ktN
                ),
                FunReference.Argument(
                    "inputFormEncType",
                    InputFormEncType::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "inputFormMethod",
                    InputFormMethod::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "active",
                    Boolean::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "disabled",
                    Boolean::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "nowrap",
                    Boolean::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "sizes",
                    Button.Sizes::class.nestedName,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "blockSized",
                    Boolean::class.simpleName!!,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "classes",
                    String::class,
                    true,
                    FunReference.Argument.NULL
                ),
                FunReference.Argument(
                    "block",
                    "RHandler<${Button.Props::class.nestedName}>"
                )
            )
            codeExample {
                +FunReference(
                    solidFun,
                    solidButtonBuilderParents.toSet(),
                    inputElementButtonArgs,
                    "ReactElement"
                ).print(false)
                outlineFun?.apply {
                    ln { }
                    +FunReference(
                        outlineFun,
                        outlineButtonBuilderParents.toSet(),
                        inputElementButtonArgs,
                        "ReactElement"
                    ).print(false)
                }
            }
        }
    }
}
