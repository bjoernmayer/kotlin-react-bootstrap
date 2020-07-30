package react.bootstrap.site.components.docs.components

import react.RBuilder
import react.bootstrap.components.button.ButtonGroup
import react.bootstrap.components.button.Buttons
import react.bootstrap.components.button.buttonGroup
import react.bootstrap.site.components.docs.buildNestedName
import react.bootstrap.site.components.docs.fixings.CodeExampleBuilder

internal fun CodeExampleBuilder.importButtonsBuilder() {
    import(buildNestedName(RBuilder::Buttons.name, "components", "button"))
}

internal fun CodeExampleBuilder.importButtonGroup() {
    import(buildNestedName(ButtonGroup::class.simpleName!!, "components", "button"))
}

internal fun CodeExampleBuilder.importButtonGroupBuilder() {
    import(buildNestedName(RBuilder::buttonGroup.name, "components", "button"))
}
